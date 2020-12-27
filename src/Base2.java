import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base2 {
	
	 @FindBy(how = How.CSS, using = "form#loginForm > div > div:nth-of-type(3)")
	    public static WebElement loginButton;
	
	 static WebDriver driver;
	
	
	public static boolean isClickable(WebElement el) 
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
System.setProperty("webdriver.edge.driver", "//Users//subhraroy//Downloads//edgedriver_mac64//msedgedriver");
		
		driver = new EdgeDriver();
//		
//		driver.get("https://www.linkedin.com");
//		
//		System.out.println(driver.getTitle());
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.get("https://www.facebook.com");
//		
//		System.out.println(driver.getTitle());
//		
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.navigate().back();
//		driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("SubhraHasib");
//		
//		driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("123456789");
//		
//		driver.findElement(By.cssSelector("button.sign-in-form__submit-button")).click();
//		
//		System.out.println(driver.findElement(By.xpath("//*[@class='alert-content']")).getText());
		
		driver.get("https://www.instagram.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		System.out.println(driver.findElement(By.cssSelector("form#loginForm > div > div:nth-of-type(3)")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("form#loginForm > div > div:nth-of-type(3)")).isDisplayed());
		
		System.out.println(driver.findElement(By.cssSelector("form#loginForm > div > div:nth-of-type(3)")).isSelected());
		
		boolean bool = Base2.isClickable(loginButton);
		
		System.out.println(bool);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456778990");
		Thread.sleep(2000);
		
		System.out.println(Base2.isClickable(loginButton));
		//driver.findElement(By.cssSelector("form#loginForm > div > div:nth-of-type(3)")).click();
		
		//driver.close();
		
		driver.quit();

	}

}
