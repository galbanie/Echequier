/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Roi extends Piece{


    public Roi(ColorPiece codeColor){
        this.setCouleur(codeColor);
        
    }
    

    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        // algo à valider
        if(actuel.distanceDirectionColonne(emplacement) <= 1 && actuel.distanceDirectionColonne(emplacement) >= -1){
            if(actuel.distanceDirectionLigne(emplacement) <= 1 && actuel.distanceDirectionLigne(emplacement) >= -1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Roi "+this.getCouleur().getStrColor();
    }
    
}
