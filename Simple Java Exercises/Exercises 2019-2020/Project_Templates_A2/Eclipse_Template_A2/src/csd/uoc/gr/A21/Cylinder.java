package csd.uoc.gr.A21;

public class Cylinder extends SolidShape 

{
	private double radius,height;
	
	
	public void set_rad(double number)
	{
		radius = number;
	}
	
	public double get_rad()
	{
		return radius;
	}
	
	
	public void set_height(double e)
	{
		height = e;
	}
	
	public double get_height()
	{
		return height;
	}
	
	
	

	public double getNumberOfFaces()
	{
		
		return 1;
	}
	
	
	
	public double getVolume()
	{
		
		return 3.14 * (radius * radius * height);
	}
	


	
	

	public String toString()
	{

		String ret = "Cylinder ";
		ret+= super.toString();
		ret+= "\nradius : "+ radius;
		ret+= "\nheight : "+ height;
		return ret;
		
		
	}
	
	
	
	

	public Cylinder(double a, double b, double c, double d, double e) 
	
	
	{
		super(a, b, c);
		set_rad(d);
		set_height(e);
		double number = getVolume();
		setVolume(number);
		toString();
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	
	{
		
		
		

	}

}
