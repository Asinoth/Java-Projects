package efc;

import interfaces.MemoryControl;
import hy252.mmc.FreeComposition;

/**
 *
 * @author user
 */
public class FreeMMC extends MMC implements MemoryControl{
	private FreeComposition free;

    /**
     *Creates a freeMMC object
     */
    public FreeMMC(){
        }

    /**
     *Creates a freeMMC object with the given notes
     * @param notes
     */
    public FreeMMC(String notes){
		super(notes);
	}

    /**
     *Creates a freeMMC object with the given notes and instrument
     * @param notes
     * @param instrument
     */
    public FreeMMC(String notes,String instrument){
		super(notes,instrument);
        }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     *Returns the freeComposition
     * @return free Composition
     */
    public FreeComposition getFree() {
		return free;
	}

    /**
     *Sets the freeComposition
     * @param free freeComposition
     */
    public void setFree(FreeComposition free) {
		this.free = free;
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

    @Override
    void Open(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
