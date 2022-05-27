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
import Com.vtiger.objectRepository.CreateNewProductPage;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import Com.vtiger.objectRepository.ProductInfoPage;
import Com.vtiger.objectRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExcelPropertiesProductTest {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

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
		
		String productnname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
          
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
		//SeleniumDriverUtility seleniumDriverUtility=new SeleniumDriverUtility();
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
	    ProductInfoPage productInfo=new ProductInfoPage(driver);
	    
	    jutil.assertionThroughifCondition(productInfo.getProductName(), productnname,"Product");
       
	    Thread.sleep(2000);
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
		 
		 driver.findElement(By.xpath("//a[.='Products']")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productnname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement product1 = driver.findElement(By.xpath("//td[@id='mouseArea_Product Name']"));
		 jutil.assertionThroughifCondition(product1.getText(), productnname, "product name is created"); 
		 /*if(product1.getText().equalsIgnoreCase(productnname));
			{
				jutil.printStatement("product name is created");
				jutil.printStatement("TC pass");
			
				 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
				 driver.findElement(By.xpath("//a[.='Sign Out']"));
				 SeleniumDriverUtility.quitbrowser(driver);	*/	 
	
