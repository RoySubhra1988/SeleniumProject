import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.gecko.driver", "//Users//subhraroy//Desktop//BrowserDriver//geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.linkedin.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.get("https://www.facebook.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("SubhraHasib");
		
		driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("123456789");
		
		driver.findElement(By.cssSelector("button.sign-in-form__submit-button")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@class='alert-content']")).getText());
		
		driver.close();

	}

}
