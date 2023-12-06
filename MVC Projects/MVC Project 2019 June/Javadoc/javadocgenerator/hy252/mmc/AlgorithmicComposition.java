package hy252.mmc;

/**
 *
 * @author user
 */
public class AlgorithmicComposition extends Composition {
	int x;

    /**
     * Constructs an AlgorithmicComposition object 
     * @param compName Compositions name
     * @param composer Composers name
     * @param instrument Compositions instument
     * @param x a number from the user
     */
    public AlgorithmicComposition(String compName, String composer,
			String instrument,int x) {
		super(compName, composer, instrument);
		// TODO Auto-generated constructor stub
	}

	@Override
	String Compose() {
		// TODO Auto-generated method stub
		return null;
	}
	void setX(int x){
		this.x=x;
	}
	int getX(int x){
		return x;
	}
	
}
