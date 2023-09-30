package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).doubleClick().sendKeys("iphone").build().perform();
	}

}
