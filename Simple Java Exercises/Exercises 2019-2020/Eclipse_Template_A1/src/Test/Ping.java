package Test;
import org.jfugue.*;

class Utilities
{
	private static Player p = new Player();
	public static void sound(String s)
	{
		
		p.play(s);
		
	}
}






class Ping 

{
	
	public static void ping(int k)
	{
		StringBuilder sb = new StringBuilder("Ping" + " " + "[" + k + "]" + " " + "[" + (k+3) + "]" + " " + "[" + (k+7) + "]");
		
		
		String tester = sb.subSequence(6, 8).toString();
		int a = Integer.parseInt(tester);
		
		if(a % 2 == 0)
			sb.insert(5, "I[FLUTE] ");
		else
			sb.insert(5, "I[SYNTH_STRINGS_1] ");
		String res = sb.substring(5);
		System.out.println(sb);
		Utilities p = new Utilities();
		p.sound(res);
		
		if(k < 100)
			Pong.pong(k+3);
	}


	public static void main(String argsp[])

	{
	
		ping(40);

	}
	 
	 

}

class Pong 
{
	
	static Ping call = new Ping();
	
	
	public static void pong(int k)
	{
StringBuilder sb = new StringBuilder("Pong" + " " + "[" + k + "]" + " " + "[" + (k+4) + "]" + " " + "[" + (k+7) + "]");
		
		
		String tester = sb.subSequence(6, 8).toString();
		int a = Integer.parseInt(tester);
		if(a % 2 == 0)
			sb.insert(5, "I[TUBA] ");
		else
			sb.insert(5, "I[CHOIR_AAHS] ");
		
		String res = sb.substring(5);
		System.out.println(sb);
		Utilities p = new Utilities();
		p.sound(res);
		if(k < 100)
			Ping.ping(k+3);
	}


	public static void main(String argsp[])
	{
		
		pong(40);
		
	}

}
