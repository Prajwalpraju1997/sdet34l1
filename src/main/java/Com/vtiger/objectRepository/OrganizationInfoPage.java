package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement organizationNameText;
	
	public OrganizationInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String getOrganizationName() {
		return organizationNameText.getText();	
	}
	
    public WebElement createOrganizationInfo(WebDriver driver)
{
    	organizationNameText.click();
	return organizationNameText;
}
	

	
	

}
