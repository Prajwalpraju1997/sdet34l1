package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTxt;

     @FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;

     @FindBy(xpath = "//select[@name='industry']")
     private WebElement industrydropdown;
     
     @FindBy(xpath = "//select[@name='accounttype']")
     private WebElement typedropdown;
     
     public OrganizationPage(WebDriver driver) 
   {
	PageFactory.initElements(driver, this);
   }

public void enterOrganizationNameTxtName(String organizationNameTxtName) {
	organizationNameTxt.sendKeys(organizationNameTxtName);
}

public void saveOrganization() {
	saveBtn.click();
}

public void oganizationDropDownIndustry(String DropDown) {
   Select s=new Select(industrydropdown);
	industrydropdown.sendKeys(DropDown);
}

public void oganizationDropDownType(String path) {
	 Select s=new Select(typedropdown);
	typedropdown.sendKeys(path);
}	
}
