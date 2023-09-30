package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleLogin {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		String email = "mobisect@gmail.com";
		
		driver.findElement(By.id("identifierId")).sendKeys(email);
		
		driver.findElement(By.xpath("(//span[@jsname=\"V67aGc\"])[2]")).click();
		
		
		
		
		
	}

}
