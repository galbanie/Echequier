/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

import com.chess.modeles.entite.Joueur;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 * 
 */
public class JoueurEchec implements JSONAware{
    private Joueur joueur;
    private boolean focus;
    private ColorPiece color;

    public JoueurEchec(Joueur joueur, boolean focus, ColorPiece color) {
        this.joueur = joueur;
        this.focus = focus;
        this.color = color;
    }

    public JoueurEchec(Joueur joueur, boolean focus) {
        this(joueur, focus, null);
    }
    

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }
    
    public void set(Joueur joueur, boolean focus){
        setJoueur(joueur);
        setFocus(focus);
    }

    public ColorPiece getColor() {
        return color;
    }

    public void setColor(ColorPiece color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("joueur", joueur);
        jsonObject.put("focus", "\""+focus+"\"");
        jsonObject.put("color", color.getStrColor());
        return jsonObject.toJSONString();*/
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("joueur"));
        sb.append(":");
        sb.append(joueur.toJSONString());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("focus"));
        sb.append(":");
        sb.append("\""+focus+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("color"));
        sb.append(":");
        sb.append("\""+color.name()+"\"");
        
        sb.append("}");
        
        return sb.toString();
        
    } 

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj instanceof JoueurEchec){
                JoueurEchec other = (JoueurEchec)obj;
                return joueur.equals(other.joueur);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.joueur != null ? this.joueur.hashCode() : 0);
        hash = 29 * hash + (this.focus ? 1 : 0);
        hash = 29 * hash + (this.color != null ? this.color.hashCode() : 0);
        return hash;
    }
    
    
    
}
