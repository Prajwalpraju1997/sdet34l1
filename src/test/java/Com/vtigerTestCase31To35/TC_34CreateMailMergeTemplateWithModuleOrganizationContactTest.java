package Com.vtigerTestCase31To35;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactMailMergeTemplatePage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;

public class TC_34CreateMailMergeTemplateWithModuleOrganizationContactTest extends BaseClass{
	
	String contactlasttname;
	String contactmodule1;
	String contactfile;
	CreateNewContactPage createNewContactPage;
	ContactPage contactPage;
	ContactInformationPage contactInformationPage;
	ContactMailMergeTemplatePage contactMail;
	JavaClassFileUtility jutil;
	@Test
	public void createContactTc34() throws InterruptedException {
		
     contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	 contactmodule1 = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 3);
	 contactfile = ExcelclassFileUtility.getDataFromExcel("Contacts", 4, 0);
		
	  jutil=new JavaClassFileUtility();
	  homepage.clickOnContact();
	    createNewContactPage=new CreateNewContactPage(driver);
	    createNewContactPage.ClickOnMailTemplate();
	    contactMail=new ContactMailMergeTemplatePage(driver);
	    contactMail.clickFile(contactfile);
	   
	    contactMail.clickDropDown();	
	    jutil.printStatement("contact mail merge is not created");	    
	}	
}
