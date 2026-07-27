package csd.uoc.gr.A11;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DrawA
{
	private static Scanner in;
	
		
		 public static void main(String args[])
		   {
		     
			  int L;
		      in = new Scanner(System.in); 
		      L = in.nextInt();
		      while(L < 4)
		      {
		    	  L = in.nextInt();
		    	  
		      }
		      
		      String parser = "";
		      
		      for(int i=0; i<= L; i++)
		  		{
		  				if(i == 0)
		  					parser += "  **";
		  				else if(i == 1)
		  					parser += "\n*     *";
		  				else if(i == (L/2))
		  					parser+= "\n******";
		  	
		  				else
		  				{
		  		
		  				
		  					parser+= "\n*     *";
		  				}
		  		}
		      
		      System.out.println(parser);
		      
		      L = in.nextInt();
		  		while(L>=4 && L	<	20)
		  		{
		  		
		  			parser = "";
		  			
				      for(int i=0; i<= L; i++)
				  		{
				  				if(i == 0)
				  					parser += "  **";
				  				else if(i == 1)
				  					parser += "\n*     *";
				  				else if(i == (L/2))
				  					parser+= "\n******";
				  	
				  				else
				  				{
				  		
				  				
				  					parser+= "\n*     *";
				  				}
				  		}
				      System.out.println(parser);
		  			

		  			
		  			L = in.nextInt();
		  		}
		  		System.out.println("wrong number");
		      
		   }
		
	
}

