/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public class Reine extends Piece{
    
    private static final Position[] POSITIONS = {new Position(1,4), new Position(8,4)};

    public Reine(int codeColor, int emplacement) {
        this.setCouleur(codeColor);
        if(emplacement >= 0 && emplacement <= 1) this.position = POSITIONS[emplacement];
        else this.position = POSITIONS[POSITION_BAS];
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