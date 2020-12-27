import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingUsingSeleniumJavaStream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver"); 

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
  
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
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
      
      //Scan the name column and print the price of all the items
      
    List<String> price =  elementList.stream().map(s->getPrice(s)).collect(Collectors.toList());
      
    price.forEach(s->System.out.println(s));
    
    System.out.println("****************************");
       

 List<String> priceForSpecificItem;
	
    //Scan the name column for Banana and print the price of Banana with pagination concept
    
    do {
    	List<WebElement> elementList1 = driver.findElements(By.xpath("//tr/td[1]"));
    
    priceForSpecificItem =  elementList1.stream().filter(s->s.getText().contains("Wheat")).map(s->getPrice(s)).collect(Collectors.toList());
     
    priceForSpecificItem.forEach(s->System.out.println(s));
      
    if(priceForSpecificItem.size()<1) {
    	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
    }
    }while(priceForSpecificItem.size()<1);
  
	}
	
	

	private static String getPrice(WebElement s) {
		
	String priceValue =	s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
