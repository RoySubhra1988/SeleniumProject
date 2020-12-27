import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinks {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));

		
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		
		WebElement discountCoupons = footer.findElement(By.xpath("table/tbody/tr/td[1]/ul"));
		
		System.out.println(discountCoupons.findElements(By.tagName("a")).size());
		
		for(int i =1;i<discountCoupons.findElements(By.tagName("a")).size();i++) {
			
			String clinkandOpenNewTab = Keys.chord(Keys.COMMAND,Keys.ENTER);
			
			discountCoupons.findElements(By.tagName("a")).get(i).sendKeys(clinkandOpenNewTab);
			
			
		}

		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String> it = windowIds.iterator();
		while(it.hasNext()) {
		
		String childWindowId = it.next();
		
		// Switching to the child window
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		
		}
		driver.quit();
	}

}
