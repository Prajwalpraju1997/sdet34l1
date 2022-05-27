package Com.vtiger.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpicrJetBookingTest {
	
	
	
	  public static void main(String[] args) throws InterruptedException {
		  
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions opt=new ChromeOptions();
		  opt.addArguments("--disable-notifications");
		  WebDriver driver=new ChromeDriver(opt);
		 driver.get("https://www.spicejet.com/");
		 driver.manage().window().maximize();
		// Thread.sleep(2000);
      // driver.findElement(By.xpath("//div[.='Hotels']")).click();
       //driver.findElement(By.xpath("//div[.='Deals']")).click();
       Thread.sleep(5000);
       //driver.findElement(By.xpath("//a[@title='SpiceJet']")).click();
       Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
         
	     driver.findElement(By.xpath("//div[.='From']")).click();
	     driver.findElement(By.xpath("//div[.='Kempegowda International Airport']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//div[.='Indira Gandhi International Airport']")).click();
	     driver.findElement(By.xpath("//div[.='16']")).click();
	     driver.findElement(By.xpath("//div[.='24']")).click();
	     Thread.sleep(2000);
	   
	      driver.findElement(By.xpath("//div[.='Search Flight']")).click();
	    driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[.='Continue']")).click();
	   // driver.findElement(By.xpath("//div[@class='r-1awozwy r-1loqt21 r-13awgt0 r-1777fci r-6dt33c r-bnwqim r-1otgn73 r-1i6wzkk r-lrvibr r-13qz1uu css-1dbjc4n']")).click();
	      
	      //driver.findElement(By.xpath("//div[.='Passengers']")).click();
		    // driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click(); 
		   //driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-obd0qt r-k8qxaj r-d9fdf6']")).click(); 
		     
	   
	  }
}
