package com.chess.classes;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Demande implements JSONAware{
    private final String emetteur;
    private final String receveur;
    
    private EtatDemande etat;

    public Demande(String emetteur, String receveur) {
        this.emetteur = emetteur;
        this.receveur = receveur;
        this.etat = EtatDemande.ATTENTE_REPONSE;
    }
    
    public void repondre(boolean reponse){
        if(reponse){
            this.etat = EtatDemande.ACCEPTER;
        }
        else{
            this.etat = EtatDemande.REFUSER;
        }
    }

    public String getEmetteur() {
        return emetteur;
    }

    public String getReceveur() {
        return receveur;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj != null){
            if(obj instanceof Demande){
                Demande other = (Demande)obj; 
                if((this.emetteur == null ? other.emetteur == null : this.emetteur.equals(other.emetteur)) && (this.receveur == null ? other.receveur == null : this.receveur.equals(other.receveur))){
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.emetteur != null ? this.emetteur.hashCode() : 0);
        hash = 41 * hash + (this.receveur != null ? this.receveur.hashCode() : 0);
        hash = 41 * hash + (this.etat != null ? this.etat.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("emetteur"));
        sb.append(":");
        sb.append("\""+this.emetteur+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("receveur"));
        sb.append(":");
        sb.append("\""+this.receveur+"\"");
        
        sb.append("}");
        
        return sb.toString();
    }
    
}
