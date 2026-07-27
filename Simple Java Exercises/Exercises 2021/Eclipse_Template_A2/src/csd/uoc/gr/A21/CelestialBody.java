package csd.uoc.gr.A21;

public class CelestialBody 

{
	
	private String name;
	private float mass;
    public  enum Type
	{
		Rounded(1), NotRounded(2);
		
		private int value;
		Type(int value){this.value = value;}
		public int gettype() {return value;}
		
	}
    
    private Type type;
    
    
    
	
	
	public void setType(int val)
	{
		if(val == 2)
		{
		type = Type.NotRounded;
		}
		
		else if(val == 1)
		{
			type = Type.Rounded;
		}
	}
	
		
	public void setname(String namegiven)
	{
		this.name = namegiven;
		
	}
	
	
	
	public void setmass(float massgiven)
	{
		this.mass = massgiven;
	}
	
	
	
	
	public Type getType()
	{
		return this.type;
		
	}
	
	public String getname()
	{
		return name;
	}
	
	public float getmass()
	{
		return mass;
	}
	
	
	
	
	public String toString()
	{
		String pn = getname();
		Type pt = getType();
		float pf = getmass();
		String ret = ("  Ουράνιο Σώμα  <" + pn + ">" + ",  Τύπος:  <" + pt + ">,  Μάζα:  <" + pf + ">");
		System.out.println(ret);
		return ret;
	}
	
	
	
	CelestialBody(String name, float mass)
	{
		this.setname(name);
		this.setmass(mass);
		this.setType(2);
		
	}
	
	



	 CelestialBody() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) 
	
	{
		CelestialBody a = new CelestialBody("Orion", 50);
		a.toString();

	}

}
