import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProjectE2E {
	
	@FindBy(how = How.ID, using = "ctl00_mainContent_DropDownListCurrency")
	public static WebElement currency;
	
	 static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		 driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		By currency = By.id("ctl00_mainContent_DropDownListCurrency");
		
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected())
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Goa (GOI)')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='CCU']")).click();
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{

		System.out.println("its disabled");

		Assert.assertTrue(true);

		}

		else

		{

		Assert.assertTrue(false);

		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		for(int i =1;i<3;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		selectDropDown(currency, "value", "USD");
		
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		driver.close();
	}
	
public static void selectDropDown(By locator, String type, String value) {
	
	
		Select select = new Select((driver.findElement(locator)));
		
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

}
