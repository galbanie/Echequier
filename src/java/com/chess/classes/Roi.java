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
    
     private static final Position[] POSITIONS = {new Position(1,5), new Position(8,5)};


    public Roi(int codeColor, int emplacement){
        this.setCouleur(codeColor);
        if(emplacement >= 0 && emplacement <= 1) this.position = POSITIONS[emplacement];
        else this.position = POSITIONS[POSITION_BAS];
        
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
