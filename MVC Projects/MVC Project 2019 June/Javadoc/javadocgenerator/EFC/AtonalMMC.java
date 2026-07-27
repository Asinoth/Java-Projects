package efc;

import hy252.mmc.AtonalComposition;
import interfaces.MemoryControl;

/**
 *
 * @author user
 */
public class AtonalMMC extends MMC implements MemoryControl{
	private AtonalComposition Atonal;

    /**
     *Creates an Atonal MMC
     */
    public AtonalMMC(){
        }

    /**
     * Creates an Atonal MMC with the given notes
     * @param notes notes
     */
    public AtonalMMC(String notes){
		super(notes);
	}

    /**
     *Creates an Atonal MMC with the given notes and a default instrument
     * @param notes notes 
     * @param instrument instrument
     */
    public AtonalMMC(String notes,String instrument){
		super(notes,instrument);
        }

        
        
        
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

        
	
        /**
         * Insert a note in the composition
         * <p><b>Precondition:</b> User must insert valid note
         * <p><b>Postcondition:</b> the not will be added in the end of the composition
         * @param note note
         */
        
	@Override
	void InsertNotes(String note) {
		// TODO Auto-generated method stub
		
	}
        /**
         * Generates atoal strings 
         * @param mode Symmertry mode
         */
	void AtonalMode(String mode){
		
	}
  /**
     *Saves compositions at the given directory 
     * <p><b>Precondition:</b> User must give valid file path
     * <p><b>Postcondition:</b> A composition will be opened
     * @param filePath directoty
     */
    @Override
	public void save(String filePath) {
		// TODO Auto-generated method stub
		
	}

    /**
     *  Saves a new composition at the given directory
     * <p><b>Precondition:</b> User must give valid file path
     * <p><b>Postcondition:</b> A composition will be Saved
     * @param filePath file path
     */
    @Override
	public void saveAs(String filePath) {
		// TODO Auto-generated method stub
		
	}

    /**
     *Opens a composition from the given filepath
     * <p><b>Precondition:</b> User must give valid file path
     * <p><b>Postcondition:</b> A composition will be opened
     * @param filePath file path
     */
    @Override
	public void open(String filePath) {
		// TODO Auto-generated method stub
		
	}

    /**
     *Creates a midi composition at the given directory     
     * <p><b>Precondition:</b> User must give valid file path
     * <p><b>Postcondition:</b> A midi file will be created
     * @param filePath directory
     */
    @Override
	public void export(String filePath) {
		// TODO Auto-generated method stub
		
	}

    /**
     *Returns the atonal Compositio
     * @return Atonal
     */
    public AtonalComposition getAtonal() {
		return Atonal;
	}

    /**
     *Sets the atonalComposition
     * @param atonal atonal Composition
     */
    public void setAtonal(AtonalComposition atonal) {
		Atonal = atonal;
	}

    @Override
    void Open(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

   

