import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksValidation {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver"); 

        WebDriver driver = new ChromeDriver();
  
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
     
      /* WebElement footer = driver.findElement(By.id("gf-BIG"));
       
       List<WebElement> links = footer.findElements(By.tagName("a"));
       
       //int count = footer.findElements(By.tagName("a")).size();
       
       for(int i=0; i<=links.size(); i++) {
    	   
    	   String url = links.get(i).getAttribute("href");
           
           HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
           
           conn.setRequestMethod("HEAD");
           conn.connect();
           int responseCode = conn.getResponseCode();
           System.out.println(responseCode);
           
           if(responseCode>=400) {
        	   System.out.println("The link with the text "+ links.get(i).getText()+ " is broken and the response code is "+ responseCode );
        	   break;
           }else {
        	   System.out.println("The link with the text "+ links.get(i).getText()+ " is working fine and the response code is "+ responseCode);
           }
           
    	  
       }*/
        
        SoftAssert soft = new SoftAssert();
       
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        System.out.println(links.size());
        
        for(WebElement link : links) {
        	
        
        	String url = link.getAttribute("href");
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(link.getText()+ " - "  + responseCode);
            soft.assertTrue(responseCode<400, "The link with the text "+ link.getText()+ " is broken and the response code is "+ responseCode );
            
            
           /* if(responseCode>400) {
         	   System.out.println("The link with the text "+ link.getText()+ " is broken and the response code is "+ responseCode );
         	   Assert.assertTrue(false);
         	  // break;
            }else {
         	   System.out.println("The link with the text "+ link.getText()+ " is working fine and the response code is "+ responseCode);
            }*/
            
            
        }
        soft.assertAll();
	}

}
