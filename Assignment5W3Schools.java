package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5W3Schools {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement frame = driver.findElement(By.xpath("//div/iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		WebElement elementAlert1 = driver.findElement(By.xpath("//button[text()='Try it']"));
		elementAlert1.click();
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		
		if(text.contains("pressed")) {
			System.out.println("You clicked on Try It Button");
		}
		else {
			System.out.println("You did not Click on Try It Button");
		}
	}

}
