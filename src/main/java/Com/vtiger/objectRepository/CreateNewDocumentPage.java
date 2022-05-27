package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocumentPage {
	
	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement createDocumentTab;
    
	public CreateNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnCreateDocument() {
		createDocumentTab.click();	
	}

}
