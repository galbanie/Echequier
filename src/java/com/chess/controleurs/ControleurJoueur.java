/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.controleurs;

import com.chess.modeles.entite.Joueur;
import com.chess.modeles.manager.JoueurManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.persistence.NoResultException;
/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galbanie
 */
public class ControleurJoueur extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        
        if(request.getParameter("method") != null && request.getParameter("method").equals("refresh")){
            //out.print();
            //return;
        }
        
        // on definit le type du contenu a renvoié ici du text simple
        response.setContentType("text/plain;charset=UTF-8");
        
        // on recupere la session
        HttpSession session = request.getSession(true);
        
        // on recupere l'action venant du controleur frontale
        String action = (String)request.getAttribute("action");
        
        LinkedList<Joueur> connectes;
        
        // on cree un pointeur sur un Joueur null
        Joueur joueur;
        
        // on cree un joueurManager qui sera chargé de faire interface entre la BD et la servlet
        JoueurManager joueurManager = new JoueurManager();
        
        /*joueurManager.createJoueur(new Joueur("jean", "juju@elle.moi", "123456789"));
        joueurManager.createJoueur(new Joueur("roro", "roro@elle.moi", "123456789"));*/
        
        
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();*/
        
        
        /*synchronized(this){
            
        }*/
        
        
        if(session.getAttribute("joueur") == null){
            if(action.equals("connecter")){
                if(request.getParameter("username") != null && request.getParameter("password") != null){
                    try{
                    joueur = joueurManager.findJoueurByUsername((String)request.getParameter("username"));
                    }catch(NoResultException e){
                        joueur = null;
                    }
                    if(joueur != null){
                        if(joueur.getPassword().equals((String)request.getParameter("password"))) {
                            session.setAttribute("joueur", joueur);
                            // on syncronise le scope application
                            // on y rajoute le joueur connectée
                            synchronized(this){
                                if(getServletContext().getAttribute("connectes") == null){
                                    getServletContext().setAttribute("connectes", new LinkedList<Joueur>());
                                }
                                connectes = (LinkedList<Joueur>)getServletContext().getAttribute("connectes");
                                connectes.addFirst(joueur);
                                getServletContext().setAttribute("connectes", connectes);
                            }
                        }
                        if(request.getParameter("method")!= null && request.getParameter("method").equals("ajax")){
                            out.print("Member");
                            return;
                        }
                        else{
                            request.setAttribute("section", "home");
                        }
                    }
                    else{
                        if(request.getParameter("method")!= null && request.getParameter("method").equals("ajax")){
                            out.print("No Member");
                            return;
                        }
                        else{
                            request.setAttribute("section", "home");
                        }
                    }
                }
            }
            else if(action.equals("inscrire")){
                request.setAttribute("section", "inscription");
            }
        }
        else{
            joueur = (Joueur)session.getAttribute("joueur");
            if(action.equals("modifier")){
            
            }
            else if(action.equals(joueur.getIdentifiant())){
               
            }
            else if(action.equals("deconnexion")){
                joueur = (Joueur)session.getAttribute("joueur");
                synchronized(this){
                    connectes = (LinkedList<Joueur>)getServletContext().getAttribute("connectes");
                    connectes.remove(joueur);
                    getServletContext().setAttribute("connectes", connectes);
                }
                session.setAttribute("joueur", null);
                session.removeAttribute("joueur");
                request.setAttribute("section", "home");
            }
        }
        /*transaction.commit();
        em.close();
        emf.close(); */
        this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
        joueurManager.closeEntityManager();
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
