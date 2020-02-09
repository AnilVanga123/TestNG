package Jan23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkingTitle2 {
	WebDriver driver;
	@Test
	public void titlteverification() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		String ExpTitle="dash";
		String ActTitle=driver.getCurrentUrl();
		try {
			Assert.assertFalse(ActTitle.contains(ExpTitle), "title is  matching");
		}catch (Throwable t) {
			System.out.println(t.getMessage());	
		}
		driver.close();
	}

}
