/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.modeles.entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
@Entity
public class Deplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 2)
    private String de;
    
    @Column(length = 2)
    private String a;

    public Deplacement() {
    }

    public Deplacement(Position depart, Position arrivee) {
        this.setDe(depart);
        this.setA(arrivee);
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDe() {
        return de;
    }
    
    
    public Position getDePos(){
        return strsToPosition()[0];
    }

    public final void setDe(Position depart) {
        this.de = positionToStr(depart);
    }

    public String getA() {
        return a;
    }
    
    public Position getAPos(){
        return strsToPosition()[1];
    }

    public final void setA(Position arrivee) {
        this.a = positionToStr(arrivee);
    }
    
    public String positionToStr(Position position){
        StringBuilder sb = new StringBuilder();
        sb.append(getCharLigne(position.getLigne()));
        sb.append(position.getColonne());
        return sb.toString();
    }
    
    public Position[] strsToPosition(){
        Position[] positions = new Position[2];
        positions[0] = new Position(getLigneChar(de.charAt(0)),Integer.parseInt(de.substring(1)));
        positions[1] = new Position(getLigneChar(a.charAt(0)),Integer.parseInt(a.substring(1)));
        return positions;
    }
    
    protected char getCharLigne(int i){
        char c = '0';
        switch(i){
            case 1 : c = 'a';
            break;
            case 2 : c = 'b';
            break;
            case 3 : c = 'c';
            break;
            case 4 : c = 'd';
            break;
            case 5 : c = 'e';
            break;
            case 6 : c = 'f';
            break;
            case 7 : c = 'g';
            break;
            case 8 : c = 'h';
            break;
        }
        return c;
    }
    
    protected int getLigneChar(char c){
        int i = 0;
        switch(c){
            case 'a' : i = 1;
            break;
            case 'b' : i = 2;
            break;
            case 'c' : i = 3;
            break;
            case 'd' : i = 4;
            break;
            case 'e' : i = 5;
            break;
            case 'f' : i = 6;
            break;
            case 'g' : i = 7;
            break;
            case 'h' : i = 8;
            break;
        }
        return i;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deplacement)) {
            return false;
        }
        Deplacement other = (Deplacement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return de+"-"+a;
    }
    
}
