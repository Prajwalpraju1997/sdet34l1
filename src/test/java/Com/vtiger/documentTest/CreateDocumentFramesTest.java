package Com.vtiger.documentTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CreateNewDocumentPage;
import Com.vtiger.objectRepository.DocumentInfoPage;
import Com.vtiger.objectRepository.DocumentPage;

public class CreateDocumentFramesTest extends  BaseClass{
	String document;
	String documentpath;
	String documentdescription;
	CreateNewDocumentPage createNewDocument;
	 DocumentPage  documentPage;
	 DocumentInfoPage documentInfoPage;
	
	
	@Test(groups = "regression")
	public void createDocumentWithFrames() throws InterruptedException {
		 document = ExcelclassFileUtility.getDataFromExcel("document", 2, 1)+randomnumber;
		 documentpath =ExcelclassFileUtility.getDataFromExcel("document", 3, 1);
		 documentdescription =ExcelclassFileUtility.getDataFromExcel("document", 2, 2);
		
		 homepage.clickOnDocument();
		    createNewDocument=new CreateNewDocumentPage(driver);
		    createNewDocument.clickOnCreateDocument();
		    documentPage=new DocumentPage(driver);
		
		    documentPage.enterdocumentNameTxtName(document);
		   
		    driver.switchTo().frame(0);
		    documentPage.enterdocumentinfoTxt(documentdescription);
		    driver.switchTo().defaultContent();
		    documentPage.clickOnBold();
		    documentPage.clickOnItalic();
		    documentPage.clickOnFiles(documentpath);
		    documentPage.saveDocument();
		    documentInfoPage=new DocumentInfoPage(driver);

		    jutil.assertionThroughifCondition(documentInfoPage.getDocumentName(),document ,"*Document*");	
	}
}
