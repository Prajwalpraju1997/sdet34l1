package Test.com;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class hcl {
	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://practicetestautomation.com/practice-test-login/");
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
	driver.findElement(By.xpath("//button[@id='submit']")).click();
	
	String URL = driver.getTitle();
	System.out.println(URL);
	
    if(URL.equals("Logged In Successfully | Practice Test Automation")) {
   	 
    	System.out.println("Test case pass");      
}
else {
	 System.out.println("Test case fail");
}
	
	WebElement text1 = driver.findElement(By.xpath("//h1[.='Logged In Successfully']"));
     
     if(text1.isDisplayed()) {
    	 
    	System.out.println("Tc pass");      
}
else {
	 System.out.println("Tc fail");
}
	
     
     
WebElement logout = driver.findElement(By.xpath("//a[.='Log out']"));
	
     
if(logout.isDisplayed()) {
	 
	System.out.println("Tc pass");      
}
else {
System.out.println("Tc fail");
}
}
}
