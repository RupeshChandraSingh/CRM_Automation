package com.crm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xslf.usermodel.XSLFShadow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFDateAxis;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ReadExcelData {
	 
	public FileInputStream fis;
	public XSSFWorkbook hssfWorkbook;
	public XSSFSheet hssfSheet;
	public XSSFRow hssfRow;
	public XSSFCell hssfCell;
	public Workbook workb;
	
	//public String excelFilePath = "F:\\Docs\\Rupesh\\testdata.xlsx";
	
	public ReadExcelData(String excelFilePath) throws IOException
	{
		//this.excelFilePath = excelFilePath;
		fis = new FileInputStream(excelFilePath);
		hssfWorkbook = new XSSFWorkbook(fis);
		fis.close();
	}
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		
		try 
		{
			int colNum = -1;
			hssfSheet = hssfWorkbook.getSheet(sheetName);
			hssfRow = hssfSheet.getRow(0);
			for(int i = 0; i<hssfRow.getLastCellNum();i++)
			{
				if(hssfRow.getCell(i).getStringCellValue().trim().equals(colName.toLowerCase()))
				colNum = i;
			}
			if(rowNum<1)
			{
				System.out.println("Invalid row num");
			}
			hssfRow = hssfSheet.getRow(rowNum);
			
			hssfCell = hssfRow.getCell(colNum);
			if(hssfCell.getCellTypeEnum() == org.apache.poi.ss.usermodel.CellType.STRING)
			{
				return hssfCell.getStringCellValue();
			}else if (hssfCell.getCellTypeEnum() ==org.apache.poi.ss.usermodel.CellType.NUMERIC||hssfCell.getCellTypeEnum() ==org.apache.poi.ss.usermodel.CellType.FORMULA) {
				String cellValue = String.valueOf(hssfCell.getNumericCellValue());
				return cellValue;
			}
			else if (hssfCell.getCellTypeEnum() ==org.apache.poi.ss.usermodel.CellType.BLANK) {
				return "";
			}else 
		
			return String.valueOf(hssfCell.getBooleanCellValue());
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			return "Column Name is not found";
		}
		
	}
	

}
