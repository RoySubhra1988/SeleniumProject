import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyWebTablesroting extends GenericDropdownMethod {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver"); 

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
  
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
      // Thread.sleep(3000);
        
       
        
    // selectDropDown(pageSelect, "value", "20");

		Select select = new Select(driver.findElement(By.id("page-menu")));

		//select.selectByIndex(1);

		//Thread.sleep(1000);

		select.selectByValue("20");
        
        //Click on the Column header
     driver.findElement(By.xpath("//tr/th[1]")).click();
        
        // capture all webelements and store in to a list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        
        //capture the text of all webelements and store in to a new(original) list
      List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
      
        // sort the original list of step 3 and store into a sorted list
       List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sroted list
       
       //Assert.assertTrue(originalList.equals(sortedList));
      
      if( originalList.equals(sortedList)) {
    	  
    	  originalList.stream().forEach(s->System.out.println(s));
    	  
    	  System.out.println("All the above items matches with the below lists");
    	 
    	  sortedList.stream().forEach(s->System.out.println(s));
    	  
      }else {
    	  System.out.println("Does not Match");
      }
      

	}

}
