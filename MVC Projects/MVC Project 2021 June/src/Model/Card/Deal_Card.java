package Model.Card;

import Model.Player.Player;
/**
 * This class represents the Deal Card
 * 
 *
 */
public abstract class Deal_Card implements Card{
	protected String name;
	protected String message;
	private int Buy_Money;
	private int Sell_Money;
	/**
	 * <b>Accessor</b>: Returns the Buy Money of the Deal Card <br />
	 * <b>post-condition</b>: Returns the Buy Money of the Deal Card 
	 * @return Buy_Money the Buy Money of the Deal Card
	 */
	public abstract int get_Buy_Money();
	/**
	 * <b>Transformer</b>: Sets the Buy Money of a Deal Card <br />
	 * <b>post-condition</b>; the Buy_Money of the Deal Card is changed to buy_Money
	 * @param buy_Money the new Buy_Money of the Deal Card
	 */
	public abstract void set_Buy_Money(int buy_Money);
	/**
	 * <b>Accessor</b>: Returns the Sell Money of the Deal Card  <br />
	 * <b>post-condition</b>: Returns the Sell Money of the Deal Card 
	 * @return Sell_Money the Buy Money of the Deal Card
	 */
	public abstract int get_Sell_Money();
	/**
	 * <b>Transformer</b>: Sets the Sell Money of a Deal Card <br />
	 * <b>post-condition</b>; the Sell_Money of the Deal Card is changed to sell_Money
	 * @param sell_Money the new Sell_Money of the Deal Card
	 */
	public abstract void set_Sell_Money(int sell_Money);
	/**
	 * <b>Observer</b>:Charges the Player with the amount of Money(Buy_Money) if he wants to Buy the card
	 * and gives it to the Player <br />
	 * <b>post-condition</b>: Removes the Buy_Money from Money of the Player and then moves the card to the
	 * Array DC of the Player
	 * @param P1 for the Player who takes the card
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Deal Card with the given name , Buy_Money , Sell_Money and message <br />
	 * <b>post-condition</b>: Creates and initializes a Deal Card with the given name 
	 * , Buy_Money , Sell_Money and message
	 * @param name the name of the Card
	 * @param Buy_Money the Money that the Player can buy the card
	 * @param Sell_Money the Money that the Player can sell the card
	 * @param message the message that the Deal Card contains
	 */
	public Deal_Card(String name , int Buy_Money , int Sell_Money , String message){}

}
