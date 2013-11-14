package com.chess.classes;

import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Chevalier extends Piece{

    public Chevalier(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }

    @Override
    public boolean deplacer(Position actuel, Position emplacement) {
        if( Math.abs(Math.abs(actuel.distanceDirectionLigne(emplacement)) - Math.abs(actuel.distanceDirectionColonne(emplacement))) ==  1){
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
        sb.append("\"Chevalier\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+this.getCouleur().name()+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }
    
    
    
}
