package Jan23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
	@BeforeTest
	public void setUP() {
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		Reporter.log("Running setUP",true);
		
	}
	@Test(priority=0)
	public void Rigisterlink() throws Throwable {
		driver.findElement(By.partialLinkText("REG"));
		Reporter.log("Executing Registerlink",true);
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void Hotelslink() throws Throwable {
		driver.findElement(By.partialLinkText("Hot"));
		Reporter.log("Executing Hotelslink",true);
		Thread.sleep(2000);
	}
	@Test
	public void CarsRentelslink() throws Throwable {
		driver.findElement(By.partialLinkText("Car"));
		Reporter.log("Executing CarsRentelslink",true);
		Thread.sleep(2000);
		
		}
	@AfterTest
	public void tearDown() throws Throwable {
		Reporter.log("Running tearDown",true);
		Thread.sleep(5000);
		driver.close();
		
	
	}

}
