package Jan25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Demo {
	public static void main(String[] args)throws Throwable {
		FileInputStream fi=new FileInputStream("F://NUMARIC.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheetAt(1);
		int rc=ws.getLastRowNum();
		System.out.println("r count :"+rc);
		for(int i=1; i<rc; i++)
		{
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			if(wb.getSheetAt(0).getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC);
			{
				int celldata=(int)wb.getSheetAt(0).getRow(i).getCell(1).getNumericCellValue();
				String password=String.valueOf(celldata);
				System.out.println(username+"  "+password);
			}
			ws.getRow(i).createCell(2).setCellValue("done");
		}
		//fi.close();
        FileOutputStream fo=new FileOutputStream(new File("F:/Guru12.xlsx"));
		wb.write(fo);
	
		wb.close();
		fo.close();
}
}


