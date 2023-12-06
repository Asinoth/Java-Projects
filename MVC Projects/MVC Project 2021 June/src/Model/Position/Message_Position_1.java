package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Message Position
 * 
 *
 */
public abstract class Message_Position_1 implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Draws a Message_Card <br />
	 *<b>post-condition</b>: Draws a Message_Card
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Message_Position_1 Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Message_Position_1 Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Message_Position_1 Position contains
	 */
	public Message_Position_1(String name, String message){}

}
