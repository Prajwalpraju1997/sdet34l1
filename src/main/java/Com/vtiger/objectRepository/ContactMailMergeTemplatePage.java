package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactMailMergeTemplatePage {
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileNamemailDataTemplate;
	
	@FindBy(xpath = "//select[@name='target_module']")
	private WebElement clickOnModule;
	
	@FindBy(xpath = "//option[.='Organizations']")
	private WebElement ClickOnOrganization;
	
	@FindBy(xpath = "//input[@title='Save']")
	private WebElement clickOnSave;

public ContactMailMergeTemplatePage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}

public void clickFile(String pathFile) {
	fileNamemailDataTemplate.sendKeys(pathFile);
}

public void clickDropDown()
{

	clickOnModule.click();
	ClickOnOrganization.click();
	clickOnSave.click();
}

public void selectOrganization() {
	ClickOnOrganization.click();
}
public void savBtn() {
	clickOnSave.click();
}
}



