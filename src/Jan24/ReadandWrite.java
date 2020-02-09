package Jan24;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadandWrite { 

	public static void main(String[] args)throws Throwable {
		FileInputStream fi= new FileInputStream("F:\\original.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheetAt(0);
		XSSFRow row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		System.out.println("no of rows are::"+rc+"   "+"no of columns are::"+cc);
		for(int i=1; i<rc; i++)
		{
			String user=ws.getRow(i).getCell(0).getStringCellValue();
			String pass=ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(user+"  "+pass);
			ws.getRow(i).createCell(2).setCellValue("pass");
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("F:\\originalresuilts.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	

	}

}
