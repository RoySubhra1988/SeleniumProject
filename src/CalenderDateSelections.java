import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderDateSelections {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		 WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cleartrip.com/");
		
		driver.findElement(By.cssSelector("input[id='RoundTrip']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='RoundTrip']")).isSelected());
		
		driver.findElement(By.id("DepartDate")).click();
		
		//String month = driver.findElement(By.cssSelector("[class='ctDatePicker'] [class='monthBlock first'] [class='ui-datepicker-month']")).getText();
		//String year = driver.findElement(By.cssSelector("[class='ctDatePicker'] [class='monthBlock first'] [class='ui-datepicker-year']")).getText();
		
		datePicker(driver, "June", "2021", 20);
		Thread.sleep(3000);
		datePicker(driver, "December", "2021", 10);
		
		
	}
	
	public static void datePicker(WebDriver driver, String month, String year, int date ) {

		
		while(!driver.findElement(By.cssSelector("[class='ctDatePicker'] [class='monthBlock first'] [class='ui-datepicker-month']")).getText().contains(month) || !driver.findElement(By.cssSelector("[class='ctDatePicker'] [class='monthBlock first'] [class='ui-datepicker-year']")).getText().contains(year)) {
			
			driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
			
		}
		
		
		List<WebElement> day = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		
		int count = day.size();
		
		
		for(int i = 0; i<count; i++) {
			String dayNumber = driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			
			if(dayNumber.equalsIgnoreCase(String.valueOf(date))) {
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
				break;
			}
		}
		

	}

}
