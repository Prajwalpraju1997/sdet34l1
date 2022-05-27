package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;

//create the class as webpage name and make it as public
public class HomePage {
	
	
	// decalre all the elements and specfiy the access specifier as private
	@FindBy(xpath = "//a[.='More']")
	private WebElement moreDropDown;
	
	@FindBy(xpath = "//a[.='Campaigns']")
	private WebElement campaignsTab;
	
	@FindBy(xpath =  "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistrorIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactTab;
	
	@FindBy(xpath = "//a[.='Documents']")
	private WebElement createDocument;
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement clickOnOrganization;
	
	@FindBy(xpath = "//a[.='Products']")
	private WebElement clickOnProduct;
	
	//intialize the driver address to all the elements through constractor and make it as public
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
    public void clickCampaign(WebDriver driver, SeleniumDriverUtility seleniumDriverUtility) {
	seleniumDriverUtility.actionsClassInvoke(driver, seleniumDriverUtility);
    	seleniumDriverUtility.mousehoverOntheElement(moreDropDown, driver);
	campaignsTab.click();
    }
    public void signOut(WebDriver driver, SeleniumDriverUtility seleniumDriverUtility) {
    	seleniumDriverUtility.actionsClassInvoke(driver, seleniumDriverUtility);
    	seleniumDriverUtility.mousehoverOntheElement(admistrorIcon, driver);
    	signOutLink.click();
    }
		public void clickOnContact() {
			contactTab.click();	
		}	
		
		public void clickOnDocument() {
			createDocument.click();	
		}
		
		public void clickOnOrganzations() {
			clickOnOrganization.click();
		}
		
		public void clickOnProduct() {
			clickOnProduct.click();
		}	
	}