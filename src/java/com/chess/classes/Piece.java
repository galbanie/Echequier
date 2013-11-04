/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public abstract class Piece {
    
    private ColorPiece couleur;
    private boolean capture = false;

    /**
     * Get the value of capture
     *
     * @return the value of capture
     */
    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }


    /**
     * Get the value of couleur
     *
     * @return the value of couleur
     */
    public ColorPiece getCouleur() {
        return couleur;
    }

    /**
     * Set the value of couleur
     *
     * @param codeColor new value of couleur
     */
    public void setCouleur(ColorPiece codeColor) {
            this.couleur = codeColor;
    }

    public abstract boolean deplacer(Position actuel, Position emplacement);
}
