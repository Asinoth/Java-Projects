package Model;

import java.util.ArrayList;

public class Player 
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	private TrainCard my_train_cards[];
	private DestinationCard my_destination_cards[];
	private BigCitiesCard my_bigcities_cards[];
	private RailYard my_yard;
	public OnTheTrack my_track;
	private int score;
	
	
	//constructor
	
	
	public Player()
	{
		
	}
	
	   //gets the player's score
		//Accessor: return the player's score value
		//Postcondition: the player's score is returned
	
	
	public int getScore() {
		return this.score;
	}
	
	    //sets the player's score
		//Transformer: changes the player's score value
		//Postcondition: the player's score is changed

	
	public void setScore(int score) {
		this.score = score;
	}
	
	    //gets the player's yard 
		//Accessor: return the player's yard
		//Postcondition: the player's yard is changed

	
	public RailYard getMy_yard() {
		return this.my_yard;
	}
	
	
	    //changes the current player's yard
		//Transformer: the player's yard is changed
		//Postcondition: the player's yard has been changed

	public void setMy_yard(RailYard my_yard) {
		this.my_yard = my_yard;
	}
	
	

	        //gets the player's big cities cards 
			//Accessor: return the player's big cities cards
			//Postcondition: the player's big cities cards are returned

	
	
	public BigCitiesCard[] getMy_bigcities_cards() {
		return this.my_bigcities_cards;
	}
	
	

	//gets the player's destination cards 
	//Accessor: return the player's destination cards
	//Postcondition: the player's destination cards are returned
	
	
	public DestinationCard[] getMy_destination_cards() {
		return this.my_destination_cards;
	}
	
	

	//gets the player's train cards 
	//Accessor: return the player's train cards
	//Postcondition: the player's train cards are returned
	
	
	public TrainCard[] getMy_train_cards() {
		return this.my_train_cards;
	}

	
	//gets the player's On Track view 
	//Accessor: return the player's track object
	//Postcondition: the player's track object is returned
	
	
	public OnTheTrack getMy_track() {
		return this.my_track;
	}

	
	//sets the player's track object 
	//Transformer: changes the player's track object value
	//Postcondition: the player's track object value is changed
	
	
	public void setMy_track(OnTheTrack my_track) {
		this.my_track = my_track;
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}


	
	
}
