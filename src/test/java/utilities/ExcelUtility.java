package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public FileOutputStream fout;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;

	public ExcelUtility(String path) {
		this.path=path;
	}

	public int getRowCount(String sheetName) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		int rowCount =sheet.getLastRowNum();
		workBook.close();
		fis.close();
		return rowCount;

	}

	public int getCellCount(String sheetName,int rowNum) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workBook.close();
		fis.close();
		return cellCount;

	}

	public String getCellData(String sheetName,int rowNum,int colNum) throws Exception {
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data =  formatter.formatCellValue(cell); //returns the formated value of a cellas a string
		}
		catch(Exception e) {
			data="";
		}
		workBook.close();
		fis.close();

		return data;
	}

	public void setCellData(String sheetName,int rownum,int column,String data) throws Exception {

		File xlFile = new File(path);
		if(!xlFile.exists()) {    				//If not file exist then create a new file
			workBook =  new XSSFWorkbook();
			fout = new FileOutputStream(path);
			workBook.write(fout);
		}

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);

		if(workBook.getSheetIndex(sheetName)==-1) 
			workBook.createSheet(sheetName); //If sheet not  exist then create a new sheet
		sheet= workBook.getSheet(sheetName);

		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum); ////If row not exist then create a new row
		row =sheet.getRow(rownum);

		cell = row.createCell(column);
		cell.setCellValue(data);
		fout = new FileOutputStream(path);
		workBook.write(fout);
		workBook.close();
		fis.close();
		fout.close();

	}

	public void fillGreeenColor(String sheetName,int rownum,int column) throws Exception{

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet= workBook.getSheet(sheetName);
		row =sheet.getRow(rownum);
		cell = row.getCell(column);
		 style = workBook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 workBook.write(fout);
		 workBook.close();
		 fis.close();
		 fout.close();
		 
	}
	public void fillRedColor(String sheetName,int rownum,int column) throws Exception{

		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		sheet= workBook.getSheet(sheetName);
		row =sheet.getRow(rownum);
		cell = row.getCell(column);
		 style = workBook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.RED.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 workBook.write(fout);
		 workBook.close();
		 fis.close();
		 fout.close();
		 
	}

}
