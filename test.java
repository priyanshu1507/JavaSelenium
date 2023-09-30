package selenium;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		
//		System.out.println(window);
		
		String ParentId = it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String mail = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		System.out.println(mail);
		
		driver.switchTo().window(ParentId);
		
		driver.findElement(By.id("username")).sendKeys(mail);
		
		

}
}
