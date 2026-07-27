package hy252.mmc;

/**
 *
 * @author user
 */
public class FreeComposition extends Composition {

    /**
     * Creates a FreeComposition object
     * @param compName Compositions Name
     * @param composer Composer 
     * @param instrument Instrument
     */
    public FreeComposition(String compName,String composer,String instrument) {
		super(compName,composer,instrument);
	}

	@Override
	String Compose() {		
		return null;
	}

}
