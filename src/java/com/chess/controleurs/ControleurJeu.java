package com.chess.controleurs;

import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import com.chess.outils.SyncLogIn;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galbanie
 */
public class ControleurJeu extends HttpServlet {

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
        // on definit le type du contenu a renvoié ici du text simple
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // on recupere la session
        HttpSession session = request.getSession(true);
        
        // on recupere l'action venant du controleur frontale
        String action = (String)request.getAttribute("action");
        String reponseAjax = "";
        
        LinkedHashSet<Demande> demandes;
        
        Demande demande;
        
        
        if(action.equals("jouer") && session.getAttribute("joueur") != null){
            
            Joueur joueur = (Joueur)session.getAttribute("joueur");
            
            if(request.getParameter("contre") != null && !request.getParameter("contre").equals(joueur.getIdentifiant())){
                demande = new Demande(joueur.getIdentifiant(),(String)request.getParameter("contre"));
                synchronized(this){
                    
                    demandes = (LinkedHashSet<Demande>)this.getServletContext().getAttribute("demandes");
                    if(!demandes.contains(demande)){
                        demandes.add(demande);
                        this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                    }
                    this.getServletContext().setAttribute("demandes", demandes);
                }
                request.setAttribute("section", "home");
            }
            
            else if(request.getParameter("a") != null && request.getParameter("reponse") != null){
                
                if(!request.getParameter("a").equals(joueur.getIdentifiant())){
                    
                    if(request.getParameter("reponse").equals("oui")){
                        // on cree une nouvelle partie
                    }
                    else if(request.getParameter("reponse").equals("non")){
                        //
                    }
                    
                    // on supprime la demande du scope Application
                    
                }
                
            }
            else request.setAttribute("section", "home");
            
        }
        else if(action.equals("regarder")){
            
        }
        
        this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
        
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
