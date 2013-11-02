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


    public Roi(ColorPiece codeColor, PositionDepart positionStart) throws PositionIllegalException{
        this.setCouleur(codeColor);
        if(positionStart.compareTo(PositionDepart.ROI_BAS) == 0 || positionStart.compareTo(PositionDepart.ROI_HAUT) == 0 ) 
            this.position = new Position(positionStart.getLigne(),positionStart.getColonne());
        else throw new PositionIllegalException();
        
    }
    

    @Override
    public boolean deplacer(Position position) {
        // algo à valider
        if(this.position.distanceDirectionColonne(position) <= 1 && this.position.distanceDirectionColonne(position) >= -1){
            if(this.position.distanceDirectionLigne(position) <= 1 && this.position.distanceDirectionLigne(position) >= -1){
                this.position = position;
                return true;
            }
        }
        return false;
    }
    
}
