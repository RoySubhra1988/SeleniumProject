import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyCheckbox {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Thread.sleep(2000);
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//Count of number of check boxes present in the page
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.close();
		
		

	}

}
