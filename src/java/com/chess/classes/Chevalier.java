/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

/**
 *
 * @author galbanie
 */
public class Chevalier extends Piece{

    public Chevalier(ColorPiece codeColor, PositionDepart positionStart) throws PositionIllegalException {
        this.setCouleur(codeColor);
        if(positionStart.compareTo(PositionDepart.CHEVALIER_BAS_GAUCHE) == 0 || positionStart.compareTo(PositionDepart.CHEVALIER_BAS_DROITE) == 0 
           || positionStart.compareTo(PositionDepart.CHEVALIER_HAUT_GAUCHE) == 0 || positionStart.compareTo(PositionDepart.CHEVALIER_HAUT_DROITE) == 0) 
            this.position = new Position(positionStart.getLigne(),positionStart.getColonne());
        else throw new PositionIllegalException();
    }

    @Override
    public boolean deplacer(Position position) {
        if( Math.abs(Math.abs(this.position.distanceDirectionLigne(position)) - Math.abs(this.position.distanceDirectionColonne(position))) ==  1){
            this.position = position;
            return true;
        }
        return false;
    }
    
}
