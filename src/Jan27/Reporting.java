package Jan27;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void generatereport()
	{
		reports = new ExtentReports("./Reports.mrng.html");
		
	}
	@Test
	public void passtest()
	{
		test=reports.startTest("Test case pass");
		test.assignAuthor("Anil associate test engineer");
		test.assignCategory("Functional Testing");
		test.log(LogStatus.PASS, "Test pass");
		try {
			Assert.assertFalse(true);
		}catch (Throwable t)
		{
		System.out.println(t.getMessage());	
		}
	}
		@Test
		public void filetest()
		{
			test=reports.startTest("Test case fail");
			test.assignAuthor("Rang seniour QA Engineer");
			test.assignCategory("Functional Test");
			test.log(LogStatus.FAIL, "Test fail");
			try 
			{
				Assert.assertTrue(false);
			}catch (Throwable  t)
			{
				System.out.println(t.getMessage());
				}
			}
		@Test
		public void SkipTest()
		{
			test=reports.startTest("Skip Test case");
			test.assignAuthor("Ranga seniour QA Engineer");
			test.assignCategory("Functional Test");
			test.log(LogStatus.SKIP, "Test case skip");
			try 
			{
				throw new SkipException("skipping test case");
				
			}catch (Throwable  t)
			{
				System.out.println(t.getMessage());
				}
			
		}
		@AfterMethod
		public void tearDown()
		{
			reports.endTest(test);
			reports.flush();
		}
		
	}
	
