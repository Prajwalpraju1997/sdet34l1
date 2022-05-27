package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTxt;

     @FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;
     
     public ProductPage(WebDriver driver) 
     {
  	PageFactory.initElements(driver, this);
     }

  public void enterProductNameTxtName(String productNameTxt1) {
	  productNameTxt.sendKeys(productNameTxt1);
  }

  public void saveProduct() {
  	saveBtn.click();
  }

     
     

}
