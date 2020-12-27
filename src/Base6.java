import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base6  {
	
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		Select select = new Select(driver.findElement(By.id("Form_submitForm_NoOfEmployees")));
//		
//		Select select1 = new Select(driver.findElement(By.id("Form_submitForm_Industry")));
//		
//		Select select2 = new Select(driver.findElement(By.id("Form_submitForm_Country")));
//		
//		
//		select.selectByIndex(3);
//		
//		select1.selectByValue("Aerospace");
//		
//		select2.selectByVisibleText("Australia");
		
		
		By noOfEmployees = By.id("Form_submitForm_NoOfEmployees");
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
//		selectDropdownByIndex(noOfEmployees, 2);
//		
//		selectDropdownByValue(industry, "Automotive");
//		
//		selectDropdownByVisibleText(country, "Bangladesh");
		
		selectDropDownSwitchCase(noOfEmployees,"index", "3");
		
		selectDropDownSwitchCase(industry, "value", "Education");
		
		selectDropDownSwitchCase(country, "visibleText", "Bangladesh");
		
		selectDropDownSwitchCase(country, "visiblekext", "Bangladesh");
		
		
	}
	
//	public static void selectDropDownIfElse(By locator, String type, String value) {
//		
//		Select select = new Select(driver.findElement(locator));
//		
//		if(type == "index") {
//			select.selectByIndex(Integer.parseInt(value));
//		}else if(type == "value") {
//			
//			select.selectByValue(value);
//			
//		}else if(type == "visibleText") {
//			select.selectByVisibleText(value);
//		}else {
//			System.out.println("Please pass the correct type");
//		}
//		
//	}
	
public static void selectDropDownSwitchCase(By locator, String type, String value) {
	
		
		Select select = new Select(driver.findElement(locator));
		
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;
			
			default:
				System.out.println("Please pass the correct type");
		}
	
	}

	public static void  selectDropdownByIndex(By locator, int index) {
		
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
		
	}
	
	public static void  selectDropdownByValue(By locator, String value) {
		
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
		
	}
	public static void  selectDropdownByVisibleText(By locator, String visibleText) {
		
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(visibleText);
		
	}

}
