import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base5 {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com");
		
		driver.findElement(By.xpath("//div[@id='mainContent']/div[5]/ul/li[1]/following-sibling::li[6]")).click();
		


	}

}
