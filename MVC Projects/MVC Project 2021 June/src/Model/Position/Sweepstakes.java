package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Sweepstakes Position
 * 
 *
 */
public abstract class Sweepstakes implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Rolls a dice for the Player P1 and wins the number of the dice x 1000 <br /> 
	 *<b>post-condition</b>: Rolls a dice for the Player P1 and adds 1000x(dice) to the Money of the Player P1
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player 
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Sweepstakes Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Sweepstakes Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Sweepstakes Position contains
	 */
	public Sweepstakes(String name , String message){}
}
