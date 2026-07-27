package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * 
 * 
 *
 */
public abstract class Mad_Money implements Card{
	protected String name;
	protected String messsage;
	private int Money_c;
	/**
	 * <b>Accessor</b>: Returns the money of the Mad_Money Card <br />
	 * <b>post-condition</b>: Returns the money of the Mad_Money Card 
	 * @return Money_C the Money of the Mad_Money Card
	 */
	public abstract int get_Money_C();
	/**
	 * <b>Transformer</b>: Sets the Money of a Mad_Money Card <br />
	 * <b>post-condition</b>; the Money_C of the Mad_Money Card is changed to money_C
	 * @param money_C the new Money_C of the Mad_Money Card
	 */
	public abstract void set_Money_C(int money_C);
	/**
	 * <b>Observer</b>: Charges the player P2 with an amount of money(Money_C), gives it to the Player P1
	 * and then moves the card to the pile <br />
	 * <b>post-condition</b>: The Money_C of the card is added to the Money of the player P1 and removed from
	 * the Money of the Player P2 and the the card moves to the pile
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Mad_Money Card with the given name , Money_C and message <br />
	 * <b>post-condition</b>: Creates and initializes a Mad_Money Card with the given name 
	 * , Money_C and message
	 * @param name the name of the Card
	 * @param Money_C the Money that the player P2 has to pay
	 * @param message the message that the Mad_Money Card contains
	 */
	public Mad_Money (String name , int Money_C , String message){}
}
