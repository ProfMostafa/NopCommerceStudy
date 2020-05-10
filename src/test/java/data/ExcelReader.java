package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public ExcelReader(String filepath, int sheetIndex) 
	{		
		this.internalFilePath = filepath;
		this.InternalSheetIndex = sheetIndex;
	}
	
	int InternalSheetIndex;
	String internalFilePath;
	static FileInputStream fis = null;

	public  FileInputStream getFileInputStream() 
	{
		String filePath = internalFilePath;
		File src = new File(filePath);

		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file isn't found :: Check file path");
			System.exit(0);
		}
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(InternalSheetIndex);
		XSSFRow Rows = sheet.getRow(0);
		int totalNumberOfCols = Rows.getLastCellNum();
		int totalNumberOfRows = (sheet.getLastRowNum()+1);
		
		String [][] exceldata = new String[totalNumberOfRows][totalNumberOfCols];
		
		for(int i = 0; i<totalNumberOfRows;i++ )
		{
			for(int j = 0; j<totalNumberOfCols;j++) 
			{
				XSSFRow row = sheet.getRow(i);			
				exceldata[i][j] = row.getCell(j).toString();
			}	
		}
		wb.close();
		return exceldata;	
	}
}
