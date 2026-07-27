package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Deal Position
 * 
 *
 */
public abstract class Deal_Position implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Draws a Deal Card <br />
	 *<b>post-condition</b>: Draws a Deal Card
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Deal Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Deal Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Deal Position contains
	 */
	public Deal_Position(String name ,String message){}
}
