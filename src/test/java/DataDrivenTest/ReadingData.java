package DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingData {
	
	public static void main (String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\pc\\eclipse-workspace\\Book1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum(); // return raw count
		int columncount = sheet.getRow(0).getLastCellNum(); // return column count
		
		for (int i=0; i<rowcount; i++) {
			XSSFRow currentrow = sheet.getRow(i); //focus on current row
			
			for (int j=0; j<columncount ; j++) {
				String value =currentrow.getCell(j).toString(); //Read the value 
				System.out.print(" " +value);
			}
			System.out.println();
		}
	
	}

}

//getStringCellValue()
//getNumericCellValue()
//getBooleanCellValue()
