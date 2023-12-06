package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * This class represents the Mail Card Bill
 * 
 *
 */
public abstract class Bill implements Card{
	protected String name;
	protected String message;
	private int Money_C;
	/**
	 * <b>Accessor</b>: Returns the money of the Bill Card <br />
	 * <b>post-condition</b>: Returns the money of the Bill Card 
	 * @return Money_C the Money of the Bill Card
	 */
	public abstract int get_Money_C();
	/**
	 * <b>Transformer</b>: Sets the Money of a Bill Card <br />
	 * <b>post-condition</b>; the Money_C of the Bill Card is changed to money_C
	 * @param money_C the new Money_C of the Bill Card
	 */
	public abstract void set_Money_C(int money_C);
	/**
	 * <b>Observer</b>: Charges the player P1 with an amount of money(Money_C)and gives him the card <br />
	 * <b>post-condition</b>: The Money_C of the card is added to the Bill of the player P1 and then the card goes to
	 * the array BC of the player P1
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Bill Card with the given name , Money_C and message <br />
	 * <b>post-condition</b>: Creates and initializes a Bill Card with the given name 
	 * , Money_C and message
	 * @param name the name of the Card
	 * @param Money_C the Money that the player has to pay
	 * @param message the message that the Bill Card contains
	 */
	public Bill (String name , int Money_C , String message){}
}
