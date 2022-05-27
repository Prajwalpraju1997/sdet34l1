package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationTab;
    
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnCreateOrganization() {
		createOrganizationTab.click();	
	}

}
