import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Assert.assertEquals(driver.getTitle(),
				"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");

		Select select = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));

		select.selectByIndex(1);

		Thread.sleep(1000);

		select.selectByValue("AED");

		Thread.sleep(1000);

		select.selectByVisibleText("USD");

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for (int i = 1; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		for (int i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}

		for (int i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncInf")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 3 Child, 3 Infant");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Goa (GOI)')]")).click();
		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();
		// driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[3]")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='CCU']"))
				.click();
		// driver.close();

		driver.findElement(By.id("autosuggest")).sendKeys("BAN");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("Bangladesh")) {

				option.click();

				break;

			}

		}

		Thread.sleep(2000);
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

		Assert.assertFalse(
				driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();

		Assert.assertTrue(
				driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("Its enabled.");
			Assert.assertTrue(true);

		} else {
			System.out.println("Its not enabled.");
			Assert.assertTrue(false);
		}

	}

}
