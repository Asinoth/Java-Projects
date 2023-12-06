package Model.Card;

import Model.Card.Card;
/**
 * This Class Contains the Arrays for all the Message Cards
 * 
 *
 */
public abstract class Message {
	protected Card [] Message_Cards;
	protected int top_M;
	protected Card [] Pile_Message_Cards;
	protected int top_PM;
	/**
	 * <b>Observer</b>: Returns if the Array Message_Cards is empty <br />
	 * <b>post-condition</b>: Returns if the Array Message_Cards is empty
	 * @return true if the Array Message_Cards is empty false otherwise
	 */
	public abstract boolean is_empty();
	/**
	 * <b>Constructor</b>: Constructs a new Message object with the Arrays Message_Cards and Pile_Message_Cards <br />
	 * <b>post-condition</b>:  Creates and initializes a Message object with the Arrays Message_Cards
	 * and Pile_Message_Cards
	 */
	public Message(){}
}
