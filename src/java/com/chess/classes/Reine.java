package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Reine extends Piece{

    public Reine(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement){
        if( actuel.distanceDirectionColonne(emplacement) == 0 && (actuel.distanceDirectionLigne(emplacement) >= -7 && actuel.distanceDirectionLigne(emplacement) <= 7)   ||
            actuel.distanceDirectionLigne(emplacement) == 0 && (actuel.distanceDirectionColonne(emplacement) >= -7 && actuel.distanceDirectionColonne(emplacement) <= 7) ||
            Math.abs(actuel.distanceDirectionColonne(emplacement)) - Math.abs(actuel.distanceDirectionLigne(emplacement)) == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Reine "+this.getCouleur().getStrColor();
    }
    
    
}