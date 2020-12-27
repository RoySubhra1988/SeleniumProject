import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotClass {
	
	public static void main(String[] args) throws IOException {
	
	System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("//Users//subhraroy//eclipse-workspace//SeleniumProject//src//ScreenShot.png"));

 }
}
