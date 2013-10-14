package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public final class Position {
    private int ligne;
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
        return (p1.ligne - p2.ligne);
    }
    
    public double distanceDirectionLigne(Position p){
        return distanceDirectionLigne(this, p);
    }
    
    public static double distanceDirectionColonne(Position p1, Position p2){
        return (p1.colonne - p2.colonne);
    }
    
    public double distanceDirectionColonne(Position p){
        return distanceDirectionColonne(this, p);
    }
    
    @Override
    public String toString() {
        return "(" + ligne + "," + colonne + ')';
    }
}
