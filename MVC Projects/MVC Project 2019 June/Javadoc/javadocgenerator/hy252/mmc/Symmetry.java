package hy252.mmc;

/**
 *
 * @author user
 */
public interface Symmetry {

    /**
     *
     * @return
     */
    public String doNothing();

    /**
     *
     * @param x
     * @return
     */
    public String transpose(int x);

    /**
     *
     * @return
     */
    public String retrograde();

    /**
     *
     * @param x
     * @return
     */
    public String reflect(int x);
    
}


