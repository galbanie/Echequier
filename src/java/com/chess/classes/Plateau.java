/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

import com.chess.modeles.entite.Position;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Plateau extends HashMap<Position, Piece> implements JSONAware{

    public Plateau() {
        super();
    }

    public Plateau(int initialCapacity){
        super(initialCapacity);
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        
        for (Iterator<Map.Entry<Position, Piece>> it = this.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Position, Piece> entry = it.next();
            sb.append("{");
            
            sb.append(JSONObject.escape("position"));
            sb.append(":");
            sb.append(entry.getKey().toJSONString());
            
            sb.append(",");
            
            sb.append(JSONObject.escape("piece"));
            sb.append(":");
            sb.append((entry.getValue() != null)?entry.getValue().toJSONString():"\"\"");
            
            sb.append("}");
            if(it.hasNext()) sb.append(",");
        }
        
        sb.append("]");
        
        return sb.toString();
    }
    
}
