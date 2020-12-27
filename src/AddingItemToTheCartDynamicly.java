import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddingItemToTheCartDynamicly {
	
	static String[] itemsNeeded= {"Water Melon", "Walnuts", "Mango", "Apple", "Potato", "Brocolli"};

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
		
		/*List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		
		for (int i=0; i<products.size();i++) {
			
			String[] name = products.get(i).getText().split("-");
			
			String formattedName = name[0].trim();
			
			//System.out.println(formattedName);
			
			List itemNeededList = Arrays.asList(itemsNeeded);
			
			int j=0;
			
			if (itemNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println(driver.findElement(By.cssSelector("button.added")).getText());
				Assert.assertEquals(driver.findElement(By.cssSelector("button.added")).getText(), "✔ ADDED");
				if(j==itemsNeeded.length) {
					break;
				}
			}
			
		}*/
		
		addItems(driver , itemsNeeded);
	}
	
	public static void addItems(WebDriver driver , String[] itemsNeeded) {
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		
		for(int i =0; i<products.size();i++) {
			
			String[] name=products.get(i).getText().split("-");

			String formattedName=name[0].trim();
			
		List itemNeededList = Arrays.asList(itemsNeeded);
			
			if(itemNeededList.contains(formattedName)) {
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println(driver.findElement(By.cssSelector("button.added")).getText());
				Assert.assertEquals(driver.findElement(By.cssSelector("button.added")).getText(), "✔ ADDED");
				if(j==itemsNeeded.length)

				{

				break;

				}
			}
			
		}
		
		

	}

}
