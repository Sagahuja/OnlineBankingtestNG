package OnlineBankingUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelDataDriven {
	
	
	// excel sheet pick for that we use Fileinput stream class
	// Sheet page for that we use XSSWorkbook class
	// Rows for that we use XSSFSheet class
	// cell value
	
	public  void FileData_Reader() throws IOException {
	
	FileInputStream fis = new FileInputStream("C:\\Users\\91956\\Automation-Workspace\\OnlineBankingtestNG\\src\\main\\java\\Resources\\OnlineBankingTestData.xlsx");
	XSSFWorkbook excelfile= new XSSFWorkbook(fis);
	XSSFSheet sheet = excelfile.getSheet("Test Data");// it will pick specific sheet from excel file
	int rowCount  = sheet.getLastRowNum();//
	System.out.println(sheet.getPhysicalNumberOfRows());  //5
	System.out.println(rowCount);                         //4
	int colCount= sheet.getRow(rowCount).getLastCellNum();
	
	
	for(int i=1; i<=rowCount; i++)
	{
		for(int j=0; j<colCount; j++)
		{
			
			XSSFRow row = sheet.getRow(i);
			Cell cell  = row.getCell(j);
			System.out.print(cell.getStringCellValue()+"  ");
		}
		System.out.println();
	}

	
	}
}
