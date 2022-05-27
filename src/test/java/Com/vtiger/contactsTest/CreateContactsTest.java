package Com.vtiger.contactsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactsTest extends BaseClass {
	
	String contactlastname;
	 CreateNewContactPage createNewContact;
	 ContactPage contactPage;
	 ContactInformationPage contactInformationPage;
	
	@Test(groups = "sanity", description = "testng:-CreateContact")
	@Description("Description:-CreateContactTest")
	@Epic("Epic:-CreateContactTest")
	@Story("Story:-CreateContactTest")
	@Step("Step:-CreateContactTest")
	@Severity(SeverityLevel.BLOCKER)
	public void crateContact() {
	contactlastname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 2)+randomnumber;
    createNewContact=new CreateNewContactPage(driver);
	homepage.clickOnContact();
	createNewContact.clickOnCreateContact();
	contactPage=new ContactPage(driver);
	contactPage.enterContactNameTxtName(contactlastname);
	contactPage.savecontact();
	contactInformationPage=new ContactInformationPage(driver);
		
	jutil.assertionThroughifCondition(contactInformationPage.getcontactName(),contactlastname,"Contact");	
	}
}
	