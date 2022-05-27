package Com.vtiger.campagnsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CampaignInformationPage;
import Com.vtiger.objectRepository.CampaignPage;
import Com.vtiger.objectRepository.CreateNewCampaignPage;

public class CreateCampgainsTest extends BaseClass {
	
	String campaignname;
	CampaignPage campaignPage;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformation;
     @Test(groups = "sanity")
     public void createCampaignTest() {
	 campaignname = ExcelclassFileUtility.getDataFromExcel("campagin", 1, 0)+randomnumber;
	 campaignPage =new CampaignPage(driver);
	 createnewcampaignpage=new CreateNewCampaignPage(driver);
	 campaigninformation=new CampaignInformationPage(driver);
	 homepage.clickCampaign(driver, seleniumDriverUtility);
	 campaignPage.clickcraeteCampaign();	
	 createnewcampaignpage.enterCampaignName(campaignname);
	 createnewcampaignpage.saveCampaign();
	 jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname, "campaign");
}	
}