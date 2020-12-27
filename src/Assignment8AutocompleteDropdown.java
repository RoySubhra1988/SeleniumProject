import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8AutocompleteDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("United States (USA)")) {

				option.click();

				break;

			}

		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
