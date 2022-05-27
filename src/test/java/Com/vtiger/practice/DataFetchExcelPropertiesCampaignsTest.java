package Com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExcelPropertiesCampaignsTest {
	
	@Test
	public void dataFetchExcelPropertiesCampaignsTest() throws IOException {
		JavaClassFileUtility jutil=new JavaClassFileUtility();	
		
		//FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
		//Properties property=new Properties();
		//property.load(fis);
		//String url = property.getProperty("url");
		//String timeout = property.getProperty("timeout");
		//String username = property.getProperty("username");
		//String password = property.getProperty("password");
		//String browser = property.getProperty("browser");
		//long longTimeOut=Long.parseLong(timeout);
		
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		int randomnumber = jutil.getRandomNumber(1000);
		
	
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/Excel.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		
		Sheet sh = wb.getSheet("campaign");
		
		Row row = sh.getRow(2);
		
		Cell cell = row.getCell(1);
		
		String campaignname = cell.getStringCellValue();		
		
		wb.close();
		
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			Actions act= new Actions(driver);
			act.moveToElement(more).perform();
			driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement campain = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']"));
			
			
			if(campain.getText().equalsIgnoreCase(campaignname));
			{
				System.out.println("campain name is created");
				System.out.println("TC pass");
				
				 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				 Actions act1=new Actions(driver);
				 act.moveToElement(atoradminist).build().perform();
				 driver.findElement(By.xpath("//a[.='Sign Out']"));
				 driver.quit(); 
	}

}
}