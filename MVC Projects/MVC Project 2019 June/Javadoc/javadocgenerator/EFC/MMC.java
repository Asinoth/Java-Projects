package efc;

/**
 *
 * @author user
 */
public abstract class MMC{
	private String notes;
	private String instruments;
	
	MMC(){}
	
	MMC(String notes){
		this.notes=notes;
	}
	MMC(String notes,String instrument){
		this.notes=notes;
		this.instruments=instrument;
	}
	public @Override
	abstract String toString();
	abstract void InsertNotes(String note);
        abstract void Open(String filePath);

    /**
     *Returns the notes of the composition
     * @return notes
     */
    public String getNotes() {
		return notes;
	}

    /**
     *Sets the notes of the composition
     * @param notes notes
     */
    public void setNotes(String notes) {
		this.notes = notes;
	}

    /**
     *Returns the instrument of the composition
     * @return instrument
     */
    public String getInstruments() {
		return instruments;
	}

    /**
     *Sets the instrument of the composition
     * @param instruments instrument
     */
    public void setInstruments(String instruments) {
		this.instruments = instruments;
	}

    /**
     *Playes the composition
     */
    public void Play(){
            
        }

    /**
     *Stops the playing of the composition
     */
    public void Stop(){
            
        }
}
