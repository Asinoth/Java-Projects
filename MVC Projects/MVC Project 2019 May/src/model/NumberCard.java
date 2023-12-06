package model;
//creates number card
public class NumberCard extends Card{
	private int value;
	public Kingdom type;
//constractor initialize the number card 
	public NumberCard(String name, Kingdom type, int Value) {
		super(name, type, Value);
		
	}



	//<b>Accessor:</b> returns the card's value
   // * <b>Postcondition:</b> card's value has been returned
	public int getValue() {
		
		return 0;
	}

	@Override
	//<b>Transformer:</b> sets the card's value
   // * <b>Postcondition:</b> card's value has been set
	public void setValue(int value) {
		
		
	}
	//check for the type of the card
	//post conditionreturn the type for check
	public Kingdom Cardtype(){
		return null;
	
	}
	//return the name
	
	public  String toString(){
		return name;}
	
	
	

}
