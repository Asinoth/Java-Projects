package hy252.mmc;

/**
 *
 * @author user
 */
public abstract class Composition {
	private String CompName;
	private String Composer;
	private String Instrument;
	private String notes;
	
	Composition(String compName,String composer,String instrument){
		
	}
	abstract String Compose();

    /**
     *Retruns Compositions name
     * @return CompName
     */
    public String getCompName() {
		return CompName;
	}

    /**
     *Sets Compositions name
     * @param compName Compositions name
     */
    public void setCompName(String compName) {
		CompName = compName;
	}

    /**
     *Retruns Composer
     * @return Composer
     */
    public String getComposer() {
		return Composer;
	}

    /**
     *Sets the Composer
     * @param composer Composers name
     */
    public void setComposer(String composer) {
		Composer = composer;
	}

    /**
     *Returns the Instrument
     * @return Instrument
     */
    public String getInstrument() {
		return Instrument;
	}

    /**
     *Sets the  instrument
     * @param instrument Compositions instrument
     */
    public void setInstrument(String instrument) {
		Instrument = instrument;
	}

    /**
     *Returns the notes
     * @return notes
     */
    public String getNotes() {
		return notes;
	}

    /**
     *Sets the Notes
     * @param notes notes of the composition
     */
    public void setNotes(String notes) {
		this.notes = notes;
	}
	
		
	
	
}
