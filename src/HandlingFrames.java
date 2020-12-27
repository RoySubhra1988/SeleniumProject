import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));

		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[contains(text(),'Button')]")).click();
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
	}

}
