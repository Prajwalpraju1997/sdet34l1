package Com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataFetchingExcelTest {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Excel.xlsx");
		
	Workbook wb = WorkbookFactory.create(fis);
	
     Sheet sh = wb.getSheet("multipledata");
     for(int i=0; i<sh.getLastRowNum(); i++)
     {
    	 for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
    	 {
    		 System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
    	 }
     }	
	}
}
