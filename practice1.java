package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practice1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] items = {"Brocolli", "Cucumber", "Beans", "Tomato"};
		addCart(driver, items);
		buyProduct(driver, w);

		

	}
	public static void addCart(WebDriver driver, String[] items) {
		List<WebElement> product = driver.findElements(By.className("product-name"));
		int j = 0;

		for (int i = 0; i < product.size(); i++) {
			String[] item = product.get(i).getText().split(" ");
//			String newItem = item[0].trim();
			
			
			
			List newVeg = Arrays.asList(items);

			if (newVeg.contains(item[0])) {
				j++;
				driver.findElements(By.className("product-action")).get(i).click();
				
				if (j==newVeg.size()) {
					break;
				}
			}

		}
	}
	
	public static void buyProduct(WebDriver driver, WebDriverWait w) {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("RahulShettyAcademy");
		driver.findElement(By.className("promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}
}
