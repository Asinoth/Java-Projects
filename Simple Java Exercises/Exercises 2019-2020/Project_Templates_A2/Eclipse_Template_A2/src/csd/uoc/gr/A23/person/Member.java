package csd.uoc.gr.A23.person;

import csd.uoc.gr.A23.armor.Gun;
import csd.uoc.gr.A23.exception.DeadCharacterException;

public abstract class Member extends GunCarrier implements Character 

{
	int health;
	final String name;
	final boolean bodyArmor;
	final int iq;
	final int physicalStrength;

	
	
	public Member (String name, int	health, Gun gun, boolean bodyArmor, int iq, int	physicalStrength)
	{
		this.setGun(gun);
		this.name = name;
		this.health = health;
		this.bodyArmor = bodyArmor;
		this.iq = iq;
		this.physicalStrength = physicalStrength;
	}


	
	
	
	public boolean isAlive() 
	
	{
		if(this.health > 0)
			return true;
		else
		return false;
	}

	
	
	public int getHealth()
	
	{

		return this.health;
	}

	String getName() 
	{
		return this.name;
	}
	
	boolean hasBodyArmor() 
	{
		return this.bodyArmor;
	}
	
	
	
	
	public void damageHealth(int damage)
	
	{
		this.health -= damage;

	}

	
	
	public int calculateAtomicPower() 
	
	{
		
		return this.iq + this.physicalStrength;
	}
	
	void fight(Character adversary) throws DeadCharacterException
	{
		if(this.health <= 0 )
			throw(new DeadCharacterException());
			
			
		int member_gun_pow = this.getGun().getPower();
		
		int adv_H = adversary.getHealth();
		
		if(adv_H == 10 || adv_H == 12 || adv_H == 15 || adv_H == 17)
		{	if(adv_H == 17)
				adversary.damageHealth(2);
		
			else
			{
				
			
			
			
			}
		
		
		
		}
		
	}

}
