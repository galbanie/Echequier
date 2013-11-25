package com.chess.classes;

import com.chess.modeles.entite.Position;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Reine extends Piece{

    public Reine(ColorPiece codeColor){
        this.setCouleur(codeColor);
    }
    
    @Override
    public boolean deplacer(Position actuel, Position emplacement){
        if( actuel.distanceDirectionColonne(emplacement) == 0 && (actuel.distanceDirectionLigne(emplacement) >= -7 && actuel.distanceDirectionLigne(emplacement) <= 7)   ||
            actuel.distanceDirectionLigne(emplacement) == 0 && (actuel.distanceDirectionColonne(emplacement) >= -7 && actuel.distanceDirectionColonne(emplacement) <= 7) ||
            Math.abs(actuel.distanceDirectionColonne(emplacement)) - Math.abs(actuel.distanceDirectionLigne(emplacement)) == 0){
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
        sb.append("\"Reine\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+this.getCouleur().name()+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }
    
    
}