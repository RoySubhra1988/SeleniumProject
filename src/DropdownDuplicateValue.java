import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownDuplicateValue {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//subhraroy//Desktop//BrowserDriver//chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		System.out.println(isSelectOptionsRepeating(country));

	}
	public static boolean isSelectOptionsRepeating(WebElement dropdown)
	{
	    Select s = new Select(dropdown);
	    List<WebElement> list = s.getOptions();
	    
	   // list.stream().map(c->c.getText()).forEach(a->System.out.println(a));
	    
	  List<String> orgList= list.stream().map(c->c.getText()).collect(Collectors.toList());
	   
	    Set<String> listNames = new HashSet<String>(orgList.size());
	    for (WebElement w : list) {
	        listNames.add(w.getText().trim());
	        	    }
	    listNames.stream().sorted().forEach(b->System.out.println(b));
	   List<String> actList = listNames.stream().sorted().collect(Collectors.toList());
	   
	  //Assert.assertTrue(actList.equals(orgList));
	    Assert.assertTrue(list.size()== listNames.size());
	    
	    if(list.size()== listNames.size())
	        return true;
	    else
	        return false;
	    
	   
	}
}
