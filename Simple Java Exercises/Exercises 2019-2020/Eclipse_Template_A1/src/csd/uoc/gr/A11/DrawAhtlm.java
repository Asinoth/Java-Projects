package csd.uoc.gr.A11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DrawAhtlm
{
	public static void main(String [] args)
	{
		String html = "<html>Hello, <b>world</b></html>";
		
		File f = new File("C:\\ A.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(html);
			bw.close();
		}  catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}