package Model;

public abstract class Card 

{

	private boolean is_active;
	private String belongs;
	
	//changes card to inactive(used)
	//Transformer: changes the card's boolean
	//Postcondition: card's boolean value has been set
	
	
	public void change_active(Card given)
	{
		given.is_active = false;
	}
	
	
	//sets card's owner
	//Transformer: changes the card's String
	//Postcondition: card's String value has been set
	
	
	public void card_owner(Card given, String name)
	{
		given.belongs = name;
	}
	
	
	//get the activity of the card
	//Accessor: return the card's boolean value
	//Postcondition: card's value has been returned
	
	
	public boolean is_active(Card given)
	{
		return given.is_active;
	}
	
	
	    //get the owner of the card
		//Accessor: return the card's belong value
		//Postcondition: card's belong value has been returned
	
	
	public String is_owner(Card given)
	{
		return given.belongs;
	}
	
	
	//constructor for initialization
	
	
	public Card(String belong, boolean active)
	{
		
	}
	
	
	//general constructor
	
	
	public Card()
	{
		
	}
	
}
