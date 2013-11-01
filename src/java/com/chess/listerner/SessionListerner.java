/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.listerner;

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
        if(joueur != null && connectes.contains(joueur)){
            connectes.remove(joueur);
            se.getSession().getServletContext().setAttribute("syncConnectes", SyncLogIn.getStrInstant());
        }
        se.getSession().getServletContext().setAttribute("connectes", connectes);
    }
    
}
