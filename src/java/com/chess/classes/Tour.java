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

    private static final Position[][] POSITIONS = {{new Position(1,1), new Position(8,1)},{new Position(1,8), new Position(8,8)}};

    public Tour(int codeColor, int cote,int emplacement) {
        this.setCouleur(codeColor);
        if((cote >= 0 && cote <= 1)&&(emplacement >= 0 && emplacement <= 1)) this.position = POSITIONS[cote][emplacement];
        else this.position = POSITIONS[POSITION_GAUCHE][POSITION_BAS];
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
