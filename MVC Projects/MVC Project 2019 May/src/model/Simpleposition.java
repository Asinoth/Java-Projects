package model;

public class Simpleposition extends Position {

	private int position;
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	//constractor for simple position gives super the type and the number of position
	public Simpleposition(Kingdom type, int position) {
		super(type, position);
		
	}

}
