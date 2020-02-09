package Jan22;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 
{
	 @Test(description="Verify login",priority=0,enabled=true)
	  public void login()
	  {
		  Reporter.log("Execution login test",true);
		 
	  }
	  @Test(description="Verify compose",priority=0,enabled=true)
	  public void compose()
	  {
		  Reporter.log("Execution compose test",true);
		 
	  }
	  @Test(description="Verify forword",priority=0,enabled=true)
	  public void forword()
	  {
		  Reporter.log("Execution forword test",true);
		 
	  }
	  @BeforeTest
	  public void setUP() {
		  Reporter.log("Running setUP",true);
	  }

	  @AfterTest
	  public void tearDown() {
		  Reporter.log("Running tesrDown",true);

}
}