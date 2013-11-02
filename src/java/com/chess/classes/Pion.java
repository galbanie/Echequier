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

    public Pion(ColorPiece codeColor, PositionDepart positionStart) throws PositionIllegalException{
        this.setCouleur(codeColor);
        if(positionStart.compareTo(PositionDepart.PION_BAS_PREMIER) == 0      || positionStart.compareTo(PositionDepart.PION_HAUT_PREMIER) == 0 
           || positionStart.compareTo(PositionDepart.PION_BAS_DEUXIEME) == 0  || positionStart.compareTo(PositionDepart.PION_HAUT_DEUXIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_TROISIEME) == 0 || positionStart.compareTo(PositionDepart.PION_HAUT_TROISIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_QUATRIEME) == 0 || positionStart.compareTo(PositionDepart.PION_HAUT_QUATRIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_CINQUIEME) == 0 || positionStart.compareTo(PositionDepart.PION_HAUT_CINQUIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_SIXIEME) == 0   || positionStart.compareTo(PositionDepart.PION_HAUT_SIXIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_SEPTIEME) == 0  || positionStart.compareTo(PositionDepart.PION_HAUT_SEPTIEME) == 0
           || positionStart.compareTo(PositionDepart.PION_BAS_HUITIEME) == 0  || positionStart.compareTo(PositionDepart.PION_HAUT_HUITIEME) == 0) 
            this.position = new Position(positionStart.getLigne(),positionStart.getColonne());
        else throw new PositionIllegalException();
    }
    
    @Override
    public boolean deplacer(Position position) {
        // algo incorrect j'y travaille
        
        if(this.position.compareTo(PositionDepart.PION_BAS_PREMIER)      || this.position.compareTo(PositionDepart.PION_HAUT_PREMIER) 
           || this.position.compareTo(PositionDepart.PION_BAS_DEUXIEME)  || this.position.compareTo(PositionDepart.PION_HAUT_DEUXIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_TROISIEME) || this.position.compareTo(PositionDepart.PION_HAUT_TROISIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_QUATRIEME) || this.position.compareTo(PositionDepart.PION_HAUT_QUATRIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_CINQUIEME) || this.position.compareTo(PositionDepart.PION_HAUT_CINQUIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_SIXIEME)   || this.position.compareTo(PositionDepart.PION_HAUT_SIXIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_SEPTIEME)  || this.position.compareTo(PositionDepart.PION_HAUT_SEPTIEME)
           || this.position.compareTo(PositionDepart.PION_BAS_HUITIEME)  || this.position.compareTo(PositionDepart.PION_HAUT_HUITIEME)){
            if(this.position.distanceDirectionLigne(position) >= 1  && this.position.distanceDirectionLigne(position) <= 2){
                this.position = position;
                return true;
            }
        }
        else if(this.position.distanceDirectionLigne(position) == 1 ){
            if(this.position.distanceDirectionColonne(position) == 1 || this.position.distanceDirectionColonne(position) == -1){
                this.position = position;
                return true;
            }
        }
        return false;
    }
    
}
