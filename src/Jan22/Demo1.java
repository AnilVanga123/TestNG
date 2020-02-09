package Jan22;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Demo1 {
  @Test
  public void tc1() {
	  Reporter.log("Executing tc1",true);
	   }
  @Test
  public void tc2() {
	  Reporter.log("Executing tc2",true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Running beforeMethod",true);
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Running afterMethod",true);
  }

  @BeforeClass
  public void beforeClass() {
	  Reporter.log("Running beforeClass",true);
	   }

  @AfterClass
  public void afterClass() {
	  Reporter.log("Running afterClass",true);
	  
  }

  @BeforeTest
  public void beforeTest() {
	  Reporter.log("Running beforeTest",true);
	  
  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("Running afterTest",true);
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("Running beforeSuite",true);
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("Running afterSuite",true);
  }

}
