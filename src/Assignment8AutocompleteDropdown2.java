import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8AutocompleteDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Uni");
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;

		String script = "return document.getElementById(\"autocomplete\").value;";
		String text=(String) js.executeScript(script);
		System.out.println(text);
		int i =0;
		while(!text.equalsIgnoreCase("United States (USA)"))
		{
		i++;
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);

		text=(String) js.executeScript(script);
		System.out.println(text);
		if(i>10)
		{
		break;
		}

		}

		if(i>10)
		{
		System.out.println("Element not found");
		}
		else
		{
		System.out.println("Element  found");
		}

		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
