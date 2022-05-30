package Com.sdet34l1.genericUtilty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**open and close excel
 * This class is used to maintain all excel specific common methods
 * @author PRAJWAL
 *
 */

public class ExcelclassFileUtility {

	static Workbook wb;
	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fisExcel);
	}
	
	/**
	 * This method is used to fetch the frin the excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	
	public static String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	/**
	 * This is method is used to get the multiple data from excel
	 * @param sheetname
	 * @return
	 */
	
	public static Object[][] getDataFromMultipleData(String sheetname){
		
	     Sheet sh = wb.getSheet(sheetname);
	     Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	     for(int i=0; i<sh.getLastRowNum(); i++)
	     {
	    	 for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
	    	 {
	    		 arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	    	 }
	     }	
		return arr;
	}
	
	/**
	 * This method is used to create and set cell value into Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
public static void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String value) {
	 wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
}

/**
 * This method is used to write in the Excel
 * @param fileSavePath
 */
public void saveExcelData(String fileSavePath)  {
	FileOutputStream fos = null;
	try {
		fos = new FileOutputStream(fileSavePath);
	} catch (FileNotFoundException e) {
		//DO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		wb.write(fos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * This method is used to close the Excel
 */
public static void closeExcel() {
	try {
		wb.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


/*public static void saveDataInExcel(String filepath) throws FileNotFoundException {
	
	FileOutputStream fos1=new FileOutputStream(filepath);
	wb.write(fos1);*/
	
}


