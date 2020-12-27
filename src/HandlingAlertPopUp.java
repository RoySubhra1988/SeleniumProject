import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertPopUp {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		String hasib = "Hasib";
		
		String tanu = "Tanu";
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(hasib);
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		String text1 = driver.switchTo().alert().getText();
		
		if(text1.contains(hasib)) {
			
			System.out.println(hasib + " is present in " + text1);
			
		}else {
			System.out.println(hasib + " is not present in " + text1);
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys(tanu);
		Thread.sleep(2000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		String text2 = driver.switchTo().alert().getText();
		
		if(text2.contains(tanu)) {
			
			System.out.println(tanu + " is present in " + text2);
			
		}else {
			System.out.println(tanu + " is not present in " + text2);
		}
		
		driver.switchTo().alert().dismiss();
		

	}

}
