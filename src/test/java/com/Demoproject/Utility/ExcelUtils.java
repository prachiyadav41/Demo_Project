package com.Demoproject.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static File file=null;
	public static FileInputStream fd =null;
	public static XSSFWorkbook wb=null;
	public static XSSFSheet sheet=null;
	public static Row Hearder_Row;
	public static int Last_Row_count;
	public static int Last_Col_count;

	public static List<Map<String,String>> datalist = new ArrayList<>();


	public static void getExcelData() throws IOException {
		file = new File("src/test/resources/Data/SearchData.xlsx");
		fd = new FileInputStream(file);
		wb = new XSSFWorkbook(fd);
		sheet = wb.getSheet("SearchDetails");
		Hearder_Row = sheet.getRow(0);
		Last_Row_count = sheet.getLastRowNum();
		Last_Col_count = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<=Last_Row_count;i++) {
			Map<String,String> map = new HashMap<String, String>();
			for(int j=0;j<Last_Col_count;j++) {
				map.put(Hearder_Row.getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
			}
			if(map.get("Execute").equalsIgnoreCase("Y")) 
				datalist.add(map);

		}
		System.out.println("Data read from Excel Complete!");

	}


}
