/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Pion extends Piece{

    public Pion(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
       
        if(actuel.getLigne() == 2 || actuel.getLigne() == 7){
            if(actuel.distanceDirectionLigne(emplacement) >= 1  && actuel.distanceDirectionLigne(emplacement) <= 2)
            return true;
        }
        else if(actuel.distanceDirectionLigne(emplacement) == 1 ){
            if(actuel.distanceDirectionColonne(emplacement) == 1 || actuel.distanceDirectionColonne(emplacement) == -1){
                return true;
            }
        }
        return false;
    }
    
}
