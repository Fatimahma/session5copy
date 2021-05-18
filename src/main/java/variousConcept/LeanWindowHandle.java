package variousConcept;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LeanWindowHandle {

		WebDriver driver;

		@Before
		public void init() {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.yahoo.com");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void windowHandleTest() {
			
			driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("Xpath");
			driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
			
			driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
			Set <String> handles = driver.getWindowHandles();
			for(String i:handles) {
				System.out.println(i);
				driver.switchTo().window(i);
			}
			System.out.println(driver.getTitle());
			
			
		}
	

}
