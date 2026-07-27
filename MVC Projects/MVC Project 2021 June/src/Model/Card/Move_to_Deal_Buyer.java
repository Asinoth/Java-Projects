package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * This class represents the Mail Card Move to Deal/Buyer
 * 
 *
 */
public abstract class Move_to_Deal_Buyer implements Card{
	protected String name;
	protected String message;
	/**
	 * <b>Observer</b>: Moves the Player P1 to the nearest Deal/Buyer position and then the card moves to the pile <br />
	 * <b>post-condition</b>: The position of the Player P1 changes and then the card moves to the pile
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Move_to_Deal_Buyer Card with the given name and message <br />
	 * <b>post-condition</b>: Creates and initializes a Move_to_Deal_Buyer Card with the given name 
	 * and message
	 * @param name the name of the Card
	 * @param message the message that the Bill Card contains
	 */
	public Move_to_Deal_Buyer (String name , String message){}

}
