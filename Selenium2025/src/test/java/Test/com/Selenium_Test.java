package Test.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_Test {

	    public static void main(String[] args) {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
	    	
	    	
	    	
	    	
	    } 	
}	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
//	    	WebDriver driver = new ChromeDriver();
//	    	driver.get("https://www.flipkart.com/");
//	    	
//	    	
//	    	WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(50));
//	    	JavascriptExecutor js= (JavascriptExecutor)driver;
////	    	js.executeScript("window.scrollBy(0,300)");
//	    	List<WebElement> links = driver.findElements(By.xpath("//a"));
//	    
//	    	System.out.println(links);
//	    	
//	    	int count = links.size();
//	    	
//	  
//	    	
//	    	System.out.println(count);
//	    	
//	    	
//			for( WebElement all:links)
//			
//	System.out.println(all.getText());
//	    
//	    	
////	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////	    	
////	    	WebElement ele = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
////	    	
////			WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
////			wait.until(ExpectedConditions.visibilityOf(ele));
////			
////			ele.click();
////			
////			driver.findElement(By.xpath("//input[@id='fromCity']")).click();
////			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru International Airport");
////			driver.findElement(By.xpath("//span[.='BLR']")).click();
////			
////			driver.findElement(By.xpath("//input[@id='toCity']")).click();
////			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("GOA");
////			driver.findElement(By.xpath("//div[.='GOX']")).click();
////			
//			
//			
//	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    	
//	    			
//	    	
//	    	
//	    }
//
//		private static void assertEquals(String w, String t, String string) {
//			// TODO Auto-generated method stub
//			
//		}
//	    }
//
//
