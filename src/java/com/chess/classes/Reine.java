/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Reine extends Piece{

    public Reine(ColorPiece codeColor, PositionDepart positionStart) throws PositionIllegalException {
        this.setCouleur(codeColor);
        if(positionStart.compareTo(PositionDepart.REINE_BAS) == 0 || positionStart.compareTo(PositionDepart.REINE_HAUT) == 0 ) 
            this.position = new Position(positionStart.getLigne(),positionStart.getColonne());
        else throw new PositionIllegalException();
    }
    
    
    @Override
    public boolean deplacer(Position position){
        // algo à valider
        if( this.position.distanceDirectionColonne(position) == 0 && (this.position.distanceDirectionLigne(position) >= -7 && this.position.distanceDirectionLigne(position) <= 7)   ||
            this.position.distanceDirectionLigne(position) == 0 && (this.position.distanceDirectionColonne(position) >= -7 && this.position.distanceDirectionColonne(position) <= 7) ||
            Math.abs(this.position.distanceDirectionColonne(position)) - Math.abs(this.position.distanceDirectionLigne(position)) == 0){
            this.position = position;
            return true;
        }
        return false;
    }
    
}