package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Chevalier extends Piece{

    public Chevalier(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }

    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if( Math.abs(Math.abs(actuel.distanceDirectionLigne(emplacement)) - Math.abs(actuel.distanceDirectionColonne(emplacement))) ==  1){
            return true;
        }
        return false;
    }
    
}
