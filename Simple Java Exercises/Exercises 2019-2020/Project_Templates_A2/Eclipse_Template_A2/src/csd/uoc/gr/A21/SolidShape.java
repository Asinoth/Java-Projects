package csd.uoc.gr.A21;

public class SolidShape

{
	
	private double x,y,z = 0;
	private double faces = 0;
	private double vertices = 0;
	private double edges = 0;
	private double volume = 0;
	
	
	
	
	
	
	
	
	
	public void setNumberOfFaces(int number)
	{
		
		faces = number;
	}
	
	
	
	
	public void setNumberOfVertices(int number)
	{
		
		vertices = number;
	}
	
	
	
	
	public void setNumberOfEdges(int number)
	{
		
		edges = number;
	}
	
	
	
	
	public void setVolume(double number)
	{
		
		volume = number;
	}
	
	
	
	
	public double getNumberOfFaces()
	{
		
		return faces;
	}
	
	
	public double getNumberOfVertices()
	{
		
		return vertices;
	}
	
	
	public double getNumberOfEdges()
	{
		
		return edges;
	}
	
	
	public double getVolume()
	{
		
		return volume;
	}
	
	
	
	
	
	public void set_x( double number)
	{
		x = number;
		
	}
	
	public void set_y(double number)
	{
		y = number;
		
	}
	
	
	public void set_z(double number)
	{
		z = number;
		
	}
	
	
	
	
	public double get_x()
	{
		return x;
		
	}
	
	
	
	public double get_y()
	{
		return y;
		
	}
	
	
	
	public double get_z()
	{
		return z;
		
	}
	
	
	public SolidShape(double a, double b, double c)
	{
		set_x(a);
		set_y(b);
		set_z(c);
		toString();
	}
	
	
	
	public String toString()
	{
		String ret = "Solid shape centered at (";
		 ret+= x + " " + y + " " + z +")";
		 ret+= "\n" + "edges: " + getNumberOfEdges(); 
		 ret+= "\n" + "vertices: " + getNumberOfVertices(); 
		 ret+= "\n" + "faces: " + getNumberOfFaces(); 
		 ret+= "\n" + "volume: " + getVolume(); 
		 return ret;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) 
	
	{
		
		
	

	}

}
