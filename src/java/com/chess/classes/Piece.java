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
    
    public final String[] COLORS = {"BLACK","WHITE"};
    public final int CODE_COLOR_BLACK = 0;
    public final int CODE_COLOR_WHITE = 1;
    public static final int POSITION_HAUT = 1;
    public static final int POSITION_BAS = 0;
    public static final int POSITION_DROITE = 1;
    public static final int POSITION_GAUCHE = 0;
    
    private String couleur;
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
    public String getCouleur() {
        return couleur;
    }

    /**
     * Set the value of couleur
     *
     * @param couleur new value of couleur
     */
    public void setCouleur(int codeColor) {
        if(codeColor == CODE_COLOR_BLACK || codeColor == CODE_COLOR_WHITE){
            this.couleur = COLORS[codeColor];
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean deplacer(Position position);
}
