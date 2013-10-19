/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author galbanie
 */
@Entity
@Table(name="JOUEUR")
@Inheritance(strategy = InheritanceType.JOINED)
public class Joueur extends Membre{
    @Transient
    private final int MAX_JOUEURS = 10;

    @Transient
    private Integer[] inviteurs;
    @Transient
    private int nombreInviteurs = 0;
    @Transient
    private boolean partie = false;
    @Column
    private int points;

    public Joueur() {
    }

    public Joueur(String identifiant, String email, String password) {
        super(identifiant, email, password);
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
    
    public static void main(String[] argv){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        
        Joueur galbanie = new Joueur("galbanie", "galbanie@moi.toi","1234567");
        em.persist(galbanie);
        
        transac.commit();
        em.close();
        emf.close();
    }
      
}