package csd.uoc.gr.A14.b;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


class Encrypt_a
{
	private static Scanner in;
	private static String testname;
	private static int testnum;
	
	
	
	static boolean test()
	throws IOException
	{
		
		FileInputStream fis = null;
		FileInputStream original = null;
		File input = new File("C:\\Users\\Alex\\Desktop\\" + "Encrypted" + testname);
		File originall = new File("C:\\Users\\Alex\\Desktop\\" + testname);
		
		if(input.length() != originall.length())
			return false;
		
		  int i = 0;
		  int e = 0;
	      char c;
	      
	      byte[] bs = new byte[(int) input.length()];
	      byte[] ori =new byte[(int) originall.length()];
	      
	      
	      try 
	      
	      {
	         // create new file input stream
	         fis = new FileInputStream(input);
	         original = new FileInputStream(originall);
	        
	         
	         // read bytes to the buffer
	         i = fis.read(bs);
	         e = original.read(ori);
	         char res[] = new char[(char) ori.length];
	         
	         int counter = 0;
	         
	         for(byte b:ori) 
	         { 
	             res[counter] = (char)b;
	             System.out.println("After DeCrypto Byte is: " + res[counter]);
	             counter++;
	         }
	         
	         // prints
	         System.out.println("Number of bytes read: "+e);
	         System.out.print("Original Bytes read: ");
	         
	         
	         counter = 0;
	         // for each byte in buffer
	         for(byte b:bs) {
	             
	             b = (byte) (b - (byte) testnum);
	             c = (char)b;
	            
	             if(b == 0)
	                c = '-';
	             
	             
	             if(c != res[counter])
	            	 return false;
	             
	             counter++;
	             
	             // print
	             System.out.print(c);
	          }
	         
	         return true;
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
	            original.close();
	           
	      }
	      
	
	      
		return false;
		
	
	}
	
	
	
	
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
	         System.out.print("Crypted Bytes read: ");
	         
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
	      
	      testname = name;
	      testnum = K;
	      
	      
	      try {
	    	  
			Transform(name, "Encrypted" + name, K);
			
			 if(test() == true)
		    	  System.out.println("\nIt checks out good");
			 else
				 System.out.println("There seems to be a problem");
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}