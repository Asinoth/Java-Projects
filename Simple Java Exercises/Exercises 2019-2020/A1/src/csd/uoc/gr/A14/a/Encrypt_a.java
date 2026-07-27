package csd.uoc.gr.A14.a;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


class Encrypt_a
{
	private static Scanner in;
	
	
	
	 static void Transform(String inputFileName, String outputFileName, int inputK) 
			 throws IOException 
	 
	 {
	      FileInputStream fis = null;
	      FileOutputStream fop = null;
	      File input = new File("C:\\Users\\Alex\\Desktop\\" + inputFileName);
	      File output = new File("C:\\Users\\Alex\\Desktop\\" + outputFileName);
	      int i = 0;
	      char c;
	      long startTime = System.nanoTime();
	      
	
	      byte[] bs = new byte[(int) input.length()];
	      
	      try 
	      
	      {
	         // create new file input stream
	         fis = new FileInputStream(input);
	         fop = new FileOutputStream(output);
	         
	         // read bytes to the buffer
	         i = fis.read(bs);
	         
	         // prints
	         System.out.println("Number of bytes read: "+i);
	         System.out.print("Bytes read: ");
	         
	         // for each byte in buffer
	         for(byte b:bs) {
	             
	             b = (byte) (b + (byte) inputK);
	             fop.write(b);
	             c = (char)b;
	            
	             if(b == 0)
	                c = '-';
	             
	             // print
	             System.out.print(c);
	          }
	         long endTime = System.nanoTime();
	         System.out.println("\nCryptography of file content needs: " + (endTime-startTime) + " nanoseconds to complete");
	      } 
	      
	     
	      
	      catch(Exception ex) 
	      
	      {
	         // if any error occurs
	         ex.printStackTrace();
	         
	         
	      } 
	      
	      finally 
	      
	      {
	         // releases all system resources from the streams
	         if(fis!=null)
	            fis.close();
	            fop.flush();
	            fop.close();
	      }
	      
	      
	   }
	
	
	
	
	
	
	
	
	
	public static void main(String [] args)
	{
		
		  String name;
		  int K;
	      in = new Scanner(System.in); 
	      System.out.println("Please enter filename:");
	      name = in.nextLine();
	      System.out.println("Please enter K:");
	      K = in.nextInt();
	      try {
	    	  
			Transform(name, "Encrypted" + name, K);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}