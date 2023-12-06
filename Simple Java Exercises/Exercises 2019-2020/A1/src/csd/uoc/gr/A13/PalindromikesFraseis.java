package csd.uoc.gr.A13;
import java.util.Scanner;



public class PalindromikesFraseis
{
	
	private static Scanner in;



	static boolean isPalindromikhFrash(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		char [] array;
		 array = s.toCharArray();
		char [] reverse;
		reverse = sb.reverse().toString().toCharArray();
		for(int i = 0; i<= array.length-1; i++)
		{
		
			if(array[i] != reverse[i])
				return false;
		
	}
		
		return true;
		
	}
	
	
	
	public static void main(String [] args)
	{
		double startTime = System.nanoTime();
		
		in = new Scanner(System.in);
		String nextLine = in.nextLine();
		String res = nextLine.toLowerCase();
		res = res.replaceAll("[^a-zA-Z0-9]", "");		
		
		
		if(isPalindromikhFrash(res) == true)
			System.out.print("It is");
		else
		System.out.println("Not this one bud");
		
		double endTime = System.nanoTime();
		System.out.println("And it only took: " + (endTime - startTime) + " nano seconds" );
		
	}
}


