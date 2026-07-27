package model;

import java.util.List;

public class Player {
	Sylogi cards =new Sylogi();
	private String name;
	private int points;
	private int specialpoints;
	private int playerpoints;
	
	//contractor give a name to the player
	public Player(String name,int points){
		this.points=points;
		this.name=name;
	}
	//set the handcards for player and return it
	//pre condition array in sylogi not null
	public List<Card> Handcards(){
		return null;}
	//post conditon set the Pawns
	public void Pawn(){}
	//pre condition Pawns has been set
	//post condtion return the the kingdom of the Pawns
	public Kingdom PawnAss (){
		return null ;}
	
	//returns the collection of special items and points
	//post condition return special points
	public int  Collection(){
		return specialpoints;}
	//return the points of position
	public int TablePoints(){
		return 0;}
	//return the final score
	public int PlayerScore(){
		return playerpoints;}
	//play a pawn and keep its position
	public int PlayPawn(){
		return 0;}
	//play a number card with its actions
	public void PlaynumberCard(NumberCard c){}
	//play a specia card with its actions
	public void PlaySpecialCard(SpecialCard c){}
	//checks if player has 8 cards in hand 
	public void CheckHandCards(){}
	//add a card to player hand
	public void DrowCard(){}
	//check for the end of the turn
	public boolean EndTurn(){
		return false;}
	  //check and return if the game has started
	public boolean GameStarted(){
		return false;}
	
	
	
	
	
	
	

}
