/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Position;

import project.model.Finding.Finding;

public class FindingPosition extends Position {

    private Finding finding;

    public FindingPosition(int points, Path path, int positionInPath) {
        super(points, path, positionInPath);
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> returns the finding in the current position if there is none return null
     *
     * @return the finding in position
     */
    public Finding getFinding() {
        return this.finding;
    }

    /**<b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Puts the finding in this position
     *
     * @param finding The finding to be placed
     */
    public void setFinding(Finding finding) {
        this.finding = finding;
    }

    /**<b>Accessor</b><p>
     * <b>Postcondition</b>Informs about the available moves of the pawn in this position
     *                  according tothe finding type
     * 
     */
    @Override
    public void availableMoves() {
    }
}
