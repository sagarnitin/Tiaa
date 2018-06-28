package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static void main(String[] args) {
		String value=getCellData("F:\\Framework\\Tiaa_Project\\test-input\\TestData_ST2.xlsx","Sheet1","URL",2);
		System.out.println(value);
	}

	@SuppressWarnings("null")
	public static String readSpecificcell(String filepath, String sheetName, String ColumnName)
	{
		String cellValue="return value";
		int columnindex=0;
		
		try
		{
			FileInputStream fileinput=null;
			XSSFWorkbook workbook=null;
			XSSFSheet sheet=null;
			Row row;
			Cell cell = null;
			
			
			fileinput=new FileInputStream(new File(filepath));
			workbook=new  XSSFWorkbook(fileinput);
			sheet=workbook.getSheet(sheetName);
			Iterator<Row> rowIterator=sheet.iterator();
			
			while(rowIterator.hasNext())
			{
				row=rowIterator.next();
				
				
				
					
					if(cell.getStringCellValue().trim().equalsIgnoreCase(ColumnName))
					{
						columnindex=cell.getColumnIndex();
						break;
					}
				
				
				
				
				cellValue=row.getCell(columnindex).toString();
			}
			fileinput.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return cellValue;
	}
	
	
	
	public static String getCellData(String FileName,String SheetName,String colName,int rownum)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		int colNum=0;
		String strCellData=null;
		try
		{
			fin=new FileInputStream(FileName);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet(SheetName);
			row=sh.getRow(0);
			for (int c=0;c<row.getLastCellNum();c++)
			{
				cell=row.getCell(c);
				String columnName=cell.getStringCellValue();
				
				if (columnName.equalsIgnoreCase(colName.trim()))
				{
					colNum=c;
				}
			}
			row=sh.getRow(rownum-1);
			cell=row.getCell(colNum);
			if (cell==null || cell.getCellType()==cell.CELL_TYPE_BLANK)
			{
				strCellData="";
			}
			if (cell.getCellType()==cell.CELL_TYPE_STRING)
			{
				strCellData=cell.getStringCellValue();
			}
			if (cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
			{
				strCellData=String.valueOf(cell.getBooleanCellValue());
			}
			if (cell.getCellType()==cell.CELL_TYPE_FORMULA || cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			{
				if (HSSFDateUtil.isCellDateFormatted(cell))
				{
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					strCellData=cal.get(Calendar.MONTH)+1+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR);
				}
				else
				{
					strCellData=String.valueOf(cell.getNumericCellValue());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return strCellData;
	}

}
