package csd.uoc.gr.A23.guns;

public interface Warrior 
{
	
	public int getHealth();
	public boolean isAlive();
	public void damageHealth(int damage);
	 public void attack(Warrior adversary) throws DeadWarriorException; 
	

}
