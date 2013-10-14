/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

/**
 *
 * @author galbanie
 */
public class Joueur extends Membre{
    
    private final int MAX_JOUEURS = 10;

    
    private Integer[] inviteurs;
    private int nombreInviteurs = 0;
    private boolean partie = false;
    private int points = 0;

    public Joueur(int id, String identifiant, String email, String password) {
        super(id, identifiant, email, password);
        inviteurs = new Integer[MAX_JOUEURS];
    }
    
    /**
     * Get the value of partie
     *
     * @return the value of partie
     */
    public boolean isPartie() {
        return partie;
    }

    /**
     * Set the value of partie
     *
     * @param partie new value of partie
     */
    public void setPartie(boolean partie) {
        this.partie = partie;
    }

    /**
     * Get the value of nombreInviteurs
     *
     * @return the value of nombreInviteurs
     */
    public int getNombreInviteurs() {
        return nombreInviteurs;
    }


    /**
     * Get the value of inviteurs
     *
     * @return the value of inviteurs
     */
    public Integer[] getInviteurs() {
        return inviteurs;
    }

    /**
     * Set the value of inviteurs
     *
     * @param inviteurs new value of inviteurs
     */
    public void setInviteurs(Integer[] inviteurs) {
        this.inviteurs = inviteurs;
        nombreInviteurs = 0;
        for(int i = 0; i < MAX_JOUEURS; i++){
            if(this.inviteurs[i] != null) nombreInviteurs++;
        }
    }

    /**
     * Get the value of inviteur at specified index
     *
     * @param index
     * @return the value of inviteurs at specified index
     */
    public int getInviteur(int index) {
        return (index > 0 && index < this.nombreInviteurs)?this.inviteurs[index]: null;
    }

    /**
     * Set the value of inviteur at specified index.
     *
     * @param index
     * @param newInviteur new value of inviteurs at specified index
     */
    public void setInviteur(int index, int newInviteur) {
        if(index > 0 && index < MAX_JOUEURS)inviteurs[index] = new Integer(newInviteur);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }
      
}