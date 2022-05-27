package Com.vtiger.organizationTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.OrganizationInfoPage;
import Com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass
{
	
	String organizationname;
	CreateNewOrganizationPage createNewOrganization;
	OrganizationPage organizationPage;
	 OrganizationInfoPage  organizationInfoPage;
	@Test(groups = "regression")
	public void createOrganization() {
		
		 organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
		
		 homepage.clickOnOrganzations();
		 createNewOrganization=new CreateNewOrganizationPage(driver);
		createNewOrganization.clickOnCreateOrganization();
		organizationPage=new OrganizationPage(driver);
		organizationPage.enterOrganizationNameTxtName(organizationname);		
        organizationPage.oganizationDropDownIndustry(industryname);
        organizationPage.oganizationDropDownType(typename);
        organizationPage.saveOrganization();
          organizationInfoPage=new OrganizationInfoPage(driver);	
        
        jutil.assertionThroughifCondition( organizationInfoPage.getOrganizationName(), organizationname,"Organization");
	}
}