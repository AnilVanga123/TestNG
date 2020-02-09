package Jan24;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws Throwable {
		//Read data from file
		FileInputStream fi=new FileInputStream("F:\\original.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Sheet1");
		XSSFRow row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		System.out.println("no of rows are::"+rc+"   "+"no of columens in row are::"+cc);
		String username=ws.getRow(1).getCell(0).getStringCellValue();
		String password=ws.getRow(1).getCell(1).getStringCellValue();
		System.out.println(username+"   "+password);
		fi.close();
		wb.close();

	}

}
