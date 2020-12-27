import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
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
