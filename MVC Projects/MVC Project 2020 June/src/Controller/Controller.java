package Controller;
import java.awt.*;
import java.util.ArrayList;

import Model.Card;
import Model.Deck;
import Model.Player;

	public class Controller 
	{
		public  Deck allcards = new Deck();
		 private Player P1,P2;
		        public Controller()
		        {
		            P1=new Player();
		            P2=new Player();
		            }
		        
		        // transformer initialize 3 types of cards for each player 
		        
		        
		        public void setCards()
		        {
		   
		        	
		        }
		        
		        
		        
		        
		        //transformer initialize the deck
		        
		        
		        public void set_deck()
		        {
		        	
		        }
		        
		        
		        
		        
		        //transformer chooses first player to start the game
		        
		        
		        public void start()
		        {
		        	
		        	
		        }
		        
		   
		        
		        
		        
		        //transformer distributes cards to each player
		        
		        
		        public void distribute()
		        {
		        	
		        	
		        }
		        
		        
		        //transformer set each player's hand cards
		        
		        
		        public void hand()
		        {
		        	
		        	
		        }
		        
		        
		        
		        
		        //removes card from the deck and Player's hand
		        //pre condition chosen card must have been initialized 
		        
		        
		        public void removecard(Card given)
		        {
		        	
		        	
		        }
		        
		        
		        
		        
		        
		        

		        
		        //Player plays card
		        
		        
		        public  void playnormalCard(Card given)
		        {
					
		        }
		        
		        
		        public void check_valid_card(Card given)
		        {
		        	
		        	
		        }
		        
		        
		        //Move a card to the Player's Yard
		        
		        
		        public void move_to_YardCard(Card given)
		        {
		        	
		        }
		        
		        
		        //Move a card On Track
		        
		        
		        public void move_on_TrackCard(Card given)
		        {
		        	
		        }
		        
		        
		        
		       //Cash a card for points
		        
		        
		        public void CashCard(Card given)
		        {
		        	
		        }
		        
		        
		        //Draw a train card from the deck
		        
		        
		       public void draw_train_card()
		       {
		    	   
		       }
		        
		        
		       
		       
		       //Draw a destination card from the deck
		        
		        
		       public void draw_dest_card()
		       {
		    	   
		       }
		       
		       
		        
		        //update the score of a player
		        
		        
		        public void PlayerScore(Player p, int score)
		        {
		        	
		        }
		        
		        
		       
		        //check if the game conditions for finishing are met
		        
		        
		        public boolean CheckIfFinished()
		            {
						return false;
					
					}
		        
		        
		        //check if the game is a drow
		        
		        
		        public Player CheckForDrow()
		        {
					return P1;
					
					}
		        
		        
		         //Observer: check which of the two players has won
		         //Precondition: two players must exist
		    	 //Postcondition: returns which player has won
		    	 //return p1 or p2
		    	public Player winner(Player p1, Player p2)
		    	{
					return p2;
		    		
		    		
		    	}
		        
		        
		        
	}



