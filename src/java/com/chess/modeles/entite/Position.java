package com.chess.modeles.entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
@Entity
public class Position implements JSONAware, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int ligne;
    @Column
    private int colonne;
    
    public Position()
    {
        this(1,1);
    }
    
    public Position(int ligne,int colonne)
    {
        this.setLigne(ligne);
        this.setColonne(colonne);
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        if(ligne >= 1 && ligne <= 8)this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        if(colonne >= 1 && colonne <= 8)this.colonne = colonne;
    }
    
    public static boolean comparer(Position p1,Position p2)
    {
        return ((p1.ligne == p2.ligne)&&(p1.colonne == p2.colonne));
    }
    
    public boolean comparer(Position p)
    {
        return ((this.ligne == p.ligne)&&(this.colonne == p.colonne));
    }
    
    public static double distance(Position p1, Position p2){
        return Math.sqrt(Math.pow((p2.ligne - p1.ligne),2) + Math.pow((p2.colonne - p1.colonne),2));
    }
    
    public double distance(Position p){
        return distance(p, new Position());
    }
    
    public static double distanceDirectionLigne(Position p1, Position p2){
        return (p2.ligne - p1.ligne);
    }
    
    public double distanceDirectionLigne(Position p){
        return distanceDirectionLigne(this, p);
    }
    
    public static double distanceDirectionColonne(Position p1, Position p2){
        return (p2.colonne - p1.colonne);
    }
    
    public double distanceDirectionColonne(Position p){
        return distanceDirectionColonne(this, p);
    }
    
    /*public boolean compareTo(PositionDepart positionStart){
        
        return (ligne == positionStart.getLigne() && colonne == positionStart.getColonne());
    }*/
    
    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj instanceof Position){
                Position otherPosition = (Position)obj;
                if(this.ligne == otherPosition.ligne && this.colonne == otherPosition.colonne) return true;
            } 
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.ligne;
        hash = 23 * hash + this.colonne;
        return hash;
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("ligne"));
        sb.append(":");
        sb.append("\""+ligne+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("colonne"));
        sb.append(":");
        sb.append("\""+colonne+"\"");
        
        sb.append("}");
        
        return sb.toString(); 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
