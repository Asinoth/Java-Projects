package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Buyer Position
 * 
 *
 */
public abstract class Buyer implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Asks the Player what Deal Card he wants to sell and then sells it(removes it from the Player) <br />
	 *<b>post-condition</b>: Asks the Player what Deal Card he wants to sell then Adds the Sell_Money of the
	 *Deal card to the Money of the Player and then moves the Deal Card to the Pile
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Buyer Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Buyer Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Buyer Position contains
	 */
	public Buyer (String name , String message){}
}
