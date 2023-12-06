package hy252.mmc;

/**
 *
 * @author user
 */
public class SymmetryActionOnNonValidAtonalRow extends Exception {
    //Parameterless Constructor

    /**
     *
     */
    
    public SymmetryActionOnNonValidAtonalRow() {
    }

    //Constructor that accepts a message

    /**
     *
     * @param message
     */
        public SymmetryActionOnNonValidAtonalRow(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public SymmetryActionOnNonValidAtonalRow(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public SymmetryActionOnNonValidAtonalRow(String message, Throwable cause) {
        super(message, cause);
    }
}
