/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

/**
 *
 * @author galbanie
 */
public enum ColorPiece {
    BLACK(0,"BLACK"),
    WHITE(1,"WHITE");

    ColorPiece(int codeColor, String strColor) {
        this.codeColor = codeColor;
        this.strColor = strColor;
    }
    
    private final int codeColor;
    private final String strColor;

    public int getCodeColor() {
        return codeColor;
    }

    public String getStrColor() {
        return strColor;
    }  
    
}
