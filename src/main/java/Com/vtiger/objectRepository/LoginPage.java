package Com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "user_name")
	private WebElement userNametxt;
	
	@FindBy(name = "user_password")
    private WebElement passwordTxt;	
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	//business library
	
public void loginActions(String userName, String password) {
	userNametxt.sendKeys(userName);
	passwordTxt.sendKeys(password);
	loginBtn.click();	
}

//public void loginClick() {
	//loginBtn.click();
}


