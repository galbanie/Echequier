/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public class Pion extends Piece{

    public Pion(Position position, int codeColor){
        this.setCouleur(codeColor);
        this.position = position;
    }
    
    @Override
    public boolean deplacer(Position position) {
        // algo incorrect j'y travaille
        if(this.position.distanceDirectionColonne(position) == 1 ){
            if(this.position.distanceDirectionLigne(position) == 1 || this.position.distanceDirectionLigne(position) == -1){
                this.position = position;
                return true;
            }
        }
        return false;
    }
    
}
