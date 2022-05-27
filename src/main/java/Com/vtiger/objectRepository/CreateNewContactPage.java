package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactTab;
	
	@FindBy(xpath = "//a[.='Create Mail Merge templates ']")
	private WebElement clickOnMailMergeTemplates;
    
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnCreateContact() {
		createContactTab.click();	
	}
	
	public void ClickOnMailTemplate() {
		clickOnMailMergeTemplates.click();
	}
	
	
	
	
	
}
