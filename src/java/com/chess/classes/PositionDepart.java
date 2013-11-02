/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

/**
 *
 * @author galbanie
 */
public enum PositionDepart {

    ROI_BAS(1,5),
    ROI_HAUT(8,5),
    REINE_BAS(1,4),
    REINE_HAUT(8,4),
    FOU_BAS_GAUCHE(1,3),
    FOU_BAS_DROITE(1,6),
    FOU_HAUT_GAUCHE(8,3),
    FOU_HAUT_DROITE(8,6),
    CHEVALIER_BAS_GAUCHE(1,2),
    CHEVALIER_BAS_DROITE(1,7),
    CHEVALIER_HAUT_GAUCHE(8,2),
    CHEVALIER_HAUT_DROITE(8,7),
    TOUR_BAS_GAUCHE(1,1),
    TOUR_BAS_DROITE(1,8),
    TOUR_HAUT_GAUCHE(8,1),
    TOUR_HAUT_DROITE(8,8),
    PION_BAS_PREMIER(2,1),
    PION_HAUT_PREMIER(7,1),
    PION_BAS_DEUXIEME(2,2),
    PION_HAUT_DEUXIEME(7,2),
    PION_BAS_TROISIEME(2,3),
    PION_HAUT_TROISIEME(7,3),
    PION_BAS_QUATRIEME(2,4),
    PION_HAUT_QUATRIEME(7,4),
    PION_BAS_CINQUIEME(2,5),
    PION_HAUT_CINQUIEME(7,5),
    PION_BAS_SIXIEME(2,6),
    PION_HAUT_SIXIEME(7,6),
    PION_BAS_SEPTIEME(2,7),
    PION_HAUT_SEPTIEME(7,7),
    PION_BAS_HUITIEME(2,8),
    PION_HAUT_HUITIEME(7,8);

    PositionDepart(int ligne,int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    private final int ligne;
    private final int colonne;

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
    
}
