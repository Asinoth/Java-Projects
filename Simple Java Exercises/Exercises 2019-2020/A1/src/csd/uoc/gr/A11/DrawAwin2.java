package csd.uoc.gr.A11;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class DrawAwin2

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
			parser += "  11";
		else if(i == 1)
			parser += "\n2     2";
		else if(i == (input/2))
			parser+= "\n"+(input/2+1)+(input/2+1)+(input/2+1)+(input/2+1)+(input/2+1);
	
		else
			{
		
				
				parser+= "\n"+(i+1)+"     "+(i+1);
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
					parser += "  11";
				else if(i == 1)
					parser += "\n2     2";
				else if(i == (input/2))
					parser+= "\n"+(input/2+1)+(input/2+1)+(input/2+1)+(input/2+1)+(input/2+1);
			
				else
					{
				
						
						parser+= "\n"+(i+1)+"     "+(i+1);
					}
			}
		      JOptionPane.showMessageDialog (null,parser,"A letter",JOptionPane.INFORMATION_MESSAGE);
			

			
		      input = Integer.parseInt(JOptionPane.showInputDialog("Give me a number "));
		}
		JOptionPane.showMessageDialog (null, "Wrong Number");
   
}

	}

