package csd.uoc.gr.A11;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DrawAwin

{
	
	public static void main(String[] args)
	{
		
		
	int input = Integer.parseInt(JOptionPane.showInputDialog("Give me a number "));
	String parser = "";
	
	while(input < 4)
	{
		input = Integer.parseInt(JOptionPane.showInputDialog("Give me a correct number "));
		
	}
	
	
	
	for(int i=0; i<= input; i++)
	{
		if(i == 0)
			parser += "  **";
		else if(i == 1)
			parser += "\n*     *";
		else if(i == (input/2))
			parser+= "\n******";
	
		else
			{
		
				
				parser+= "\n*     *";
			}
	}
	
	
	JOptionPane.showMessageDialog (null,parser,"A letter",JOptionPane.INFORMATION_MESSAGE);
	
	
	input = Integer.parseInt(JOptionPane.showInputDialog("Give me a number "));
		while(input>=4 && input	<	20)
		{
		
			parser = "";
			
		      for(int i=0; i<= input; i++)
		  		{
		  				if(i == 0)
		  					parser += "  **";
		  				else if(i == 1)
		  					parser += "\n*     *";
		  				else if(i == (input/2))
		  					parser+= "\n******";
		  	
		  				else
		  				{
		  		
		  				
		  					parser+= "\n*     *";
		  				}
		  		}
		      JOptionPane.showMessageDialog (null,parser,"A letter",JOptionPane.INFORMATION_MESSAGE);
			

			
		      input = Integer.parseInt(JOptionPane.showInputDialog("Give me a number "));
		}
		JOptionPane.showMessageDialog (null, "Wrong Number");
   
}

	}

