/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.listerner;

import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import java.util.LinkedHashSet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author galbanie
 */
public class ApplicationListerner implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("connectes", new LinkedHashSet<Joueur>());
        sce.getServletContext().setAttribute("syncConnectes", "");
        sce.getServletContext().setAttribute("demandes", new LinkedHashSet<Demande>());
        sce.getServletContext().setAttribute("syncDemandes", "");
        sce.getServletContext().setAttribute("parties", new LinkedHashSet<Joueur>());
        sce.getServletContext().setAttribute("syncParties", "");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
