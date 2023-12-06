package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Yard Sale Position
 * @author 
 *
 */
public abstract class Yard_Sale implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: The Player P1 rolls a dice and gives 100x(dice) to the bank,
	 * then takes the top Deal Card for free <br />
	 *<b>post-condition</b>: the Player P1 rolls the dice and removes 100x(dice) from his Money and then
	 *then moves the top Deal Card to his Cards
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player 
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Yard_Sale Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Yard_Sale Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Yard_Saler Position contains
	 */
	public Yard_Sale(String name , String message){}
}
