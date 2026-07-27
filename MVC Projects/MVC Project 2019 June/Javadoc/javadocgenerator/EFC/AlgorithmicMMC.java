package efc;

import interfaces.MemoryControl;
import hy252.mmc.AlgorithmicComposition;

/**
 *
 * @author user
 */
public class AlgorithmicMMC extends MMC implements MemoryControl{
	private int num;
	private AlgorithmicComposition algor;

    /**
     * Creates an AlgorithmicMMC
     * @param x num from user
     */
    public AlgorithmicMMC(int x){}

        
        
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
     *Returns the algorithmic composition
     * @return algo
     */
    public AlgorithmicComposition getAlgor() {
		return algor;
	}

    /**
     *Sets the algorithmicComposition
     * @param algor
     */
    public void setAlgor(AlgorithmicComposition algor) {
		this.algor = algor;
	}

    /**
     *Returns the num
     * @return num
     */
    public int getNum() {
		return num;
	}

    /**
     *Sets the num
     * @param num
     */
    public void setNum(int num) {
		this.num = num;
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
