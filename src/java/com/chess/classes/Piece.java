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
    protected Position position;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean deplacer(Position position);
}
