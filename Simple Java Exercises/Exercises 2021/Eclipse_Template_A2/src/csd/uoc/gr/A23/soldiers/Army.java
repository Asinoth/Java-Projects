package csd.uoc.gr.A23.soldiers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Army 
{
	private String armyName;
	List soldiers;
	
	
	
	public String getArmyName()
	{
		return this.armyName;
		
		
	}
	
	public int getSize()
	{
		String size = this.soldiers.toString();
		return size.length();
	}
	
	
	
	Army(String name)
	{
		Army mine = new Army(name);
		mine.soldiers = new List();
		
		
	}

}
