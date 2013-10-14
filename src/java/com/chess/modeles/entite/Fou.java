/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public class Fou extends Piece{

    private static final Position[][] POSITIONS = {{new Position(1,3), new Position(8,3)},{new Position(1,6), new Position(8,6)}};

    public Fou(int codeColor, int cote,int emplacement) {
        this.setCouleur(codeColor);
        if((cote >= 0 && cote <= 1)&&(emplacement >= 0 && emplacement <= 1)) this.position = POSITIONS[cote][emplacement];
        else this.position = POSITIONS[POSITION_GAUCHE][POSITION_BAS];
    }
    
    
    @Override
    public boolean deplacer(Position position) {
        if( Math.abs(this.position.distanceDirectionColonne(position)) - Math.abs(this.position.distanceDirectionLigne(position)) == 0 ){
            this.position = position;
            return true;
        }
        return false;
    }
    
}
