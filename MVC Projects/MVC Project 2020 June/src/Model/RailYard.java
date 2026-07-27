package Model;

import java.util.*;
public class RailYard 
{
	
	private List<Card>[] cards;
	
	

    //extends a player's yard Cards
	//Transformer: adds cards to a player's yard Cards
	//Postcondition: the player's yard Cards are extended
	
	
	public void add_card(Card given)
	{
		
	}
	
	

    //gets the player card from the yard cards
	//Accessor: returns the player's card from the yard cards
	//Postcondition: the player's yard card is returned
	
	public Card get_card(Card given)
	{
		return given;
		
	}

	

	    //A player plays a card
		//Transformer: removes cards from a player's yard Cards
		//Postcondition: the player's yard Cards are played
		
	
	
	public void playCards(List<Card> list, int index, RailYard enemy)
	{
		
	}
	
	
	    //checks from train robbing and if so removes cards from enemy
		//Transformer: removes cards from opponent if available
		//Precondition: the opponent must have cards to be removed
		//Postcondition: the opponent's cards have been removed
		
	public void Train_Rob(List<Card> list, int index, RailYard enemy)
	{
		
	}
	
	
	//constructor
	
	
	public RailYard()
	{
		
	}



	public List<Card>[] getCards(int index) {
		return this.cards;
	}

	
	
	

}
