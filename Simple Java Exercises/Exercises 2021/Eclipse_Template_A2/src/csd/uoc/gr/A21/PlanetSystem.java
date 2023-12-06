package csd.uoc.gr.A21;

public class PlanetSystem 

{
	
	private String name;
	private Star centralStar; 
	private int activeCapacity = 0;
	private CelestialBody[] planets = new CelestialBody[100];

	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setCentralStar(Star central)
	{
		centralStar = central;
	}
	
	public void addPlanet(CelestialBody c)
	{
		int index = this.activeCapacity;
		planets[index] = c;
		this.activeCapacity++;
		
		
	}
	
	
	
	
	
	public String getname()
	{
		return this.name;
	}
	
	public String getCentralStar()
	{
		return this.centralStar.getname();
	}
	
	
	
	
	public String toString()
	{
		
		String res = ("Όνομα Πλανητικού Συστήματος  <"+ this.getname() + ">,  Κεντρικό Αστέρι:  <"+ this.getCentralStar() + ">,  Πλήθος Πλανητών:  <" + this.activeCapacity + ">");
		System.out.println(res);
		for(int i =0; i< this.activeCapacity; i++)
		{
			planets[i].toString();
			
		}
		return res;
		
	}
	
	
	PlanetSystem(String name, Star central) 
	
	{
		setname(name);
		setCentralStar(central);
	}
	
	
	

	public static void main(String[] args) 
	
	{
		Star first = new Star("Alex", 222, 555);
		PlanetSystem a = new PlanetSystem("mine",first);
		a.addPlanet(first);
		a.toString();

	}

}
