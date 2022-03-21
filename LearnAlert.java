package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver(); 
		 driver.get("http://www.leafground.com/pages/Alert.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 
		 driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		 Alert alert= driver.switchTo().alert();
		 String Text = alert.getText();
		 System.out.println(Text);
		 alert.accept();
		 
		 driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		 Alert alert1= driver.switchTo().alert();
		 String Text1 = alert.getText();
		 System.out.println(Text1);
		 alert1.accept();
		 
		 driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		 Alert alert2= driver.switchTo().alert();
		 String Text2 = alert.getText();
		 System.out.println(Text2);
		 alert2.sendKeys("SABARINATH");
		 alert2.accept();
		 
	}

}
