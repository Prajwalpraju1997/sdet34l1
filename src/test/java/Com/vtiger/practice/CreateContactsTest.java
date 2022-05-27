package Com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {
	
 @Test
 public void CreateContactsTest() {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.get("http://localhost:8888");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();
	 driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']")).click();
	 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("prajwal23");
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement ele = driver.findElement(By.xpath("//span[.='prajwal23']"));
	 boolean p = ele.isDisplayed();
	 if(p)
	 {
		 Reporter.log("Element is display");
	 }
	 else
	 {
		 Reporter.log("Element is not display");
	 }
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	 WebElement ele1 = driver.findElement(By.xpath("//a[.='Sign Out']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(ele1).build().perform();
	 ele1.click();
	 driver.quit();
	 
}

}
