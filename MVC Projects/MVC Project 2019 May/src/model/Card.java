package model;

public abstract class Card {
	public String name;
	public int Value;
	public  Kingdom c;
	//get the number of the card
	 //<b>Accessor:</b> returns the card's value
   //   <b>Postcondition:</b> card's value has been returned
		public abstract int getValue();
		// set the number of the card 
		//<b>Transformer:</b> sets the card's value
	     // <b>Postcondition:</b> card's value has been set
		public abstract void setValue(int value);

	//constractor for 1-10 cards
	public Card(String name,Kingdom type,int Value){}
	//constractor for the rest of the cards
	public Card(String name,Kingdom type){}
	
//check if card can be played and the type
public void matchCard(Kingdom type)	{}
//post conditio return the name
//return the cards full name
public  String toString(){
	return name;}
}


