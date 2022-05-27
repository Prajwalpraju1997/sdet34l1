package Com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySqlFetchDataTest {
	
  public static void main(String[] args) throws SQLException
  {
	 String url=null,username=null,password=null,timeunit=null;
	  
	  Driver d=new Driver();
	  DriverManager.registerDriver(d);
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdettset","root","root");
	  Statement statement = connection.createStatement();
	  ResultSet result = statement.executeQuery("select * from vtiger");
	  while(result.next())
	  {
		  url=result.getString("url");
		  username=result.getString("username");
		  password=result.getString("password");
		  timeunit=result.getString("timeunit");
		  
	  }
	  long longTimeOut=Long.parseLong(timeunit);
	  WebDriver driver=null;
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	 
	 
	 driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.linkText("Contacts")).click();
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 String firstname = "sdetty23";
	 String lastname = "ty1";
	 
	 driver.findElement(By.name("firstname")).sendKeys(firstname);
	 driver.findElement(By.name("lastname")).sendKeys(lastname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement Actualfirstname = driver.findElement(By.id("dtlview_First Name"));
	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	 
	 if(Actualfirstname.getText().equalsIgnoreCase(firstname)&&Actualastname.getText().equalsIgnoreCase(lastname));
	 {
		 System.out.println("contact created successfully");
		 System.out.println("TC pass");
	 }
	 
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 driver.quit();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			 
			 
	 
 
  
  
  }
}
	
