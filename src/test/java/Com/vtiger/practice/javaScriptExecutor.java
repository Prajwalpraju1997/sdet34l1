package Com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) throws IOException, InterruptedException {
		
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 seleniumDriverUtility.intializeJs(driver);
	 driver.manage().window().maximize();
	 seleniumDriverUtility.navigateApplicationThroughJs("http://localhost:8888/");
	 seleniumDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_name")), "admin");
	 seleniumDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_password")), "admin"); 
	 seleniumDriverUtility.clickThrouhgJs(driver.findElement(By.id("submitButton")));
	 Thread.sleep(2000);
	seleniumDriverUtility.scroolTillElement(driver.findElement(By.xpath("//b[.=' Upcoming Activities']")));
	String fileName = new javaScriptExecutor().getClass().getName();
	//seleniumDriverUtility.takeScreenShot(fileName, driver);
	}
}
