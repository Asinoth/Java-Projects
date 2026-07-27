package Controller;

import Model.Player.Player;
/**
 * This class is responsible for all the control of the game
 * 
 *
 */
public abstract class Controller {
	/**
	 * <b>observer</b>: Takes all the necessary information from the user , initializes all the  necessary 
	 * Components(Players , Cards ,Positions) and then Starts the game <br />
	 * <b>post-conditions</b>: Makes all the necessary preparations to Start the game
	 */
	public abstract void Start ();
	/**
	 * <b>Observer</b>: Controls the flow of the game (what the player has to do and when) <br />
	 * <b>post-conditions</b>: Changes the variables of the Players P1 and P2 and 
	 * call the methods end_turn , is_finished , Sunday_Match , Perform_Action , win_Jackpot and get_Card
	 * @param P1 the Player that plays this turn
	 * @param P2 the other player
	 */
	public abstract void controller (Player P1 , Player P2);
	/**
	 * <b>Observer</b>:Ends the turn of the player whose playing <br />
	 * <b>post-condition</b>:Calls the controller of the Players with other Parameters
	 * @param P1 the Player that plays this turn
	 * @param P2 the other player
	 */
	public abstract void end_turn(Player P1 , Player P2);
	/**
	 *<b>Observer</b>: Sees who won the game and displays it (will be called when both players have finished the game) <br />
	 *<b>post-condition</b>: Checks which Player has the most Money after they pay their Loans and Displays the winner
	 * @param P1 the Player that plays this turn
	 * @param P2 the other player
	 */
	public abstract void is_Finished(Player P1 , Player P2);
	/**
	 * <b>observer</b>: Asks the player if he wants to bet for a football match 
	 * if he wins it he gains 500 euros else he loses 500 euros
	 * (this method is called only when in certain positions on the board) <br />
	 * <b>post-conditions</b>: Asks the Player P1 if he wants to bet, if he wins he 500 are added to his Money
	 * if he loses 500 are removed from his Money
	 * @param P1 the Player that plays this turn
	 */
	public abstract void Sunday_Match(Player P1);
	/**
	 * <b>Observer</b>: Gives the Player a Loan of 1000 euros <br />
	 * <b>post-conditions</b>: Adds 1000 to the Loan and Money of the Player P1
	 *@param P1 the Player that plays this turn
	 */
	public abstract void get_Loan(Player P1);
	/**
	 * <b>Observer</b>: Calls method Start to Start the game <br />
	 * <b>post-conditions</b>: calls the method Start
	 * @param args
	 */
	public static void main(String[] args) {}

}
