import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericDropdownMethod {

	
	static WebDriver driver;
	
	
	public static void selectDropDown(By locator, String type, String value) {
	
		
		Select select = new Select(getElement(locator));
		
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


	public static WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		return driver.findElement(locator);
	}
	
}
