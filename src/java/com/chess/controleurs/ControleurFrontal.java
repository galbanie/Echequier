/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.controleurs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author galbanie
 */
public class ControleurFrontal extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * Récuperation des contrôles depuis l'URI, decoupage des Strings
         *  Ex : Pour l'URI : "/Echequier/Jeu/"
         *       On obtient : {}{Echequier}{Jeu}
         */
        String[] controles = request.getRequestURI().split("/");
        
        // Si il y a un contrôle autre que celui du controleur Frontal {Echequier}
        if(controles.length > 3){
            
            if(controles[3].matches("jouer")){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/jeu").forward(request, response);
            }
            else if(controles[3].matches("regarder")){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/jeu").forward(request, response);
            }
            else if(controles[3].matches("connecter")){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/joueur").forward(request, response);
            }
            else if(controles[3].matches("inscrire")){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/joueur").forward(request, response);
            }
            else if(controles[3].matches("modifier")){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/joueur").forward(request, response);
            }
            else if(request.getSession(true).getAttribute("joueur") != null && controles[3].matches((String)request.getSession(true).getAttribute("joueur"))){
                request.setAttribute("action", controles[3]);
                this.getServletContext().getRequestDispatcher("/run/joueur").forward(request, response);
            }
            else if(controles[3].matches("regles")){
                request.setAttribute("section", controles[3]);
                this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
            }
            else{
                request.setAttribute("section", "home");
                this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("section", "home");
            this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
        }
        
        /*PrintWriter out = response.getWriter();

        try {
            for(int i = 0; i < controles.length; i++)
            out.println(i+"- ("+controles[i]+")<br />");
        }
        finally{
            
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
