package Jan25;

import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingTextFileData {

	public static void main(String[] args)throws Throwable {
	FileReader fr=new FileReader("F:\\LoginData.txt");
	BufferedReader br= new BufferedReader(fr);
	String str="";
	while ((str=br.readLine())!=null)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		String login[]=str.split(";");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys(login[0]);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")).sendKeys(login[1]);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[5]/input[1]")).click();
		
		if (driver.getCurrentUrl().contains("dash"));
		{
	System.out.println("login success");
		}
		{
	System.out.println("login fail");
		}
		driver.close();
	}
	
	br.close();

	}

}
