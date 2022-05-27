package Com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import Com.vtiger.objectRepository.CampaignInformationPage;
import Com.vtiger.objectRepository.CampaignPage;
import Com.vtiger.objectRepository.CampaignProductChildBrowserPage;
import Com.vtiger.objectRepository.CreateNewCampaignPage;
import Com.vtiger.objectRepository.CreateNewProductPage;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import Com.vtiger.objectRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExcelPropertiesProductCampaignTest {
	
	public static void main(String[] args, SeleniumDriverUtility seleniumDriverUtility) throws EncryptedDocumentException, IOException, InterruptedException {
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
		
		String productnname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
		String campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1)+randomnumber;
	
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
		  seleniumDriverUtility.navigateApp(url, driver);
		    seleniumDriverUtility.browsersetting(longTimeOut, driver);
		LoginPage loginpage=new LoginPage(driver);
	    HomePage homepage=new HomePage(driver);
	    loginpage.loginActions(username, password);
	    homepage.clickOnProduct();
	    CreateNewProductPage createProduct=new CreateNewProductPage(driver);
	    createProduct.clickOnProductContact();
	    ProductPage productPageDetails=new ProductPage(driver);
	    productPageDetails.enterProductNameTxtName(productnname);
	    productPageDetails.saveProduct();
	    Thread.sleep(2000);
	    homepage.clickCampaign(driver, null);
	    CampaignPage campaignpage=new CampaignPage(driver);
	    campaignpage.clickcraeteCampaign();
	    CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
	    
	   createnewcampaignpage.enterCampaignName(campaignname);
	   CampaignProductChildBrowserPage productChildBrowse=new CampaignProductChildBrowserPage(driver);
	   campaignpage.clickOnProductSelect();
	   seleniumDriverUtility.switchToWindowBasedOnTitle(driver, productnname);
	   productChildBrowse.childBrowsetHandels(driver, productnname, seleniumDriverUtility);
	   seleniumDriverUtility
	   .switchToWindowBasedOnTitle(driver, "CAMPAIGNS");
	   createnewcampaignpage.saveCampaign();
	   CampaignInformationPage campaignInfo=new CampaignInformationPage(driver);
		jutil.assertionThroughifCondition(campaignInfo.getCampaignName(),campaignname,"campaign and product");
		  Thread.sleep(2000); 
		   homepage.signOut(driver, seleniumDriverUtility);
		   Thread.sleep(2000);
		seleniumDriverUtility.quitbrowser(driver);
	
	
	   
	   
	}
}
		/*WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		SeleniumDriverUtility.navigateApp(url, driver);
		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.xpath("//a[.='Products']")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productnname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 WebElement moreLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			SeleniumDriverUtility.mousehoverOntheElement(moreLink, driver);	
			
				driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
				  Set<String> sessionId = driver.getWindowHandles();
				  for(String id:sessionId)
				  {
					  driver.switchTo().window(id);
					  if(driver.getTitle().contains("Products&action"));
					  {
						  break;
					  }
				  }
				  driver.findElement(By.id("search_txt")).sendKeys(productnname);
					 Thread.sleep(2000);
					  driver.findElement(By.xpath("//input[@name='search']")).click();
					  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();	
	}
}*/
