package com.chess.listerner;

import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import com.chess.modeles.entite.PartieEchec;
import com.chess.outils.SyncLogIn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author galbanie
 */
public class SessionListerner implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Joueur joueur = (Joueur)se.getSession().getAttribute("joueur");
        LinkedHashSet<Joueur> connectes = (LinkedHashSet<Joueur>)se.getSession().getServletContext().getAttribute("connectes");
        LinkedHashSet<Demande> demandes = ( LinkedHashSet<Demande>)se.getSession().getServletContext().getAttribute("demandes");
        LinkedHashSet<PartieEchec> parties = (LinkedHashSet<PartieEchec>)se.getSession().getServletContext().getAttribute("parties");
        HashMap<String,PartieEchec> partiesSuivies = (HashMap<String,PartieEchec>)se.getSession().getServletContext().getAttribute("partiesSuivies");
        
        if(joueur != null){
            if(connectes.contains(joueur)){
                connectes.remove(joueur);
                se.getSession().getServletContext().setAttribute("syncConnectes", String.valueOf(SyncLogIn.getInstant()));
            }
            
            while(demandes.iterator().hasNext()){
                Demande demande = demandes.iterator().next();
                if(demande.getEmetteur().equals(joueur.getIdentifiant()) || demande.getReceveur().equals(joueur.getIdentifiant())){
                    demandes.remove(demande);
                    se.getSession().getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                }
            }
            
            for (PartieEchec partie : parties) {
                if(partie.getPlayerB().getJoueur().equals(joueur) || partie.getPlayerN().getJoueur().equals(joueur)){
                    parties.remove(partie);
                    se.getSession().getServletContext().setAttribute("syncParties", String.valueOf(SyncLogIn.getInstant()));
                }
            }
            
            if(partiesSuivies.containsKey(joueur.getIdentifiant())){
                PartieEchec partie = partiesSuivies.get(joueur.getIdentifiant());
                for (Map.Entry<String,PartieEchec> entry : partiesSuivies.entrySet()) {
                    if(entry.getValue().equals(partie)){
                        partiesSuivies.remove(entry.getKey());
                    }
                }
            }
            
        }
        
        se.getSession().getServletContext().setAttribute("connectes", connectes);
        se.getSession().getServletContext().setAttribute("demandes", demandes);
        se.getSession().getServletContext().setAttribute("parties", parties);
        se.getSession().getServletContext().setAttribute("partiesSuivies", partiesSuivies);
    }
    
}
