package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign3Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		 
		 //Enter the text inside the Topic
		 driver.switchTo().frame("frame1");
		 driver.findElement(By.xpath("//b[@id ='topic']/following::input")).sendKeys("SABARINATH");
		 
		 //Enter into the nested frame and Check the check box
		 driver.switchTo().frame("frame3");
		 driver.findElement(By.xpath("//b [text() ='Inner Frame Check box :']/following::input")).click();
		 
		 //Switch to parent frame
		 driver.switchTo().defaultContent();
		 
		 //Switch to the new frame and select the Animals Drop down
		 driver.switchTo().frame("frame2");
		 
		 //Dropdown Select implemented
		 WebElement element = driver.findElement(By.xpath("//select [@id='animals']"));
		 Select dropDown = new Select (element);
		 dropDown.selectByValue("avatar");
		 System.out.println("Frame assignment completed successfully");
		 
		// driver.close();

	}

}
