import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableStreamFilter {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver"); 

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
  
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        driver.findElement(By.id("search-field")).sendKeys("Tomato");
        
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        
        List<WebElement> actualList =  elementList.stream().filter(s->s.getText().contains("To")).collect(Collectors.toList());
 
        Assert.assertEquals(elementList.size(),actualList.size());
        
        if( elementList.equals(actualList)) {
      	  
        	elementList.stream().map(s->s.getText()).forEach(s->System.out.println(s));
      	  
      	  System.out.println("All the above items matches with the below lists");
      	 
      	actualList.stream().map(s->s.getText()).forEach(s->System.out.println(s));
      	  
        }else {
      	  System.out.println("Does not Match");
        }
	}

}
