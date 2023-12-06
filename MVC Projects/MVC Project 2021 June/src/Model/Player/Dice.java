package Model.Player;
/**
 * This class represents a dice
 * 
 *
 */
public abstract class Dice {
	/**
	 * <b>Observer</b>: Rolls a dice and displays it <br />
	 * <b>post-condition</b>: Takes a random number from 1 to 6 and puts it to the dice of the player P1
	 * @param P1 the player that plays this turn
	 */
	public abstract void dice(Player P1);

}
