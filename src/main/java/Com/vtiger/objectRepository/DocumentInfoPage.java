package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInfoPage {
	
	@FindBy(xpath = "//td[@id='mouseArea_Title']")
	private WebElement documentNameText;
	
	public DocumentInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String getDocumentName() {
		return documentNameText.getText();	
	}
	
    public WebElement createDocumentInfo(WebDriver driver)
{
    	documentNameText.click();
	return documentNameText;
}

}
