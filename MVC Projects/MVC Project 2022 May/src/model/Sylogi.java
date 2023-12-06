package model;

import java.util.ArrayList;
import java.util.List;

//creates the deck of cards
public class Sylogi {

	List<Card> cards= new ArrayList<Card>();
	//Creates the 1-10 cards
	//post condition return list
	public List<Card> numbercards(){
		return cards;
	};
//creates and ads to card special cards
	//post condition return list
public List<Card> specialcards(){
	return cards;
}
//creates the whole cards of the game 
//post condition return the list
public List<Card> Allcards(){
	return cards;
}
//set and return the card of the player in his hand
public List<Card> CrardsInHand(){
	return cards;
}
//removes the card from the list
public List<Card> Popout(Card c){
	return cards;}

}
