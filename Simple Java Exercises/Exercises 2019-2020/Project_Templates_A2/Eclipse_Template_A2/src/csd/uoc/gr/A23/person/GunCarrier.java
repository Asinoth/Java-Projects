package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;

public class GunCarrier 

{
	
	private  Gun gun;
	
	
	void setGun(Gun gun)
	{
		this.gun = gun;
	}
	
	Gun getGun()
	{
		return this.gun;
	}
	
	
	
	public GunCarrier(Gun gun) 
	
	{
		
		setGun(gun);
	}
	
	public GunCarrier() 
	{
		
	}

}
