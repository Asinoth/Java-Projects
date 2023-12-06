package Model.Card;
/**
 * This Class Contains the Arrays for all the Deal Cards
 * 
 *
 */
public abstract class Deal {
	protected Card [] Deal_Cards;
	protected int top_D;
	protected Card [] Pile_Deal_Cards;
	protected int top_PD;
	/**
	 * <b>Observer</b>: Returns if the Array Deal_Cards is empty <br />
	 * <b>post-condition</b>: Returns if the Array Deal_Cards is empty
	 * @return true if the Array Deal_Cards is empty false otherwise
	 */
	public abstract boolean is_empty();
	/**
	 * <b>Constructor</b>: Constructs a new Deal object with the Arrays Deal_Cards and Pile_Deal_Cards <br />
	 * <b>post-condition</b>: Creates and initializes a Deal object with the Arrays Deal_Cards
	 * and Pile_Deal_Cards
	 */
	public Deal(){}

}
