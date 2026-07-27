package csd.uoc.gr.A21;

public class Star extends CelestialBody 

{

	private float radius;
	
	public void setradius(float value)
	{
		this.radius = value;
	}
	
	
	
	public float getradius()
	{
		return this.radius;
	}

	
	public String toString()
	{
		super.toString();
		String res = ("αστέρι με ακτίνα <"+ this.radius + ">");
		System.out.println(" " +res);
		return res;
	}
	
	
	Star(String name, float mass, float radius) 
	
	{
		super(name, mass);
		setradius(radius);
		
		
	}






public Star() {
}



public static void main(String[] args) 

    {
	  
	  Star Blyat = new Star("Blyat", 2000, 500);	  
	  Blyat.toString();

	}

}
