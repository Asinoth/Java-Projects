package model;

public class FindingPosition extends Position{
private int position;
private boolean istaken;
Findings taken=new Findings();


	/**
 * post condition @return the position
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
//check and return if the finding is taken 
//post condition return taken
public Findings Taken(){
	taken.Checktaken();
	return taken;
}
//constractor with type of the finding positin and if it is taken
	public FindingPosition(Kingdom type, int position, boolean taken) {
		super(type, position, taken);
		
	}

}
