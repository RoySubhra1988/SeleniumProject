import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'login1')]")).sendKeys("RealState");
		driver.findElement(By.cssSelector("#password")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[contains(@value,'Sign in')]")).click();
		System.out.println(driver.findElement(By.xpath("//b[contains(text(),'Temporary')]")).getText());

	}

}
