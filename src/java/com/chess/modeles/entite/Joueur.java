/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;*/
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
@Entity
@Table(name="JOUEUR")
@Inheritance(strategy = InheritanceType.JOINED)
public class Joueur extends Membre implements JSONAware{

    @Transient
    private Map<Integer,Joueur> inviteurs;
    @Transient
    private boolean partie = false;
    @Column
    private int points;
    @Column
    private int nombrePartieJouees;
    @Column
    private int victoire;
    @Column
    private int defaite;
    @Column
    private int partieNull;

    public Joueur() {
    }

    public Joueur(String identifiant, String email, String password) {
        super(identifiant, email, password);
        inviteurs = new HashMap<Integer,Joueur>();
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
        return inviteurs.size();
    }


    /**
     * Get the value of inviteurs
     *
     * @return the value of inviteurs
     */
    public Map<Integer,Joueur> getInviteurs() {
        return inviteurs;
    }
    
    public Joueur getInviteur(int key) {
        return inviteurs.get(new Integer(key));
    }

    /**
     * Set the value of inviteurs
     *
     * @param inviteurs new value of inviteurs
     */
    public void setInviteurs(Map<Integer,Joueur> inviteurs) {
        if(inviteurs != null) this.inviteurs = inviteurs;
    }

    public void setInviteur(Joueur inviteur) {
        if(!inviteurs.containsValue(inviteur)) inviteurs.put(new Integer(inviteur.getId()), inviteur);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getNombrePartieJouees() {
        return nombrePartieJouees;
    }

    public void setNombrePartieJouees(int nombrePartieJouees) {
        this.nombrePartieJouees = nombrePartieJouees;
    }

    public int getVictoire() {
        return victoire;
    }

    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    public int getDefaite() {
        return defaite;
    }

    public void setDefaite(int defaite) {
        this.defaite = defaite;
    }

    public int getPartieNull() {
        return partieNull;
    }

    public void setPartieNull(int partieNull) {
        this.partieNull = partieNull;
    }
    
    
    
    /*public static void main(String[] argv){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        
        Joueur galbanie = new Joueur("yanis", "rootKiller@moi.toi","1234567");
        em.persist(galbanie);
        
        
        
        //Joueur nouveau = (Joueur)em.createQuery("SELECT j FROM Joueur j WHERE j.identifiant = 'galbanie'").getSingleResult();
        
        //System.out.println(nouveau.getIdentifiant());
        
        transac.commit();
        em.close();
        emf.close();
    }*/
    
    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("id"));
        sb.append(":");
        sb.append(getId());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("identifiant"));
        sb.append(":");
        sb.append("\""+getIdentifiant()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("points"));
        sb.append(":");
        sb.append(getPoints());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("isPartie"));
        sb.append(":");
        sb.append(isPartie());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("nombrePartieJouees"));
        sb.append(":");
        sb.append(getNombrePartieJouees());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("victoire"));
        sb.append(":");
        sb.append(getVictoire());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("null"));
        sb.append(":");
        sb.append(getPartieNull());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("defaite"));
        sb.append(":");
        sb.append(getDefaite());
        
        sb.append("}");
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }
      
}