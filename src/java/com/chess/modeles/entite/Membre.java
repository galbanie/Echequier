package com.chess.modeles.entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author galbanie
 */
@Entity
//@Table(name = "membre")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlType (propOrder = {"id","identifiant"})
public class Membre implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
     @Column(nullable = false, unique = true)
     private String identifiant;
     @Column(nullable = true)
     private String nom;
     @Column(nullable = true)
     private String prenom;
     @Column(nullable = false, unique = true)
     private String email;
     @Column(nullable = false)
     private String password;
     
     

    public Membre(String identifiant, String nom, String prenom, String email, String password) {
        super();
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Membre(String identifiant, String email, String password) {
        this(identifiant,"","",email,password);
    }
    
    public Membre(){
        this("","","","","");
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    @XmlElement(nillable = true)
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    @XmlElement(nillable = true)
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    @XmlElement(nillable = true)
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    @XmlElement(nillable = true)
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Get the value of identifiant
     *
     * @return the value of identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Set the value of identifiant
     *
     * @param identifiant new value of identifiant
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    

    
}
