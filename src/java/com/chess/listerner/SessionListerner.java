package com.chess.listerner;

import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import com.chess.outils.SyncLogIn;
import java.util.LinkedHashSet;
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
        }
        
        se.getSession().getServletContext().setAttribute("connectes", connectes);
        se.getSession().getServletContext().setAttribute("demandes", demandes);
    }
    
}
