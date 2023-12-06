package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Family Casino Night Position
 * 
 *
 */
public abstract class Family_Casino_Night implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Checks the dice of the Player P1.If it is 1,3,4 then the Player gives 500 to the Jackpot,
	 *else if it is 2,4,6 then the Player gets 500 <br />
	 *<b>post-condition</b>: If the dice of the Player P1 is 1,3,4 then 500 are removed from the Money the Player and 
	 *added to the Jackpot , else if the dice is 2,4,6 then 500 are added to the Money of the Player
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Family_Casino_Night Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Family_Casino_Night Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Family_Casino_Night Position contains
	 */
	public Family_Casino_Night(String name ,String message){}
}
