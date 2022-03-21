package week4.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) 
	
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//Enter UserName and Password Using Id Locator
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		WebElement login=driver.findElement(By.className("decorativeSubmit"));
		login.click();
		
		//Click on CRM/SFA Link
		WebElement link=driver.findElement(By.linkText("CRM/SFA"));
		link.click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		 
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath(" (//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
         Set<String> handler=driver.getWindowHandles();
         Iterator<String> itr = handler.iterator();
         String parentWindowID=itr.next();
         System.out.println("Parent window is"+parentWindowID);
         
         String childWindowID=itr.next();
         System.out.println("child window is"+childWindowID);
         driver.switchTo().window(childWindowID);
         
        //Click on First Resulting Contact
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
	    
	   driver.switchTo().window(parentWindowID);
	    System.out.println("parent window title is"+driver.getTitle());
	      
	    
	    //Click on Widget of To Contact
	    driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
	    
	  
	    Set<String> handler1= driver.getWindowHandles();
        Iterator<String> itr1 = handler1.iterator();
        String parentWindowID1=itr1.next();
        System.out.println("Parent window is"+parentWindowID1);
	    
	    
	    String childWindowID1=itr1.next();
        driver.switchTo().window(childWindowID1);
        System.out.println("child window title is"+driver.getTitle());
        
        
        //Click on Second Resulting Contact
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
        driver.switchTo().window(parentWindowID1);
        System.out.println("parent window title is"+driver.getTitle());
        
        //click on merge button
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        
        //accept the alert
        Alert alert1= driver.switchTo().alert();
		alert1.accept();
		
		//verify the title of the page
		System.out.println("the title of the page is"+driver.getTitle());

		
	}

}
