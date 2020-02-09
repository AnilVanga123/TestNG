package Jan23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver Driver;
	@BeforeMethod
	public void setUP() throws Throwable {
		Driver=new ChromeDriver();
		Driver.get("http://newtours.demoaut.com/");
		Driver.manage().window().maximize();
		Reporter.log("Running setUP",true);
		Thread.sleep(2000);
	}
	@Test(priority =0)
	public void registeLink()throws Throwable
	{
	Driver.findElement(By.partialLinkText("REG")).click();
	Reporter.log("Executing Register link",true);
	Thread.sleep(4000);
	}
	@Test(priority =1)
	public void HotelsLink()throws Throwable
	{
	Driver.findElement(By.partialLinkText("Hot")).click();
	Reporter.log("Executing Hotels link",true);
	Thread.sleep(4000);
	}
	@Test(priority=2)
	public void CarrentelsLink()throws Throwable
	{
	Driver.findElement(By.partialLinkText("Car")).click();
	Reporter.log("Executing Carrentals link",true);
	Thread.sleep(4000);
	}
	@AfterMethod
	public void tearDown() throws Throwable {
		Thread.sleep(5000);
		Driver.close();
		Reporter.log("Running tearDown",true);
	}

}
