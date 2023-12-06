package Model.Position;

import Model.Player.Player;
/**
 * This class represents the Lottery Position
 * 
 *
 */
public abstract class Lottery implements Position{
	protected String name;
	protected String message;
	/**
	 *<b>Observer</b>: Asks the Players to chose a number from 1 to 6 and then rolls a dice, whoever guises 
	 *correct then takes 1000 , if both wrong the rolls the dice again <br />
	 *<b>post-condition</b>: Asks the Players for a number from 1-6 ,then rolls a dice and whoever guises 
	 *correct then 1000 are added to his Money , if both wrong then rolls dice again
	 *@param P1 the Player that plays this turn
	 *@param P2 the other Player
	 */
	public abstract void Perform_Action(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Lottery Position with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Lottery  Position with the given name and message
	 * @param name the name of the Position
	 * @param message the message that the Lottery  Position contains
	 */
	public Lottery(String name ,String message){}
}
