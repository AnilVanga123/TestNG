package Jan22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	WebDriver driver;
	@Test(invocationCount=3)
	private void registorlink() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.partialLinkText("REGIST")).click();
		Reporter.log("Execute Registerlink",true);
		Thread.sleep(4000);
		driver.close();

	}

}
