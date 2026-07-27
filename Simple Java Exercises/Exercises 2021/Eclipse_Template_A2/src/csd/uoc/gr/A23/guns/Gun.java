package csd.uoc.gr.A23.guns;

public abstract class Gun {
	
	private final int power;
	public int getPower()
	{
		return this.power;
	}
	
	
	
	public Gun(int power)
	{
		Gun a = new Gun();
		a.power = power;
		
	}

}
