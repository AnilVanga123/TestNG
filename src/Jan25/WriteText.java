package Jan25;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteText {

	public static void main(String[] args)throws Throwable {
	File f=new File("F:\\mrng.txt");
	f.createNewFile();
	FileWriter fw=new FileWriter(f);
	BufferedWriter bw= new BufferedWriter(fw);
	bw.write("iam learning java");
	bw.newLine();
	bw.write("iam learning manual testing");
	bw.newLine();
	bw.write("iam learning selenium");
	bw.flush();
	bw.close();
	

	}

}
