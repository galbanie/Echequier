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
public enum EtatPlateau {
    AUCUN("Aucunes pièces n'est présente sur le plateau."),
    PRET("Les pièces sont positionnées sur le plateau à leur position de départ."),
    EN_COURS("Une ou plusières pièces ne sont plus à leur position initiale."),
    ECHEC_BLACK("Le Roi Noir est en échec et mat."),
    ECHEC_WHITE("Le Roi Blanc est en échec et mat.");

    EtatPlateau(String descritption) {
        this.descritpion = descritption;
    }
    
    private final String descritpion;

    public String getDescritpion() {
        return descritpion;
    }
    
}
