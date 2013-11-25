package com.chess.modeles.entite;

import com.chess.classes.ColorPiece;
import com.chess.classes.Echequier;
import com.chess.classes.EtatPlateau;
import com.chess.classes.JoueurEchec;
import com.chess.classes.Piece;
import com.chess.outils.SyncLogIn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @Transient
    private String syncjeu;
    
    // gagnant
    @Transient
    private Joueur gagnant;
    
    @OneToMany(orphanRemoval = true)
    @JoinColumn
    private List<Position> deplacement;

    public PartieEchec() {
        this(null,null);
    }

    public PartieEchec(Joueur joueurN, Joueur joueurB) {
        this.chess = new Echequier();
        playerB = new JoueurEchec(joueurB, true, ColorPiece.WHITE);
        playerN = new JoueurEchec(joueurN, false, ColorPiece.BLACK);
        //temps = new Timer();
        syncjeu = String.valueOf(SyncLogIn.getInstant());
        gagnant = null;
        deplacement = new ArrayList<Position>();
    }
    
    /*public void jouer(){
        //temps.schedule(new PartieEchecTask(), 0,30 * 1000);
    }*/
    
    public boolean selectionner(Position position){
        Piece piece = chess.selectionner(position);
        if(playerN.isFocus()){
            if(piece != null && piece.getCouleur().equals(playerN.getColor())){
                return true;
            }
        }
        else{
            if(piece != null && piece.getCouleur().equals(playerB.getColor())){
                return true;
            }
        }
        chess.deselectionner();
        return false;
    }
    
    public boolean deplacer(Position position){
        if(playerN.isFocus()){
            playerB.setFocus(true);
            playerN.setFocus(false);
        }
        else{
            playerB.setFocus(false);
            playerN.setFocus(true);
        }
        verifieGagnant();
        syncjeu = String.valueOf(SyncLogIn.getInstant());
        boolean deplacer = chess.deplacer(position);
        if(deplacer) deplacement.add(position);
        return deplacer;
    }
    
    private void verifieGagnant(){
        gagnant = (chess.getEtat().equals(EtatPlateau.ECHEC_BLACK)) ?  playerB.getJoueur() :  playerN.getJoueur();
    }

    public long getId() {
        return id;
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
        
        sb.append(JSONObject.escape("syncjeu"));
        sb.append(":");
        sb.append("\""+syncjeu+"\"");
        
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
                return this.id == other.id;
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
