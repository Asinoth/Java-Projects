package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Radio Contest Position
 * 
 *
 */
public abstract class Radio_Contest implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Rolls a dice for both Players and whoever has the biggest number wins 1000,
	 *if both Players have the same number then they roll again <br />
	 *<b>post-condition</b>: Rolls a dice for both Players and the one with the biggest number adds 1000 to his Money,
	 *if both Players roll the same number then the roll again
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player 
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Radio_Contest Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Radio_Contest Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Radio_Contest Position contains
	 */
	public Radio_Contest(String name , String message){}
}
