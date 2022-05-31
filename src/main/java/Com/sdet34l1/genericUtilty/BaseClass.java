package Com.sdet34l1.genericUtilty;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**Reusable methods
	 * This class contain the all common methods for Testscripts
	 */
	
	public JavaClassFileUtility jutil;
	public String password;
	public String username;
	public long longTimeOut;
	public int randomnumber;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homepage;
	public String industryname;
	public String typename;
	public String emailid;
	public SeleniumDriverUtility seleniumDriverUtility;
    static WebDriver staticdriver;	
	/**
	 * This before suite is used for open the excel and property file and also get the database connection
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
@BeforeSuite(groups = "Baseclass")
//open the database if it is required
public void beforesuite1Test() throws EncryptedDocumentException, IOException {
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);	
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
}
	/**
	 * This method is used to fetch the data from the proprety file and excel file, launch the browser and navigate the application
	 * @throws IOException
	 */
//@Parameters("browser")
@BeforeClass(groups = "Baseclass")
public void beforeClass1Test(/*String browser*/) throws IOException {
	
	seleniumDriverUtility=new SeleniumDriverUtility();
	jutil=new JavaClassFileUtility();
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	 username =FileClassUtility.getDataFromPropertyFile("username");
	 password = FileClassUtility.getDataFromPropertyFile("password");
	 String browser = FileClassUtility.getDataFromPropertyFile("browser");
	 industryname = FileClassUtility.getDataFromPropertyFile("industryname");
	 typename = FileClassUtility.getDataFromPropertyFile("typename");
	 emailid = FileClassUtility.getDataFromPropertyFile("email");
	
	
	 longTimeOut=jutil.StringToLong(timeout);	
	 randomnumber = jutil.getRandomNumber(1000);
	
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
		    break;
		}		
	 }
	 staticdriver=driver;
	 seleniumDriverUtility=new SeleniumDriverUtility();
	 SeleniumDriverUtility.navigateApp(url, driver);
	 seleniumDriverUtility.browsersetting(longTimeOut, driver);
	 loginPage=new LoginPage(driver);
	 homepage=new HomePage(driver);
}
/**
 *This method is used to login actions 
 */
@BeforeMethod(groups = "Baseclass")
public void beforeMethod1Test() {
	loginPage.loginActions(username, password);
}
/**
 * This method is used to logout actions the application
 * @throws InterruptedException 
 */
@AfterMethod(groups = "Baseclass")
public void afterMethod1Test() throws InterruptedException {
	Thread.sleep(2000);
	homepage.signOut(driver, seleniumDriverUtility);
	
}
/**
 * This method is used to close the browser
 */
@AfterClass(groups = "Baseclass")
 public void afterClass1Test() {
	seleniumDriverUtility.quitbrowser(driver);
}
	/**
	 * This method is used to close the excel and property file and database connection
	 */
@AfterSuite(groups = "Baseclass")
public void afterSuite1Test() {
	ExcelclassFileUtility.closeExcel();
}
}