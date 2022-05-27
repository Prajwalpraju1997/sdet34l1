package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	@FindBy(xpath = "//td[@id='mouseArea_Product Name']")
	private WebElement ProductNameText;
	
	public ProductInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String getProductName() {
		return ProductNameText.getText();	
	}
	
    public WebElement createProductInfo(WebDriver driver)
{
    	ProductNameText.click();
	return ProductNameText;
}


}
