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

    public JoueurManager() {
        this.emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        this.em = emf.createEntityManager();
    }
    
    
    public Joueur createJoueur(Joueur joueur){
        if(joueur == null) return null;
        em.persist(joueur);
        em.getTransaction().commit();
        return joueur;
    }
    
    public Joueur findJoueur(int joueurId){
        em.getTransaction().begin();
        Joueur joueur = em.find(Joueur.class, joueurId);
        em.getTransaction().commit();
        return joueur;
    }
    
    public Joueur updateJoueur(Joueur joueur){
        if(joueur == null) return null;
        em.getTransaction().begin();
        em.merge(joueur);
        em.getTransaction().commit();
        return joueur;
    }
    
    public void deleteJoueur(Joueur joueur){
        if(joueur != null){
            em.getTransaction().begin();
            em.remove(em.merge(joueur));
            em.getTransaction().commit();
        }
    }
    
    public Joueur findJoueurByUsername(String username){
        if(username == null || "".equals(username)) return null;
        Query query;
        Joueur joueur;
        //em.getTransaction().begin();
        query = em.createQuery("SELECT j FROM Joueur j WHERE j.identifiant = :identifiant");
        query.setParameter("identifiant", username);
        joueur = (Joueur) query.getSingleResult();
        //em.getTransaction().commit();
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
