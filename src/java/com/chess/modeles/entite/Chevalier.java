/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public class Chevalier extends Piece{
    
    private static final Position[][] POSITIONS = {{new Position(1,2), new Position(8,2)},{new Position(1,7), new Position(8,7)}};

    public Chevalier(int codeColor, int cote,int emplacement) {
        this.setCouleur(codeColor);
        if((cote >= 0 && cote <= 1)&&(emplacement >= 0 && emplacement <= 1)) this.position = POSITIONS[cote][emplacement];
        else this.position = POSITIONS[POSITION_GAUCHE][POSITION_BAS];
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
