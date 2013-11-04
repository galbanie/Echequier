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
public class Tour extends Piece{

    public Tour(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if(actuel.distanceDirectionColonne(emplacement) == 0 && (actuel.distanceDirectionLigne(emplacement) >= -7 && actuel.distanceDirectionLigne(emplacement) <= 7) ||
            actuel.distanceDirectionLigne(emplacement) == 0 && (actuel.distanceDirectionColonne(emplacement) >= -7 && actuel.distanceDirectionColonne(emplacement) <= 7)){
            return true;
        }
        return false;
    }
    
}
