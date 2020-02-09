package Jan28;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertyFile {
	WebDriver driver;
	Properties p;
	FileInputStream fi;
	@BeforeTest
	public void setUP()throws Throwable
	{
		p=new Properties();
		fi=new FileInputStream("F:\\December_Selenium\\TestNG Scripts\\OR.properties");
		p.load(fi);
		driver=new ChromeDriver();
		driver.get(p.getProperty("ObjUrl"));
		driver.manage().window().maximize();
				
	}
	@Test
	public void Login()
	{
		driver.findElement(By.xpath(p.getProperty("ObjUsername"))).sendKeys("Admin");
		driver.findElement(By.xpath(p.getProperty("ObjPassword"))).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath(p.getProperty("ObjLogin"))).click();
		String Expval="dash";
		String Actval=driver.getCurrentUrl();
		try {
			Assert.assertEquals(Actval.contains(Expval), "Login Fail");
		}catch (Throwable t) 
		{
			System.out.println(t.getMessage());
	  }
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
