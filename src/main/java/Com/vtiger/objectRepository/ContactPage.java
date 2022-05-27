package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactNameTxt;

     @FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;
     
     @FindBy(xpath = "//img[@title='Select']")
     private WebElement selectBtn;

     @FindBy(xpath = "//input[@id='email']")
     private WebElement emailData;
     
     @FindBy(xpath = "//input[@name='portal']")
     private WebElement clickOnPortal;
     
     @FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
     private WebElement clickOnCancel;
     
     @FindBy(xpath = "//td[@class='moduleName']")
     private WebElement clickOnContactLink;

     public ContactPage(WebDriver driver) 
   {
	PageFactory.initElements(driver, this);
   }

public void enterContactNameTxtName(String contactNameTxtName) {
	contactNameTxt.sendKeys(contactNameTxtName);
}

public void savecontact() {
	saveBtn.click();
}

public void clickOnSelect() {
	selectBtn.click();	
}

public void enterContactNameEmailId(String contactEmailId) {
	emailData.sendKeys(contactEmailId);
}

public void clickOnPortal() {
	clickOnPortal.click();
}

public void clickOnCancelBtn() {
	clickOnCancel.click();
	
}

public String getcontactLink() {
	return clickOnContactLink.getText();	
}

public WebElement checkContactLonk(WebDriver driver)
{
	clickOnContactLink.click();
    return clickOnContactLink;
}
}


