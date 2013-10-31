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

    ROI_BAS(new Position(1,5)),
    ROI_HAUT(new Position(8,5)),
    REINE_BAS(new Position(1,4)),
    REINE_HAUT(new Position(8,4)),
    FOU_BAS_GAUCHE(new Position(1,3)),
    FOU_BAS_DROITE(new Position(1,6)),
    FOU_HAUT_GAUCHE(new Position(8,3)),
    FOU_HAUT_DROITE(new Position(8,6)),
    CHEVALIER_BAS_GAUCHE(new Position(1,2)),
    CHEVALIER_BAS_DROITE(new Position(1,7)),
    CHEVALIER_HAUT_GAUCHE(new Position(8,2)),
    CHEVALIER_HAUT_DROITE(new Position(8,7)),
    TOUR_BAS_GAUCHE(new Position(1,1)),
    TOUR_BAS_DROITE(new Position(1,8)),
    TOUR_HAUT_GAUCHE(new Position(8,1)),
    TOUR_HAUT_DROITE(new Position(8,8)),
    PION_BAS_PREMIER(new Position(2,1)),
    PION_HAUT_PREMIER(new Position(7,1)),
    PION_BAS_DEUXIEME(new Position(2,2)),
    PION_HAUT_DEUXIEME(new Position(7,2)),
    PION_BAS_TROISIEME(new Position(2,3)),
    PION_HAUT_TROISIEME(new Position(7,3)),
    PION_BAS_QUATRIEME(new Position(2,4)),
    PION_HAUT_QUATRIEME(new Position(7,4)),
    PION_BAS_CINQUIEME(new Position(2,5)),
    PION_HAUT_CINQUIEME(new Position(7,5)),
    PION_BAS_SIXIEME(new Position(2,6)),
    PION_HAUT_SIXIEME(new Position(7,6)),
    PION_BAS_SEPTIEME(new Position(2,7)),
    PION_HAUT_SEPTIEME(new Position(7,7)),
    PION_BAS_HUITIEME(new Position(2,8)),
    PION_HAUT_HUITIEME(new Position(7,8)),;

    PositionDepart(Position position) {
        this.position = position;
    }
    
    private Position position;

    public Position getPosition() {
        return this.position;
    }
    
    
    
    
}
