package Test.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cloud {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.cloudphysicianworld.org/patientlist");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[.='Email']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("interview2885@cp.net");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Aa,1qwer");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[.=' Login ']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='mat-tab-labels']/descendant::div[@role='tab']/descendant::div[@class='mat-tab-label-content' and .='Vitals']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
		
		//driver.findElement(By.xpath("//div[@class='mat-tab-labels']/descendant::div[@role='tab']/descendant::div[@class='mat-tab-label-content' and .='Vitals']")).click();
		//driver.findElement(By.xpath("//div[.='Vitals' and @class='mat-tab-label-content']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//span[.=' Continue ']")).click();
		
		
		
		
		
	}

}
