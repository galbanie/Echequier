/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Tour extends Piece{

    public Tour(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if(actuel.distanceDirectionColonne(emplacement) == 0 && (actuel.distanceDirectionLigne(emplacement) >= -7 && actuel.distanceDirectionLigne(emplacement) <= 7) ||
            actuel.distanceDirectionLigne(emplacement) == 0 && (actuel.distanceDirectionColonne(emplacement) >= -7 && actuel.distanceDirectionColonne(emplacement) <= 7)){
            return true;
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
        sb.append("\"Tour\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+this.getCouleur().name()+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }
    
    
}
