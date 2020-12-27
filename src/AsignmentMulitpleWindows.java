import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AsignmentMulitpleWindows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com");
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());//Printing the parent window content
		
		driver.findElement(By.cssSelector("div.example a")).click();// clicking on the click here link
		
		
		//handling the multiple window
		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String> it = windowIds.iterator();
		
		String parentWindowId = it.next();
		
		String childWindowId = it.next();
		
		// Switching to the child window
		driver.switchTo().window(childWindowId);
		
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());// Printing the child window content
		
		// Switching back to the Parent window
		driver.switchTo().window(parentWindowId);
		
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText()); //Printing the parent window content
		
		driver.quit();
	}

}
