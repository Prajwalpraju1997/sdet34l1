package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductTab;
    
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnProductContact() {
		createProductTab.click();	
	}
	

}
