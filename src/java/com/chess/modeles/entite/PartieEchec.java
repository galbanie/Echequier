package com.chess.modeles.entite;

import com.chess.classes.ColorPiece;
import com.chess.classes.Echequier;
import com.chess.classes.EtatPlateau;
import com.chess.classes.JoueurEchec;
import com.chess.classes.Position;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
/*import java.util.Timer;
import java.util.TimerTask;*/

/**
 *
 * @author galbanie
 **/
@Entity
@Table(name = "PARTIE")
public class PartieEchec implements JSONAware, Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // Un echequier
    @Transient
    private Echequier chess;
    // Joueur avec les Pieces Blacks
    @Transient
    private JoueurEchec playerN;
    // Joueur avec les Pieces Whites
    @Transient
    private JoueurEchec playerB;
    // Temps 
    //private Timer temps;
    
    // gagnant
    @Transient
    private Joueur gagnant;

    public PartieEchec() {
        this(null,null);
    }

    public PartieEchec(Joueur joueurN, Joueur joueurB) {
        this.chess = new Echequier();
        playerB = new JoueurEchec(joueurB, true, ColorPiece.WHITE);
        playerN = new JoueurEchec(joueurN, false, ColorPiece.BLACK);
        //temps = new Timer();
        gagnant = null;
    }
    
    /*public void jouer(){
        //temps.schedule(new PartieEchecTask(), 0,30 * 1000);
    }*/
    
    public boolean selectionnerNoir(Position position){
        if(playerN.isFocus()){
            if(chess.selectionner(position) != null && chess.selectionner(position).getCouleur().equals(playerN.getColor())){
                return true;
            }
        }
        return false;
    }
    
    public boolean selectionnerBlanc(Position position){
        if(playerB.isFocus()){
            if(chess.selectionner(position) != null && chess.selectionner(position).getCouleur().equals(playerB.getColor())){
                return true;
            }
        }
        return false;
    }
    
    public boolean deplacerNoir(Position position){
        if(playerN.isFocus()){
            playerB.setFocus(true);
            playerN.setFocus(false);
            verifieGagnant();
            return chess.deplacer(position);
        }
        return false;
    }
    
    public boolean deplacerBlanc(Position position){
        if(playerB.isFocus()){
            playerB.setFocus(false);
            playerN.setFocus(true);
            verifieGagnant();
            return chess.deplacer(position);
        }
        return false;
    }
    
    private void verifieGagnant(){
        gagnant = (chess.getEtat().equals(EtatPlateau.ECHEC_BLACK)) ?  playerB.getJoueur() :  playerN.getJoueur();
    }

    /*class PartieEchecTask extends TimerTask{
    @Override
    public void run() {
    if(playerN.getFocus()){
    playerN.setFocus(false);
    playerB.setFocus(true);
    }
    else if(playerB.getFocus()){
    playerB.setFocus(false);
    playerN.setFocus(true);
    }
    }
    }*/
    public JoueurEchec getPlayerB() {
        return playerB;
    }

    public JoueurEchec getPlayerN() {
        return playerN;
    }
    
    public Joueur getGagnant() {
        return gagnant;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append(JSONObject.escape("id"));
        sb.append(":");
        sb.append("\""+id+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("joueurNoir"));
        sb.append(":");
        sb.append(playerN.toJSONString());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("joueurBlanc"));
        sb.append(":");
        sb.append(playerB.toJSONString());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("chess"));
        sb.append(":");
        sb.append(chess.toJSONString());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("gagnant"));
        sb.append(":");
        sb.append((gagnant != null)?gagnant.toJSONString():"\"\"");
        
        sb.append("}");
        
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj instanceof PartieEchec){
                PartieEchec other = (PartieEchec)obj;
                return this.playerB.equals(other.playerB) && this.playerN.equals(other.playerN);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.chess != null ? this.chess.hashCode() : 0);
        hash = 43 * hash + (this.playerN != null ? this.playerN.hashCode() : 0);
        hash = 43 * hash + (this.playerB != null ? this.playerB.hashCode() : 0);
        hash = 43 * hash + (this.gagnant != null ? this.gagnant.hashCode() : 0);
        return hash;
    }
    
    
}
