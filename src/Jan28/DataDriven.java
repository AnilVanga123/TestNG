package Jan28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataDriven {
	WebDriver driver;
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	ExtentReports report;
	ExtentTest test;
	File screen;
	@BeforeTest
	public void setUp() 
	{
	report=new ExtentReports("./Reports/Login.html");
	driver=new ChromeDriver();
	
	}
	@Test
	public void VerifyLogin()throws Throwable
	{
		fi=new FileInputStream("F:\\OrangeLogin.xlsx");
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet("Login");
		row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		Reporter.log("no of rows are::"+rc+"  "+"no of columns are::"+cc,true);
		for(int i=1;i<rc;i++)
		{
			test=report.startTest("Login test case");
			driver.get("http://orangehrm.qedgetech.com/");
			driver.manage().window().maximize();
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(2000);
			String Actval="dash";
			String Exeval=driver.getCurrentUrl();
			if(Exeval.contains(Actval))
			{
				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("F://BatchMrng//screen//"+i+"Loginpage.png"));
				Reporter.log("Login success",true);
				test.log(LogStatus.PASS, "login success::"+Exeval+"  "+Actval);
				ws.getRow(i).createCell(2).setCellValue("login success");
				ws.getRow(i).createCell(3).setCellValue("Pass");
			}
			else
			{
				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("F://BatchMrng//screen//"+i+"Loginpage.png"));
				String massage=driver.findElement(By.id("spanMessage")).getText();
				test.log(LogStatus.FAIL, massage+"  "+Exeval+"  "+Actval);
				Reporter.log(massage,true);
				ws.getRow(i).createCell(2).setCellValue(massage);
				ws.getRow(i).createCell(3).setCellValue("Fail");
	
				
			}
			report.endTest(test);
			report.flush();
			}
		fi.close();
		fo= new FileOutputStream("F://Results.xlxs");
		wb.write(fo);
		fo.close();
		wb.close();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	}
