package csd.uoc.gr.A21;

import java.util.Random;

public class MyUniverse 

{

	public MyUniverse() 
	
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	
	{
		Star Sun = new Star("Sun", 1, 1);
		CelestialBody Earth = new CelestialBody("Γη", 2);
		Earth.setType(1);
		CelestialBody Mars = new CelestialBody("Άρης", 1);
		Mars.setType(1);
		CelestialBody Hera = new CelestialBody("532Ηρακλεία", 2);
		PlanetSystem first = new PlanetSystem("Ηλιακό Σύστημα", Sun);
		first.addPlanet(Earth);
		first.addPlanet(Mars);
		first.addPlanet(Hera);
		first.toString();
		System.out.println("");
		
		
		float random = new Random().nextFloat();
		Star BlueSun = new Star("Blue Sun", random, random);
		PlanetSystem second = new PlanetSystem("Jedai's System", BlueSun);
		for(int i = 0; i<= 49; i++)
		{
			String name = "CB" + i;
			CelestialBody a = new CelestialBody(name, random);
			second.addPlanet(a);

		}
		
		second.toString();
		
		
	}

}
