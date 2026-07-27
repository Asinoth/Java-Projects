package Model;

public class PointsCard extends Card

{
	private int points;
	private String start_city;
	
	
	//sets the player's starting city value
	//Transformer: changes the player's starting city value
	//Postcondition: the player's starting city value is changed
	
	
	public void set_start_city(PointsCard given, String cit)
	{
		given.start_city = cit;
	}
	
	
	//gets the player's start city value
	//Accessor: return the player's start city value
	//Postcondition: the player's start city value is returned
	
	public String get_start_city(PointsCard given)
	{
		return given.start_city; 
	}
	
	
	    //sets the player's points
		//Transformer: changes the player's points value
		//Postcondition: the player's points value is changed
		
	
	public void set_points(PointsCard given, int po)
	{
		given.points = po;
	}
	
	
	    //gets the player's points
		//Accessor: return the player's points value
		//Postcondition: the player's point value is returned
	
	

	public int get_points(PointsCard given)
	{
		return given.points;
	}
	
	
	//constructor with initialization
	
	public PointsCard(String owner, boolean active, int point, String name) 
	{
		
	}

	
	
	
	//general constructor
	
	
	public PointsCard() 
	{
		
	}

}
