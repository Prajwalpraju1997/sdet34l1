package Com.vtigerTestCase31To35;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;

public class TC_31CreateContactTest extends BaseClass{
	
	String contactfirstname;
	CreateNewContactPage createNewContactPage;
	 ContactPage  contactPage;
	 ContactInformationPage contactInformationPage;
	 
	@Test
	public void contactTest31() {
	
     contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	
     homepage.clickOnContact();
     createNewContactPage=new CreateNewContactPage(driver);
     createNewContactPage.clickOnCreateContact();
	 contactPage=new ContactPage(driver);
	 contactPage.enterContactNameTxtName(contactfirstname);
	 contactPage.enterContactNameEmailId(emailid);
	 contactPage.clickOnPortal();
	 contactPage.savecontact();
	 contactInformationPage=new ContactInformationPage(driver);
		
	jutil.assertionThroughifCondition(contactInformationPage.getcontactName(),contactfirstname,"Contact and tc31 pass");	
	}
}