package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowcount(String xlfile, String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		wb.close();
		return rowcount;
	  }
	
	public static int getCellcount(String xlfile, String xlsheet, int rownum) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		row=sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	  }
	public static String getCelldata(String xlfile, String xlsheet, int rownum, int column) throws FileNotFoundException,IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		}catch(Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	  }
	 public static void setCelldata(String  xlfile, String xlsheet, int rownum, int column, String data) throws IOException {
		 fi=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fi);
		 sheet=wb.getSheet("Sheet1");
		 row=sheet.getRow(rownum);
		 cell=row.createCell(column);
		 cell.setCellValue(data);
		 fo=new FileOutputStream(xlfile);
		 wb.write(fo);
		 wb.close();
		 fi.close();
		 fo.close();
	}
	}

