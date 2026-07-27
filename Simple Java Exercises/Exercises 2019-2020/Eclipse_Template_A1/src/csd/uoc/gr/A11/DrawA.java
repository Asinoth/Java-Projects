package csd.uoc.gr.A11;
import java.util.Scanner;


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
		      
		      
		      for(int i = 0; i<= L; i++)
		      {
		    	switch(i)
		    	{
		    	case 0: System.out.println("  **");
		    	break;
		    	
		    	case 1: System.out.println("*    *");
		    	break;
		    	
		    	case 2: System.out.println("******");
		    	break;
		    	
		    	case 3: System.out.println("*    *");
		    	break;
		    	default: System.out.println("*    *");		    	
		    	
		    	
		    	}
		    	  
		      }
		      
		      while(L >= 4 && L <20 )
		      {
		    	  L = in.nextInt();
		    	  if(L < 4 || L >20)
		    	  {
		    		  break;
		    	  }
		    	  
		    	  for(int i = 0; i<= L; i++)
			      {
			    	switch(i)
			    	{
			    	case 0: System.out.println("  **");
			    	break;
			    	
			    	case 1: System.out.println("*    *");
			    	break;
			    	
			    	case 2: System.out.println("******");
			    	break;
			    	
			    	case 3: System.out.println("*    *");
			    	break;
			    	default: System.out.println("*    *");		    	
			    	
			    	
			    	}
			    	  
			      }
		    	  
		      }
		      
		   }
		
	
}

