package csd.uoc.gr.A21;

public class Cube extends SolidShape 


{

	private double side;
	
	
	public void set_side(double number)
	{
		side = number;
	}
	
	public double get_side()
	{
		return side;
	}
	
	
	
	public double getNumberOfFaces()
	{
		
		return super.getNumberOfFaces();
	}
	
	
	
	public double getVolume()
	{
		
		return side * side * side;
	}
	
	
	
	

	public String toString()
	{

		String ret = "Cube ";
		ret+= super.toString();
		ret+= "\nside : "+ side;
		return ret;
		
		
	}
	
	
	
	
	
	
	public Cube(double a, double b, double c, double d) 
	
	
	{
		super(a, b, c);
		set_side(d);
		double number = getVolume();
		setVolume(number);
		toString();
	}

	
	
	
	
	
	public static void main(String[] args) 
	
	{
	
		
	
	}

}
