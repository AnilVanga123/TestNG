package Jan27;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskOnNEWTORS {

	public static void main(String[] args)throws Throwable{
		FileReader fr=new FileReader("F:\\NEWTOURS.txt");
		BufferedReader br=new BufferedReader(fr);
		String str="";
		while((str=br.readLine())!= null)
		{
			
			WebDriver driver=new ChromeDriver();
			driver.get("http://newtours.demoaut.com/mercuryregister.php");
			driver.manage().window().maximize();
			String login[]=str.split(";");
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(login[0]);
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(login[1]);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(login[2]);
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(login[3]);
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(login[4]);
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(login[5]);
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(login[6]);
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(login[7]);
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(login[8]);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(login[9]);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(login[10]);
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(login[11]);
			driver.findElement(By.xpath("//input[@name='register']")).click();
			if(driver.getCurrentUrl().contains("success"))
			{
				System.out.println("Login success");
				
			}
			else
			{
				System.out.println("login failed");
				
			}
			driver.close();	
		}	
		br.close();

	}

}
