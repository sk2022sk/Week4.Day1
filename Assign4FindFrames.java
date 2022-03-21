package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4FindFrames {

	public static void main(String[] args) {
		// Step1: Load URL 
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver=new ChromeDriver(); 
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//find the Elements by tagname - iframe
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		
		//Store it in a list
		findElements.addAll(findElements);
		System.out.println("No Of Frames is : " +findElements.size());
		
		//close Browser
		driver.close();

	}

}
