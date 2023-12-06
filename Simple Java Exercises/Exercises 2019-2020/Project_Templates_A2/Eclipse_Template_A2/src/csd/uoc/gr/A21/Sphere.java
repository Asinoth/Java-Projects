package csd.uoc.gr.A21;

public class Sphere extends SolidShape 

{
	
	
	
	private double radius;
	
	public void set_rad(double number)
	{
		radius = number;
	}
	
	public double get_rad()
	{
		return radius;
	}
	
	

	public double getNumberOfFaces()
	{
		
		return 1;
	}
	
	
	
	public double getVolume()
	{
		
		return (4.0 / 3) * Math.PI  * (radius * radius * radius);
	}
	


	
	
	public String toString()
	{

		String ret = "Sphere ";
		ret+= super.toString();
		ret+= "\nradius : "+ radius;
		return ret;
		
		
	}
	
	
	
	

	public Sphere(double a, double b, double c, double d) 
	
	
	{
		super(a, b, c);
		set_rad(d);
		double number = getVolume();
		setVolume(number);
		toString();
		
	}

	public static void main(String[] args) 
	
	{
		
		
	}

}
