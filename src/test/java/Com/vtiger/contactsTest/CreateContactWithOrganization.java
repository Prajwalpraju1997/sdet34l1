package Com.vtiger.contactsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactChildBrowserPage;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.OrganizationPage;

public class CreateContactWithOrganization extends BaseClass {
	
	String organizationname;
	String contactname;
	CreateNewOrganizationPage createNewOrganization;
	OrganizationPage organizationPage;
	CreateNewContactPage createNewContact;
	ContactPage contactPage;
	ContactInformationPage contactInformationPage;
	ContactChildBrowserPage contactChildBrowser;
	
	@Test(groups = "regression")
	public void createContactOrganization() throws InterruptedException {
	
	    organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
		contactname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
		homepage.clickOnOrganzations();
		 createNewOrganization=new CreateNewOrganizationPage(driver);
		 createNewOrganization.clickOnCreateOrganization();
		 organizationPage=new OrganizationPage(driver);
		 createNewContact=new CreateNewContactPage(driver);
		 contactPage=new ContactPage(driver);
		organizationPage.enterOrganizationNameTxtName(organizationname);
		  organizationPage.saveOrganization();
	     
		  homepage.clickOnContact();
		  createNewContact.clickOnCreateContact();
		 contactPage.enterContactNameTxtName(contactname);
		 contactChildBrowser=new ContactChildBrowserPage(driver);
		 contactPage.clickOnSelect();
		 seleniumDriverUtility.switchToWindowBasedOnTitle(driver, organizationname);
		 contactChildBrowser.childBrowsetHandels(driver, organizationname, seleniumDriverUtility);
			seleniumDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts");
		 contactPage.savecontact();
			 contactInformationPage=new ContactInformationPage(driver);
			 jutil.assertionThroughifCondition(contactInformationPage.getcontactName(),contactname,"Contact");	
	}
}
	