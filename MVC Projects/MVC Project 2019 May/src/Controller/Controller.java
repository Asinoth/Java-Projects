package Controller;

import java.util.ArrayList;
import java.util.Random;

import model.FindingPosition;
import model.GodnessOfTheSnakes;
import model.NumberCard;
import model.Path;
import model.Player;
import model.Sylogi;
import model.Findings;
import model.Card;
import view.GraphicsUi;
import view.ToixografiesNewWindow;


// Controller is the master of the game and controls all of the operations executed

public class Controller {
	public int position;
	private  Sylogi allcards = new Sylogi();
	 private Sylogi cardsToPlay = new Sylogi();
	 private Sylogi discard = new Sylogi();
	 private Player P1,P2;
	 private ArrayList <Player> players=new ArrayList<Player>();
	 private ArrayList <Player> pionia=new ArrayList<Player>();
	 /* <b>constructor</b>: Constructs a new Controller and sets the game as 
		* eligible to start .<br />
		* <b>postcondition</b>: constructs a new Controller,with new 2 players,new 
	        * Sullogi Class and initialize
	        * some int or boolean variables.So,is responsible for creating a new game and 
		* initializing it.
		*/
	        public Controller()
	        {
	           
	            P1=new Player("p1",0);
	          
	            P2=new Player("p2",0);
	            
	            players.add(P1);
	            players.add(P2);
	            }
	     // transformer initialize 4 set of pawns for each player 
	        public void setPionia(){
	        	
	        }
	        //transformer initialize all cards of the game
	        public String[] setallcards(){
	        	Sylogi flb=new Sylogi();
	        	String [] lbl=flb.numbercards();
	        	return lbl;
	        }
	        //removes card from the all cards
	        //pre condition cards has been initialize 
	        public void removecards(){}
	        //transformer set the hand for players
	        public int hand(){
	        	Random rand = new Random();
	        	int randomNum = rand.nextInt((40 - 1) + 1) + 1;
	        	return randomNum;
	        }
	        
	        //random choose the player that starts
	        public int start(){
	        	 Random rand = new Random(); 
	        	int randomNum = rand.nextInt((2 - 1) + 1) + 1;
	        	return randomNum;}
	        //player play normal card
	        public  void playnormalCard(NumberCard c){
				}
	        //check if can be played normal card
	        public void checknormalCard(Card c){}
	        //Store the power of the card and mooves the player
	        public void EffectnormalCard(Card c){}
	        //check for special card and take place the effect
	        public void EffectSpecialCard(Card c){}
	       //Check if the effect of the minotaur card can take place
	        public void CheckEffect(Card c){}
	        //Check for findings in the path and update View
	        public boolean CheckFindgings(FindingPosition c){
	        	Findings f=new Findings();
	        	return f.Checktaken();
	        }
	        //show the dialog of the finding
	        public void Dialog(){}
	        //update the number of the statues found
	        public int PlayerStat(){
	        	GodnessOfTheSnakes s=new GodnessOfTheSnakes();
	        	int number=s.NumberOfstatues();
				return number;
	        }
	        //update the score of the findings
	        public int PlayerScore(){
				return 0;}
	        
	        
	       
	        //check if the path is in the end
	        public void CheckPath(){
	        	Path p=new Path(null);
	        	p.Stages();
	        }
	        //check if the game conditions for finishing is ok
	        public boolean CheckIfFinished(){
				return false;}
	        //return the winner in case of a drow
	        public Player CheckForDrow(){
				return P1;}
	        
	        /**
	    	 * <b>Observer:</b> check which of the two players has won
	    	 * <b>Postcondition:</b> returns which player has won
	    	 
	    	 * @return p1 or p2
	    	 */
	    	public Player winner(Player p1, Player p2){
	    		return p1;
	    		
	    	}
	        
	        
	        
	        

}
