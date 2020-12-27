import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWebTableExercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver"); 

        WebDriver driver = new ChromeDriver();
  
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
       WebElement  table = driver.findElement(By.cssSelector("div[class='left-align'] table[id='product']"));
       
       int rowCount= table.findElements(By.cssSelector("tr")).size();
       
       System.out.println(rowCount);
       
       //div[class='left-align'] table[id='product'] tr:nth-child(3)
       int columnCount = table.findElements(By.cssSelector("tr")).get(1).findElements(By.tagName("td")).size();
       System.out.println(columnCount);
       
       System.out.println(table.findElement(By.cssSelector("tr:nth-child(3)")).getText());
	}

}
