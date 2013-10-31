/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.listerner;

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
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
