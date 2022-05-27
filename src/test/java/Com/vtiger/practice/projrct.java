package Com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class projrct {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		WebDriver driver=null;
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
		
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		String emailid = FileClassUtility.getDataFromPropertyFile("email");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		int randomnumber = jutil.getRandomNumber(1000);
		
		String contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
		
        WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		SeleniumDriverUtility.navigateApp(url, driver);
		seleniumDriverUtility.browsersetting(longTimeOut, driver);
		
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
       driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
  	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
  	 driver.findElement(By.name("lastname")).sendKeys(contactfirstname);
  	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid);
  	 driver.findElement(By.xpath("//input[@name='portal']")).click();
  	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
		
  	jutil.assertionThroughifCondition(Actualastname.getText(), contactfirstname, "Contact name is displayed");
	
  	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 seleniumDriverUtility.quitbrowser(driver);	
	}
	}

