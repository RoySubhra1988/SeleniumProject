import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		WebElement move = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		
		WebElement Search = driver.findElement(By.id("twotabsearchtextbox"));
		
		
		
	Actions a = new Actions(driver);
	
	//Type in Capital alphabet
	
	a.moveToElement(Search).click().keyDown(Keys.SHIFT).sendKeys("mouse").build().perform();
	
	//performing context/right click and double click
	
	//a.moveToElement(move).contextClick().build().perform();
	
	a.moveToElement(move).doubleClick().build().perform();
	
	//MouseOver to an specific element
	
	a.moveToElement(move).build().perform();
	
	
		

	}

}
