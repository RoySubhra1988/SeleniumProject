import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	static String airline = "Emirates";
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");

		Select s1 = new Select(driver.findElement(By.id("Adults")));
		s1.selectByValue("3");

		Select s2 = new Select(driver.findElement(By.id("Childrens")));
		s2.selectByValue("2");

		driver.findElement(By.id("DepartDate")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.id("MoreOptionsLink")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys(airline);

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

		driver.close();

	}

}
