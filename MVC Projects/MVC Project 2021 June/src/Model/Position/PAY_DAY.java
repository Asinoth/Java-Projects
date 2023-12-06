package Model.Position;

import Model.Player.Player;
/**
 * This class represents the PAY DAY Position
 * 
 *
 */
public abstract class PAY_DAY implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Gives the Player P1 2500 and balances his Bills and Loans, then checks if he has
	 *finished the game and then sets his position to 0 (if he still plays) <br />
	 * <b>post-condition</b>: Adds 2500 to the Money of Player P1, the balances his bills and Loans(and do all
	 * the necessary stuff for that) and then check if the player has any months left , if true then sets
	 * the position of the Player P1 to 0 ,else if false he sets the boolean is_finished of Player P1 to true 
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new PAY_DAY Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a PAY_DAY Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the PAY_DAY Position contains
	 */
	public PAY_DAY(String name, String message){}
}
