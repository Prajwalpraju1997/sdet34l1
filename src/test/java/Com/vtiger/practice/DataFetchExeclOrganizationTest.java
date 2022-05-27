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
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import Com.vtiger.objectRepository.OrganizationInfoPage;
import Com.vtiger.objectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExeclOrganizationTest {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
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
		  SeleniumDriverUtility.navigateApp(url, driver);
		    seleniumDriverUtility.browsersetting(longTimeOut, driver);
		LoginPage loginpage=new LoginPage(driver);
	    HomePage homepage=new HomePage(driver);
	    loginpage.loginActions(username, password);
		homepage.clickOnOrganzations();
		CreateNewOrganizationPage createOrganization=new CreateNewOrganizationPage(driver);
		createOrganization.clickOnCreateOrganization();
		OrganizationPage organizationPage=new OrganizationPage(driver);
		organizationPage.enterOrganizationNameTxtName(organizationname);
		 organizationPage.saveOrganization();
	        OrganizationInfoPage orgoInfo=new OrganizationInfoPage(driver);		
	        jutil.assertionThroughifCondition(orgoInfo.getOrganizationName(), organizationname,"Organization");
	        homepage.signOut(driver, null);
	     		seleniumDriverUtility.quitbrowser(driver);
	     	}
}
		
		
		
		/**WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		 SeleniumDriverUtility.navigateApp(url, driver);
			SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement Actualorganaizationname = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));
		/**if(organaization.getText().equalsIgnoreCase(organizationname));
		{
			jutil.printStatement("Organization name is created");
			jutil.printStatement("TC pass");
		jutil.assertionThroughifCondition(Actualorganaizationname.getText(), organizationname, "Organization name is created");	
		 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
		 driver.findElement(By.xpath("//a[.='Sign Out']"));
		 SeleniumDriverUtility.quitbrowser(driver);	**/
	
