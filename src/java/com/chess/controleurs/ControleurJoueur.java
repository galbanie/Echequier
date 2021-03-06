package com.chess.controleurs;

import com.chess.modeles.entite.Joueur;
//import com.chess.modeles.manager.JoueurManager;
import com.chess.modeles.manager.Manager;
import com.chess.outils.EntityManagerSingleton;
import com.chess.outils.SyncLogIn;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
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
        String reponseAjax = "";
        
        LinkedHashSet<Joueur> connectes;
        
        // on cree un pointeur sur un Joueur null
        Joueur joueur;
        
        // on cree un joueurManager qui sera chargé de faire interface entre la BD et la servlet
        //JoueurManager joueurManager = new JoueurManager();
        Manager<Joueur> joueurManager = new Manager<Joueur>(EntityManagerSingleton.getInstance());
        
        /*joueurManager.createJoueur(new Joueur("jean", "juju@elle.moi", "123456789"));
        joueurManager.createJoueur(new Joueur("roro", "roro@elle.moi", "123456789"));*/
        
        
        /*if(getServletContext().getAttribute("connectes") == null){
            getServletContext().setAttribute("connectes", connectes);
        }*/
        
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();*/
        
        
        
        
        // si il y a un membre dans la session on le recupere
        if(session.getAttribute("joueur") != null)joueur = (Joueur)session.getAttribute("joueur");
        else {
            if(request.getParameter("username") != null && !request.getParameter("username").equals("")){
                //joueur = joueurManager.findJoueurByUsername((String)request.getParameter("username"));
                joueurManager.createNamedQuery("Joueur.findByIdentifiant");
                joueurManager.setParametre("identifiant", (String)request.getParameter("username"));
                joueur = joueurManager.findSingleResult();
                if(joueur != null){
                    reponseAjax = "Member";
                }else{
                    reponseAjax = "NoMember";
                }
            }
            else {
                joueur = null;
                reponseAjax = "NoMember";
            }
        }
        
        
        if(action.equals("connecter") && session.getAttribute("joueur") == null){

                if(joueur != null){
                    if(request.getParameter("password") != null && joueur.getPassword().equals((String)request.getParameter("password"))) {
                        session.setAttribute("joueur", joueur);
                        synchronized(this){
                            this.getServletContext().setAttribute("syncConnectes", String.valueOf(SyncLogIn.getInstant()));

                            // on y rajoute le joueur connectée
                            connectes = (LinkedHashSet<Joueur>)this.getServletContext().getAttribute("connectes");
                            if(!connectes.contains(joueur)){
                                connectes.add(joueur);
                            }
                            this.getServletContext().setAttribute("connectes", connectes);
                        }

                    }
                    else{
                        request.setAttribute("section", "home");
                    }
                }
                
        }
        else if(joueur == null && action.equals("inscrire")){
            if(request.getParameter("method")!= null && request.getParameter("method").equals("ajax")){

                out.print(reponseAjax);
                //joueurManager.closeEntityManager();
                return;
            }
            
            if(request.getParameter("secureSignIn") != null && request.getParameter("secureSignIn").equals("inscription")){
                joueur = new Joueur((String)request.getParameter("username"), (String)request.getParameter("email"), (String)request.getParameter("password"));
                //joueurManager.createJoueur(joueur);
                joueurManager.create(joueur);
                request.setAttribute("section", "home");
            }
            else request.setAttribute("section", "inscription");
        }
        else if(action.equals("modifier")){
            
        }
        else if(joueur != null && action.equals(joueur.getIdentifiant())){
            if(request.getParameter("visible") != null){
                if(request.getParameter("visible").equals("true")){
                    joueur.setVisible(true);
                    
                }
                else if(request.getParameter("visible").equals("false")){
                    joueur.setVisible(false);
                }
                session.setAttribute("joueur", joueur);
                connectes = (LinkedHashSet<Joueur>)this.getServletContext().getAttribute("connectes");
                if(connectes.contains(joueur)){
                    this.getServletContext().setAttribute("syncConnectes",String.valueOf(SyncLogIn.getInstant()));
                    connectes.remove(joueur);
                    connectes.add(joueur);
                }
                
            }
            request.setAttribute("section", "profil");
        }
        else if(action.equals("deconnexion") && session.getAttribute("joueur") != null){
            session.setAttribute("joueur", null);
            session.removeAttribute("joueur");
            synchronized(this){
                this.getServletContext().setAttribute("syncConnectes",String.valueOf(SyncLogIn.getInstant()));
                // on recupere et supprime le joueur dans le scope application
                connectes = (LinkedHashSet<Joueur>)this.getServletContext().getAttribute("connectes");
                if(connectes.contains(joueur)){
                    connectes.remove(joueur);
                }
                this.getServletContext().setAttribute("connectes", connectes);
            }

            request.setAttribute("section", "home");
        }
       
        /*transaction.commit();
        em.close();
        emf.close(); */
        this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
        //joueurManager.closeEntityManager();
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
