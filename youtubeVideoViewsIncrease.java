package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class youtubeVideoViewsIncrease {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/@mobisec4594");
		
		String click = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		for (int i = 0; i < 5; i ++) {
			driver.findElement(By.xpath("//a[text()='Cyber Physical Systems Explained']")).sendKeys(click);
		}
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
		
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				String title = driver.getTitle();
				System.out.println(title);
			}
		
		
		
		
		
		
		
	}

}
