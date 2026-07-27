package csd.uoc.gr.A23.guns;

public class GunCarrier 

{
	private Gun mine;
	
	
		public Gun getGun()
		{
			
			return this.mine;
		}
		
		public Gun setGun(Gun gun)
		{
			this.mine = gun;
			return mine;
			
		}
	
	
	protected GunCarrier(Gun gun)
	{
		GunCarrier fresh = new GunCarrier(gun);
		
		
	}

}
