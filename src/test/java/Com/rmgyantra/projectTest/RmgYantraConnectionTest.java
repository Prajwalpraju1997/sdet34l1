package Com.rmgyantra.projectTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraConnectionTest {
	static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("sdet3585ty");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mohan sir");
		WebElement ele = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select s=new Select(ele);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> project = driver.findElements(By.xpath("//td[.='sdet3585ty']"));
		
		for(WebElement project1:project) 
		{
		if(project1.getText().equalsIgnoreCase("sdet3585ty"));
		{
			System.out.println("Project name is visible in GUI");
			System.out.println("TC pass");
			break;
		}
		}
		
		seleniumDriverUtility.quitbrowser(driver);
}
}