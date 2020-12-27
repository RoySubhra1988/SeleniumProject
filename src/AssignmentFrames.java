import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));

		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		
		driver.switchTo().frame("id");
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.close();
		

	}

}
