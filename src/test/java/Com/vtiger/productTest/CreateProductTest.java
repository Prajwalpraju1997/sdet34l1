package Com.vtiger.productTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CreateNewProductPage;
import Com.vtiger.objectRepository.ProductInfoPage;
import Com.vtiger.objectRepository.ProductPage;

public class CreateProductTest extends BaseClass{
	
	String productname;
	CreateNewProductPage createNewProduct;
	ProductPage productPage;
	ProductInfoPage productInfoPage;
	
	@Test(groups = "sanity")
	public void createProduct() {
	
	 productname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
		
		 homepage.clickOnProduct();
		 createNewProduct=new CreateNewProductPage(driver);
         createNewProduct.clickOnProductContact();
		 productPage=new ProductPage(driver);
		 productPage.enterProductNameTxtName(productname);
		 productPage.saveProduct();
		 productInfoPage=new ProductInfoPage(driver);    
	    jutil.assertionThroughifCondition(productInfoPage.getProductName(), productname,"Product");       
	}
}