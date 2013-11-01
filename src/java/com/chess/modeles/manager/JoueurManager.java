/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.modeles.manager;

import com.chess.modeles.entite.Joueur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author galbanie
 */

public class JoueurManager  {
    
    @PersistenceContext(unitName = "EchequierPersistance")
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    public JoueurManager() {
        this.emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }
    
    
    public Joueur createJoueur(Joueur joueur){
        if(joueur == null) return null;
        tx.begin();
        em.persist(joueur);
        tx.commit();
        return joueur;
    }
    
    public Joueur findJoueur(int joueurId){
        tx.begin();
        Joueur joueur = em.find(Joueur.class, joueurId);
        tx.commit();
        return joueur;
    }
    
    public Joueur updateJoueur(Joueur joueur){
        if(joueur == null) return null;
        tx.begin();
        em.merge(joueur);
        tx.commit();
        return joueur;
    }
    
    public void deleteJoueur(Joueur joueur){
        if(joueur != null){
            tx.begin();
            em.remove(em.merge(joueur));
            tx.commit();
        }
    }
    
    public Joueur findJoueurByUsername(String username){
        if(username == null || "".equals(username)) return null;
        Query query;
        Joueur joueur;
        query = em.createQuery("SELECT j FROM Joueur j WHERE j.identifiant = :identifiant");
        query.setParameter("identifiant", username);
        try{
            joueur = (Joueur) query.getSingleResult();
        }catch(NoResultException e){
            joueur = null;
        }
        
        return joueur;
    }
    
    public List<Joueur> findJoueurs(){
        Query query;
        List<Joueur> joueurs;
        
        query = em.createQuery("SELECT j FROM Joueur j");
        joueurs = query.getResultList();
        
        return joueurs;
    }
    
    public void closeEntityManager(){
        em.close();
        emf.close();
    }
    
}
