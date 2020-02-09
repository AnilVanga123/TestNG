package Jan23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingTitle {
	WebDriver driver;
	@Test
	public void titleverification() {
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		String ExpTitle="google";
		String ActTitle=driver.getTitle();
		try {
			Assert.assertEquals(ActTitle, ExpTitle,"Title is not matching");
		}catch (Throwable t)
		{
		System.out.println(t.getMessage());
	}
		driver.close();
	

}
}