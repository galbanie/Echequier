/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.classes;

import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Pion extends Piece{

    public Pion(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
       
        if(actuel.getLigne() == 2 || actuel.getLigne() == 7){
            if(actuel.distanceDirectionLigne(emplacement) >= 1  && actuel.distanceDirectionLigne(emplacement) <= 2)
            return true;
        }
        else if(actuel.distanceDirectionLigne(emplacement) == 1 ){
            if(actuel.distanceDirectionColonne(emplacement) == 1 || actuel.distanceDirectionColonne(emplacement) == -1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
       StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("type"));
        sb.append(":");
        sb.append("\"Pion\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+this.getCouleur().name()+"\"");
        
        sb.append("}");
        
        return sb.toString(); 
    }
    
    
    
}
