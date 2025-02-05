package Test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Negativeusernametest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("incorrectUser");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		WebElement Verify_username_invaild_error_message = driver.findElement(By.xpath("//div[.='Your username is invalid!']"));
		
		if(Verify_username_invaild_error_message.isDisplayed()) {
			
			System.out.println("user invaild error message is displaying");

	}
	else {
		System.out.println("user invaild error message is not displaying");
	}
	}
}
