package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Message Position
 * 
 *
 */
public abstract class Message_Position_2 implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Draws 2 Message_Cards <br />
	 *<b>post-condition</b>: Draws 2 Message_Cards
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Message_Position_2 Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Message_Position_2 Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Message_Position_2 Position contains
	 */
	public Message_Position_2(String name, String message){}
}
