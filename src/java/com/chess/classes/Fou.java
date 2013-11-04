/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Fou extends Piece{

    public Fou(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if( Math.abs(actuel.distanceDirectionColonne(emplacement)) - Math.abs(actuel.distanceDirectionLigne(emplacement)) == 0 ){
            return true;
        }
        return false;
    }
    
}
