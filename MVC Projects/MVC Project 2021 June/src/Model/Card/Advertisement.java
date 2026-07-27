package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * This class represents the Mail Card Advertisement 
 * 
 *
 */
public abstract class Advertisement implements Card{
	protected String name;
	protected String message;
	/**
	 * <b>Observer</b>: Shows the player an Advertisement card and then sends it to the pile <br />
	 * <b>post-condition</b>:Shows the Advertisement card to the player and then sends it to the pile
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Advertisement Card with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes an Advertisement Card with the given name and message
	 * @param name the name of the card
	 * @param message the message that the Advertisement Card contains
	 */
	public Advertisement (String name , String message){}

}
