package model;

public class SpecialCard extends Card {
	//constractor for special cards
	
	public SpecialCard(String name, Kingdom type) {
		super(name, type);
		
	}
	// set the number of the card 
				//<b>Transformer:</b> sets the card's value
			     // <b>Postcondition:</b> card's value has been set
				
	public  void setValue(int value) {
				}
				
	//get the number of the card
		 //<b>Accessor:</b> returns the card's value
	   //   <b>Postcondition:</b> card's value has been returned
			
				public int getValue(){
				return 0;}
			
//it returns the effect of the special card
			public  int CardEfect(){
				return 0;}
}
