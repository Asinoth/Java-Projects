package model;

import java.util.ArrayList;
import java.util.List;

//creates the deck of cards
public class Sylogi {

	List<Card> cards= new ArrayList<Card>();
	//Creates the 1-10 cards
	//post condition return list
	public String[] numbercards(){
		String[] NumberCards = new String[100];
		for (int j=1;j<=10;j++){
			NumberCards[j]="/cards/knossos"+j+".jpg";}
		for (int j=11;j<=20;j++){
			NumberCards[j]="/cards/malia"+(j-10)+".jpg";}
		for (int j=21;j<=30;j++){
			NumberCards[j]="/cards/phaistos"+(j-20)+".jpg";}
		for (int j=31;j<=40;j++){
			NumberCards[j]="/cards/zakros"+(j-30)+".jpg";}
		return NumberCards;
		
	}
	;
	
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
