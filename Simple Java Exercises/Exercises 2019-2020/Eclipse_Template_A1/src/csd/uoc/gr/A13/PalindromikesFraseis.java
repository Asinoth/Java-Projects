package csd.uoc.gr.A13;
import java.util.Scanner;

public class PalindromikesFraseis
{
	
	static boolean isPalindromikhFrash(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		char [] array;
		 array = s.toCharArray();
		char [] reverse;
		reverse = sb.reverse().toString().toCharArray();
		System.out.println("String ln: " + sb.length());
		System.out.println("Array ln: " + array.length);
		System.out.println("Reverse ln: " + reverse.length);
		for(int i = 0; i<= array.length-1; i++)
		{
		
			System.out.println("String is: " + sb);
			System.out.println("Array is: " + array[i]);
			System.out.println("Reverse is: " + reverse[i]);
			
			
			if(array[i] != reverse[array.length-i-1])
			{
				
			}
		
	}
		
		return true;
		
	}
	
	
	
	public static void main(String [] args)
	{
		
		
		Scanner in = new Scanner(System.in);
		String nextLine = in.nextLine();
		 char ch;
		    boolean capitalFlag = false;
		    boolean lowerCaseFlag = false;
		    for(int i=0; i < nextLine.length();i++) {
		       
		         if (Character.isUpperCase(ch)) {
		            capitalFlag = true;
		        } else (Character.isLowerCase(ch)) {
		            lowerCaseFlag = true;
		        }
		        if(numberFlag && capitalFlag && lowerCaseFlag)
		            return true;
		    }
		    return false;
		
		if(isPalindromikhFrash(nextLine))
			System.out.print("It is");
		else
		System.out.println("Not this one bud");
		
	}
}