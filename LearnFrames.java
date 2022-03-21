package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 
		 
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button [text() = 'Try it']")).click();
		 
		 Alert alert = driver.switchTo().alert();
		 alert.sendKeys("Sabarinath");
		 alert.accept();
		 
		 WebElement findElement = driver.findElement(By.xpath("//p [@id= 'demo']"));
		 String text = findElement.getText();
		 
		 if(text.contains("Sabarinath"))
		 {
			 System.out.println("Given Text Sabarinath was appeared on it " + text);
		 }
		 else
		 {
			 System.out.println("Given Text Sabarinath was Not appeared on it " + text);
		 }
	}

}
