package dgdox.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TestUtils {
	
	//public static String path=System.getProperty("user.dir");

	//public static String SHEET_PATH =(path+"//TestData.xlsx");
	
	public static String SHEET_PATH ="C:\\Users\\bewit\\eclipse-workspace\\dgdoxjava\\Conditional.xlsx";

	static Workbook book;
	
	
	static Sheet sheet;
	static JavascriptExecutor js;

	
	public static Object[][] getTestData(String sheetName)   {
		System.out.println("sheetName********"+ sheetName);
		FileInputStream file = null;
		try {
			file = new FileInputStream(SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println("sheet********"+ sheet);
		System.out.println("RowNum********"+ sheet.getLastRowNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
					if(sheet.getRow(i + 1).getCell(k).getCellType()==CellType.STRING)
				{

					data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();
				}
				else{

					data[i][k] = NumberToTextConverter.toText(sheet.getRow(i + 1).getCell(k).getNumericCellValue());

				}
				// data[i][k] = sheet.getRow(i + 1).getCell(k).getCellType();
				
				
				
				
				//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					System.out.println(data[i][k]);
				
				
			}
		}
		return data;
	}
}