import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignmemt6PracticeExercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// check the checkbox
		driver.findElement(By.id("checkBoxOption3")).click();
		
		// string the checkbox value in to a String variable
		String label = driver.findElement(By.id("checkBoxOption3")).getAttribute("value");
	
		System.out.println(label);
		
		//selecting the dropdown by using the label
		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));

		select.selectByValue(label);
		
		//Entering the label into the alert edit box 
		
		driver.findElement(By.id("name")).sendKeys(label);
		
		//Clicking the alert button
		driver.findElement(By.id("alertbtn")).click();
		
		//verifying the label is present in the Alert text
		
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(label)) {
			
			System.out.println(label + " is present in " + alertText);
			
		}else {
			System.out.println(label + " is not present in " + alertText);
		}
		driver.switchTo().alert().accept();
		
		driver.close();
		
		

	}

}
