package Com.vtiger.campagnsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import Com.vtiger.objectRepository.CampaignInformationPage;
import Com.vtiger.objectRepository.CampaignPage;
import Com.vtiger.objectRepository.CampaignProductChildBrowserPage;
import Com.vtiger.objectRepository.CreateNewCampaignPage;
import Com.vtiger.objectRepository.CreateNewProductPage;
import Com.vtiger.objectRepository.ProductInfoPage;
import Com.vtiger.objectRepository.ProductPage;

public class CreateCampaignWithProductTest extends BaseClass  {
	
	String campaignname;
	CampaignPage campaignPage;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformation;
	String productnname;
	ProductPage productPage;
	CreateNewProductPage createNewProduct;
	ProductInfoPage productInfoPage;
	CampaignProductChildBrowserPage campaignProductChildBrowser;
     @Test
     public void createCampaignTest() {
	
	 campaignname = ExcelclassFileUtility.getDataFromExcel("campagin", 1, 0)+randomnumber;
	 productnname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
	 campaignPage =new CampaignPage(driver);
	 createnewcampaignpage=new CreateNewCampaignPage(driver);
	 campaigninformation=new CampaignInformationPage(driver);
	 productPage=new ProductPage(driver);
	 createNewProduct=new CreateNewProductPage(driver);
	 productInfoPage=new ProductInfoPage(driver);
	 campaignProductChildBrowser=new CampaignProductChildBrowserPage(driver);		 
	 homepage.clickOnProduct();
	 createNewProduct.clickOnProductContact();
	 productPage.enterProductNameTxtName(productnname);
	 productPage.saveProduct();
	 homepage.clickCampaign(driver);
	 campaignPage.clickcraeteCampaign();
	 createnewcampaignpage.enterCampaignName(campaignname);
	 campaignPage.clickOnProductSelect();
	 SeleniumDriverUtility.switchToWindowBasedOnTitle(driver, productnname);
	 campaignProductChildBrowser.childBrowsetHandels(driver, productnname);
	 SeleniumDriverUtility
	 .switchToWindowBasedOnTitle(driver, "CAMPAIGNS");
	 createnewcampaignpage.saveCampaign();
	 jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname, "Campaign with Product");
}	
}
