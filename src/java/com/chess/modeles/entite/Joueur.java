/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.modeles.entite;

//import java.util.LinkedHashSet;
//import com.chess.classes.JoueurEchec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;*/
import javax.persistence.Table;
import javax.persistence.Transient;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
@NamedQueries({
        @NamedQuery(name = "Joueur.findAll",query = "SELECT j FROM Joueur j"),
        @NamedQuery(name = "Joueur.findByIdentifiant",query = "SELECT j FROM Joueur j WHERE j.identifiant = :identifiant")
})
@Entity
@Table(name="JOUEUR")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Joueur extends Membre implements JSONAware{

    //@ManyToMany(mappedBy = "JOUEUR")
    //@JoinTable(name = "DEMANDES", joinColumns = @JoinColumn(name = "EMETTEUR"), inverseJoinColumns = @JoinColumn(name = "RECEVEUR"))
    /*@Transient
    private LinkedHashSet<Joueur> demandes;*/
    @Transient
    private boolean partie = false;
    @Transient
    private boolean visible = false;
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
        //demandes = new LinkedHashSet<Joueur>();
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /*public LinkedHashSet<Joueur> getDemandes() {
        return demandes;
    }

    public void setDemandes(LinkedHashSet<Joueur> demandes) {
        this.demandes = demandes;
    }
    
    public void demander(Joueur joueur){
        this.demandes.add(joueur);
        joueur.getDemandes().add(this);
    }
    
    public void supprimerDemande(Joueur joueur){
        this.demandes.remove(joueur);
        joueur.getDemandes().remove(this);
    }*/

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        
        Joueur galbanie = new Joueur("sofiane", "soso@moi.toi","1234567");
        em.persist(galbanie);
        
        PartieEchec pe = new PartieEchec(galbanie, galbanie);
        em.persist(pe);
        
        
        
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
        sb.append("\""+getId()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("identifiant"));
        sb.append(":");
        sb.append("\""+getIdentifiant()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("points"));
        sb.append(":");
        sb.append("\""+getPoints()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("visible"));
        sb.append(":");
        sb.append("\""+isVisible()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("isPartie"));
        sb.append(":");
        sb.append("\""+isPartie()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("nombrePartieJouees"));
        sb.append(":");
        sb.append("\""+getNombrePartieJouees()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("victoire"));
        sb.append(":");
        sb.append("\""+getVictoire()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("nulle"));
        sb.append(":");
        sb.append("\""+getPartieNull()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("defaite"));
        sb.append(":");
        sb.append("\""+getDefaite()+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }
      
}