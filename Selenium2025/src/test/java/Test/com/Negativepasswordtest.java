package Test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class Negativepasswordtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("incorrectPassword");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		String actualTitle = "";
		String expectedTitle="";
		
		//assertNotEquals(actualTitle, expectedTitle, "Titles should not match, but they do");
		
		//assertEquals	
		
		WebElement Verify_password_invaild_Error = driver.findElement(By.xpath("//div[.='Your password is invalid!']"));
		
		if(Verify_password_invaild_Error.isDisplayed()) {
			
			System.out.println("Password error message is displaying");
		}
		else {
			System.out.println("Password error message is not displaying");
		}
	}


	private static void assertEquals() {
		// TODO Auto-generated method stub
		
	}

}
