package csd.uoc.gr.A23.soldiers;

import csd.uoc.gr.A23.guns.DeadWarriorException;
import csd.uoc.gr.A23.guns.Gun;
import csd.uoc.gr.A23.guns.GunCarrier;
import csd.uoc.gr.A23.guns.Warrior;

public abstract class Soldier extends GunCarrier implements Warrior
{

	private String name;
	final boolean bodyArmor;
	private int health;

	
	public int getHealth()
	{
		return this.health;
		
		
	}
	
	public String getName()
	{
		
		return this.name;
		
	}
	
	
    public boolean isAlive()
	{
		if(this.health > 0)
			return true;
		else
			return false;
	}
    
    public boolean hasBodyArmor()
    {
    	if(bodyArmor == true)
    		return true;
    	else
    		return false;
    	
    	
    }
	
	public void damageHealth(int damage)
	{
		this.health = this.health - damage;
		
	}
	
	public void attack(Warrior adversary) throws DeadWarriorException 
	{
		int damage = this.getGun().getPower();
		if(adversary.getHealth() < 0)
		{
			throw new DeadWarriorException(adversary);
			
			
		}
		
		else
		{
			if(adversary instanceof Soldier );
			
			{
				
			adversary.damageHealth(damage);
			}
			
			
			
		}
	}


	
	
	
	public Soldier(Gun gun) {
		super(gun);
		
	}
	
	
	Soldier(String name, int health, Gun gun, boolean bodyArmor)
	{
		this.name = name;
		this.health = health;
		this.setGun(gun);
		this.bodyArmor = bodyArmor;
		
		
	}

}
