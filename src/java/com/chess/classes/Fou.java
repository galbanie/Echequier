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
public class Fou extends Piece{

    public Fou(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if( Math.abs(actuel.distanceDirectionColonne(emplacement)) - Math.abs(actuel.distanceDirectionLigne(emplacement)) == 0 ){
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
        sb.append("\"Fou\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+this.getCouleur().name()+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }
    
}
