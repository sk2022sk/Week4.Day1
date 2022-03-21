package week4.day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2ServiceNowFrames {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://dev92692.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 
		//Enter username (Check for frame before entering the username)
		//Focus/Switch to iframe		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input [@id = 'user_name']")).sendKeys("admin");
		
		//Step3: Enter password / Password@123
		driver.findElement(By.xpath("//input [@id='user_password']")).sendKeys("Lion@543211");
		
		//		Step4: Click Login
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		//Step5: Search “incident “ Filter Navigator
		//Switch back tp main page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		
		//Step6: Click “All”
		driver.findElement(By.xpath("(//div [text() = 'All'])[2]")).click();
		
		//Step7: Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button [@id = 'sysverb_new']")).click();
		
		//Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.xpath("//button[@id = 'lookup.incident.caller_id']")).click();
		
		//Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String itr1 = iterator.next();
		String itr2 = iterator.next();
		driver.switchTo().window(itr2);
		String callerName = driver.findElement(By.xpath("(//a [@class ='glide_ref_item_link'])[1]")).getText();
		System.out.println(callerName);
		driver.findElement(By.xpath("(//a [@class ='glide_ref_item_link'])[1]")).click();
		
		//Switch to old window
		 Thread.sleep(2000);
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (200));
		 //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		 //driver.switchTo().frame("gsft_main");
		driver.switchTo().window(itr1);
		driver.switchTo().frame("gsft_main");
		
		// Enter value for short_description
		driver.findElement(By.xpath("//input [@id = 'incident.short_description']")).sendKeys("SABARI");
		
		//Step9: Read the incident number and save it a variable
		
		 WebElement element = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']"));
		 String incidentNumber = element.getAttribute("value");
		System.out.println("The newly created incident number is : " +incidentNumber);
		
		//Step10: Click on Submit button
		driver.findElement(By.xpath("(//button [@class = 'form_action_button header  action_context btn btn-default'])[1]")).click();
		
		
		//Step 11: Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("(//input [@class  = 'form-control'])[1]")).sendKeys(incidentNumber);
		driver.findElement(By.xpath("(//input [@class  = 'form-control'])[1]")).sendKeys(Keys.ENTER);
		
		//Step12: Verify the incident is created successful and take snapshot of the created incident.
		WebElement elementTable = driver.findElement(By.xpath("//table [@id = 'incident_table']"));
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		WebElement secondRow = rows.get(2);
		
		List<WebElement> cols = secondRow.findElements(By.tagName("td"));
		WebElement eachCols = cols.get(2);
		String incidentNum = eachCols.getText();
		System.out.println(incidentNum);
		if (incidentNum.contains(incidentNumber))
		{
			System.out.println("The incident Number is verified successfully and snapshot captured");
			//Taking Snapshot
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			
			//Create an image to store the screenshot
			File image = new File ("./Snapshots/image001.jpg");
			
			//Merging
			FileUtils.copyFile(screenshotAs, image);
		}
		
		
		driver.close();
		


	}

}
