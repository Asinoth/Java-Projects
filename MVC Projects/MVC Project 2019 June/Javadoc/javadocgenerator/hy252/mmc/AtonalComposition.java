package hy252.mmc;

/**
 *
 * @author user
 */
public class AtonalComposition extends Composition implements Symmetry {

    /**
     *  Constructs an AtonalComposition object
     * <p><b>Precondition:</b> User must give valid atonalRow
     * <p><b>Postcondition:</b> A atonalComposition object will be created
     * @param compName Compositions name
     * @param composer Composers name
     * @param instrument Instrument
     */
    public AtonalComposition(String compName, String composer, String instrument) {
		super(compName, composer, instrument);
		
	}

	@Override
	String Compose() {

		return null;
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
