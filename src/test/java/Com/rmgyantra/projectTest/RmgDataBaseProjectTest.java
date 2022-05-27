package Com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.sdet34l1.genericUtilty.DatabaseClassutility;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgDataBaseProjectTest {
	
static SeleniumDriverUtility seleniumDriverUtility;
	public static void main(String[] args) throws SQLException, IOException {
		
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		FileClassUtility.openPropertyfile(IconstantClassPath.RMGYANTRAPROPERTYFILE);
		ExcelclassFileUtility.openExcel(IconstantClassPath.RMGYANTRAEXCELFIL);
		int randomnumber = jutil.getRandomNumber(1000);
		String projcetName = ExcelclassFileUtility.getDataFromExcel("projects", 1, 1);
		System.out.println(projcetName);
		DatabaseClassutility.openDBConnection(IconstantClassPath.DATABASEPATH+FileClassUtility.getDataFromPropertyFile("dbName"), FileClassUtility.getDataFromPropertyFile("dbUserName"),FileClassUtility.getDataFromPropertyFile("dbPassword"));
        DatabaseClassutility.setDataInDataBase("insert into project values('sdet3040900', 'prajwal','23/02/2022','"+projcetName+"', 'on Going', 12);");
        DatabaseClassutility.closeDBConnection();
        
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		seleniumDriverUtility.browsersetting(10, driver);
		SeleniumDriverUtility.navigateApp("http://localhost:8084/", driver);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projcetName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mohan sir");
		WebElement ele = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		seleniumDriverUtility.intializeSelect(ele);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> project = driver.findElements(By.xpath("//td[.='sdet5497ty']"));
		for(WebElement project1:project) 
		{
		if(project1.getText().equalsIgnoreCase(projcetName));
		{
			System.out.println("Project name is visible in GUI");
			System.out.println("TC pass");
			break;
		}
		}
		
		seleniumDriverUtility.quitbrowser(driver);
	}
	}


