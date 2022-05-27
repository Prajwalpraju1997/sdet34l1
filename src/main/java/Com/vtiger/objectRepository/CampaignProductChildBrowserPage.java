package Com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;

public class CampaignProductChildBrowserPage {
	
	
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement productDataChildBrowser;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearchChildBrowser;


	public CampaignProductChildBrowserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void childBrowsetHandels(WebDriver driver, String product, SeleniumDriverUtility seleniumDriverUtility) {
     
		seleniumDriverUtility.switchToWindowBasedOnTitle(driver, "Products");
		productDataChildBrowser.sendKeys(product);
		productSearchChildBrowser.click();
		driver.findElement(By.xpath("//a[.='"+product+"']")).click();
	}
}
