package Com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import Com.vtiger.objectRepository.ContactChildBrowserPage;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import Com.vtiger.objectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchexcelPropertiesOrganozationContacts {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);	
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
		
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		int randomnumber = jutil.getRandomNumber(1000);
		
		String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
		String contactname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	
		WebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default: {
			System.out.println("please specifiy the browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}		
		}
		SeleniumDriverUtility seleniumDriverUtility=new SeleniumDriverUtility();
		 seleniumDriverUtility.navigateApp(url, driver);
		    seleniumDriverUtility.browsersetting(longTimeOut, driver);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginActions(username, password);
		HomePage homepage=new HomePage(driver);
		homepage.clickOnOrganzations();
		CreateNewOrganizationPage createOrganization=new CreateNewOrganizationPage(driver);
		createOrganization.clickOnCreateOrganization();
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.enterOrganizationNameTxtName(organizationname);	
		 organizationPage.saveOrganization();
		 Thread.sleep(2000);
		 homepage.clickOnContact();
			CreateNewContactPage createnewcontact=new CreateNewContactPage(driver);
			createnewcontact.clickOnCreateContact();
			ContactPage contactpagename=new ContactPage(driver);
			contactpagename.enterContactNameTxtName(contactname);
			ContactChildBrowserPage childBrowse=new ContactChildBrowserPage(driver);
			contactpagename.clickOnSelect();
			
			//childBrowse.sendDataTochildBrowser(organizationname);
			//childBrowse.searchDataTochildBrowser();
			//childBrowse.childBrowsetHandels(driver, contactname);
			seleniumDriverUtility.switchToWindowBasedOnTitle(driver, organizationname);
			childBrowse.childBrowsetHandels(driver, organizationname, seleniumDriverUtility);
			seleniumDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts");
		    contactpagename.savecontact();
		    
		    ContactInformationPage contcatinfo=new ContactInformationPage(driver);
			
			 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactname,"Contact");
		
			 Thread.sleep(2000); 
			   homepage.signOut(driver, seleniumDriverUtility);
			   Thread.sleep(2000);
			seleniumDriverUtility.quitbrowser(driver);
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	// String contactname="prajwalpraju231997";
	 driver.findElement(By.name("lastname")).sendKeys(contactname);
	  driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	  
	  String parentpage = driver.getWindowHandle();
	  Set<String> sessionId = driver.getWindowHandles();
	  for(String id:sessionId)
	  {
		  driver.switchTo().window(id);
		/*  if(driver.getTitle().contains("Accounts&action"));
		  {
			  break;
		  }
	  }
	// String orgaoname="prajwal199723381";
	  driver.findElement(By.id("//input[@id='search_txt']")).sendKeys(organizationname);
	
	  driver.findElement(By.xpath("//input[@name='search']")).click();
	  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	  driver.switchTo().parentFrame();
	  WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(atoradminist).build().perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']"));
		 driver.quit(); */
}	  
}
	