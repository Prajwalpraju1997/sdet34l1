package Com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExcelPropertiesContactsTest {
	
	public static void main(String[] args) throws IOException {

		JavaClassFileUtility jutil=new JavaClassFileUtility();
	/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	Properties property=new Properties();
	property.load(fis);*/
	
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
	
	Sheet sh = wb.getSheet("Contacts");
	
	Row row = sh.getRow(2);
	
	Cell cell = row.getCell(1);
	
	String contactlastname = cell.getStringCellValue();
	
	WebDriver driver=null;
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 if(driver.getTitle().contains("home"));
	 {
		 wb.getSheet("Contacts").getRow(9).createCell(4).setCellValue("home page is displayd");
		 wb.getSheet("Contacts").getRow(9).createCell(5).setCellValue("pass");
	 }
	 
	 //testcase2
	 driver.findElement(By.linkText("Contacts")).click();
	 if(driver.getTitle().contains("Contacts"));
	 {
		 wb.getSheet("Contacts").getRow(10).createCell(4).setCellValue("contacts page is displayd");
		 wb.getSheet("Contacts").getRow(10).createCell(5).setCellValue("pass");
	 }
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 driver.findElement(By.name("lastname")).sendKeys(contactlastname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	 
	 if(Actualastname.getText().equalsIgnoreCase(contactlastname));
	 {
		 System.out.println("contact created successfully");
		 System.out.println("TC pass");
	 }
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 FileOutputStream fos1=new FileOutputStream("./src/test/resources/Excel.xlsx");
	 wb.write(fos1);
	 wb.close();
	 driver.quit();
	 }
	}

