package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign5Irctc {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

//Click on OK button in the dialog 
		driver.findElement(By.xpath("//button [text() = 'OK']")).click();
		 
//Click on FLIGHTS link
		 driver.findElement(By.xpath("//span [@class = 'allcircle circleone']")).click();
		 Set<String> allWindowsHandle = driver.getWindowHandles();
		 List <String> allWindowsHandleList = new ArrayList <String>(allWindowsHandle);

//Switch to the Second Browser
		 driver.switchTo().window(allWindowsHandleList.get(1));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (200));
		 wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button [@class ='izooto-optin--cta izooto-optin--cta-later']"))));
		 driver.findElement(By.xpath("//button [@class ='izooto-optin--cta izooto-optin--cta-later']")).click();
		
//Print the customer care email id
			driver.findElement(By.xpath("//a [text() = 'Contact Us']")).click();
			String email = driver.findElement((By.xpath("//a [contains (text() , '@irctc.co.in')]" ))).getText();
			System.out.println("The Customer care email id is : " +email);
			
//Close the browser
			driver.quit();

	}

}
