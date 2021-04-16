package com.IOfileRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	
	public String getData(String path,String Testcase, String Key){ 
		String value = "";
		try {
		 FileInputStream fio = new FileInputStream(new File(path));
		 HSSFWorkbook wb = new HSSFWorkbook(fio);
		 HSSFSheet ws = wb.getSheet("Sheet1");
		 int row = 0,col = 0;
		 
		 for(int j=0;j<ws.getPhysicalNumberOfRows();j++){ ///Rows 
		   int colums = ws.getRow(0).getPhysicalNumberOfCells();
		   for(int i=0;i<colums;i++){ // Columns

		     if(Testcase.equalsIgnoreCase(ws.getRow(j).getCell(0).toString())){
		        row = j;
		      } 
		     if(Key.equalsIgnoreCase(ws.getRow(0).getCell(i).toString())){
		        col = i;
		      }
		    }
		 }
		 value = ws.getRow(row).getCell(col).toString();
		 } catch (IOException e) {
			 System.out.println(e.getMessage());
		 }
		return value;
		}
	public static void main(String[] args) {
		ReadExcel d = new ReadExcel();
		System.out.println(d.getData("", "searchJonUsingKeyword1", "Keyword"));
	}
}
