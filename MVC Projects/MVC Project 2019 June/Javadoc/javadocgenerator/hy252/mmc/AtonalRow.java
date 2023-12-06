package hy252.mmc;

/**
 *
 * @author user
 */
public class AtonalRow implements Symmetry {
	String Row;

    /**
     * Creates an atonalrow object
     * <p><b>Precondition:</b> User must give valid atonalRow
     * <p><b>Postcondition:</b> An AtonalRow object will be created
     * <p><b>Exception:</b> Invalide atonalrow
     * @param Row
     */
    public AtonalRow(String Row) {
		
	}

    /**
     * Tests if the row is valid atonal
     * @return true or false
     */
    public boolean IsValid(){
		return true;
	}

/**
     * Applies a doNothing Symmery
     * <p><b>Postcondition:</b> A row with doNothing Symmery must return
     * @return the row with given symmerty
     */
    @Override
	public String doNothing() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     *Aplies a Transpose Symmery
     * A row with Transpose Symmery must return
     * @param x integer number for type of symmerty
     * @return the row with given symmerty
     */
    @Override
	public String transpose(int x) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     *  Aplies a Retrograde Symmetry
     * A row with Retrograde Symmery must return
     * @return the row with given symmerty
     */
    @Override
	public String retrograde() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Applies a Reflection Symmerty
     * A row with Reflaction Symmery must return
     * @param x integer number for type of symmery
     * @return the row with given symmerty
     */
    @Override
	public String reflect(int x) {
		// TODO Auto-generated method stub
		return null;
	}

}
