package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleTabTitle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		
		System.out.println(link.size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement newItem = footer.findElement(By.xpath("(//div[@id=\"gf-BIG\"]/table/tbody/tr/td)[1]"));
		
		System.out.println("In first section total links are " + newItem.findElements(By.tagName("a")).size());
		
		String key = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		for (int i = 1; i < newItem.findElements(By.tagName("a")).size(); i++) {
			
			newItem.findElements(By.tagName("a")).get(i).sendKeys(key);
			
		}
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		while ( it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
		
	}

}
