package Jan25;

import java.io.BufferedReader;
import java.io.FileReader;
public class ReadingTextFile {

	public static void main(String[] args) throws Throwable {
		FileReader fr=new FileReader("F:\\mrng.txt");
		BufferedReader br=new BufferedReader(fr);
		String str="";
				while ((str=br.readLine())!=null)
				{
					System.out.println(str);
				}
					br.close();

	}

}
