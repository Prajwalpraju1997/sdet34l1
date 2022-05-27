package Com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement documentNameTxt;

     @FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;
     
     @FindBy(xpath = "//body[@class='cke_show_borders']")
     private WebElement documentPath;
    
     @FindBy(xpath = "//a[@title='Bold']")
     private WebElement clickBold;
     
     @FindBy(xpath = "//a[@title='Italic']")
     private WebElement clickItalic;
     
     @FindBy(xpath = "//input[@name='filename']")
     private WebElement clickOnchoiceFile;
     

     public DocumentPage(WebDriver driver) 
   {
	PageFactory.initElements(driver, this);
   }

public void enterdocumentNameTxtName(String documentNameTxtName) {
	documentNameTxt.sendKeys(documentNameTxtName);
}

public void saveDocument() {
	saveBtn.click();
}

public void enterdocumentinfoTxt(String documentNameinfo) {
	documentPath.sendKeys(documentNameinfo, Keys.CONTROL+"a");
}

public void clickOnBold() {
	clickBold.click();
}

public void clickOnItalic() {
	clickItalic.click();
	
}

public void clickOnFiles(String filePath) {
	clickOnchoiceFile.sendKeys(filePath);
}
}
