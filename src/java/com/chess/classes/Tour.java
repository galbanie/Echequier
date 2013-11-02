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

    public Tour(ColorPiece codeColor, PositionDepart positionStart) throws PositionIllegalException {
        this.setCouleur(codeColor);
        if(positionStart.compareTo(PositionDepart.TOUR_BAS_GAUCHE) == 0 || positionStart.compareTo(PositionDepart.TOUR_BAS_DROITE) == 0 
           || positionStart.compareTo(PositionDepart.TOUR_HAUT_GAUCHE) == 0 || positionStart.compareTo(PositionDepart.TOUR_HAUT_DROITE) == 0) 
            this.position = new Position(positionStart.getLigne(),positionStart.getColonne());
        else throw new PositionIllegalException();
    }
    
    @Override
    public boolean deplacer(Position position) {
        if( this.position.distanceDirectionColonne(position) == 0 && (this.position.distanceDirectionLigne(position) >= -7 && this.position.distanceDirectionLigne(position) <= 7) ||
            this.position.distanceDirectionLigne(position) == 0 && (this.position.distanceDirectionColonne(position) >= -7 && this.position.distanceDirectionColonne(position) <= 7)){
            this.position = position;
            return true;
        }
        return false;
    }
    
}
