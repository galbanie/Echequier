package com.chess.controleurs;

import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import com.chess.modeles.entite.PartieEchec;
import com.chess.modeles.manager.Manager;
import com.chess.outils.EntityManagerSingleton;
import com.chess.outils.SyncLogIn;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // on recupere la session
        HttpSession session = request.getSession(true);
        
        // on recupere l'action venant du controleur frontale
        String action = (String)request.getAttribute("action");
        String reponseAjax = "";
        
        LinkedHashSet<Demande> demandes = (LinkedHashSet<Demande>)this.getServletContext().getAttribute("demandes");
        
        LinkedHashSet<PartieEchec> parties = (LinkedHashSet<PartieEchec>)this.getServletContext().getAttribute("parties");
        
        HashMap<String,PartieEchec> partiesSuivies = (HashMap<String,PartieEchec>)this.getServletContext().getAttribute("partiesSuivies");
        
        LinkedHashSet<Joueur> connectes = (LinkedHashSet<Joueur>)this.getServletContext().getAttribute("connectes");
        
        Joueur joueur = (Joueur)session.getAttribute("joueur");
        
        Joueur adversaire = null;
        
        Demande demande;
        
        Demande demandeAdverse;
        
        PartieEchec partie;
        
        Manager<PartieEchec> partieManager = new Manager<PartieEchec>(EntityManagerSingleton.getInstance());
        
        Manager<Joueur> joueurManager = new Manager<Joueur>(EntityManagerSingleton.getInstance());
        
        if(joueur != null){
            // On recupere l'adversaire
            if((request.getParameter("qui") != null && !request.getParameter("qui").equals(joueur.getIdentifiant())) ||
               (request.getParameter("avec") != null && !request.getParameter("avec").equals(joueur.getIdentifiant()))){
                //if(!request.getParameter("qui").equals(joueur.getIdentifiant()) || !request.getParameter("avec").equals(joueur.getIdentifiant())){
                    String identifiant = (request.getParameter("qui") != null)?(String)request.getParameter("qui"):(String)request.getParameter("avec");
                    joueurManager.createNamedQuery("Joueur.findByIdentifiant");
                    joueurManager.setParametre("identifiant", identifiant);
                    adversaire = joueurManager.findSingleResult();
                //}
            }
        }
        
        /*if(joueur != null){
            if(adversaire != null){
                if(connectes.contains(adversaire)){
                    demande = new Demande(joueur.getIdentifiant(), adversaire.getIdentifiant());
                    System.out.println(demande);
                    if(demandes.contains(demande)){
                        if(action.equals("jouer")){
                            partie = new PartieEchec(joueur, adversaire);
                            if(!parties.contains(partie)){
                                parties.add(partie);
                                partieManager.create(partie);
                                partiesSuivies.put(joueur.getIdentifiant(), partie);
                                partiesSuivies.put(adversaire.getIdentifiant(), partie);
                                this.getServletContext().setAttribute("syncParties", String.valueOf(SyncLogIn.getInstant()));
                                this.getServletContext().setAttribute("syncPartiesSuivies", String.valueOf(SyncLogIn.getInstant()));
                            }
                        }
                        else if(action.equals("demander")){
                            if(request.getParameter("action") != null && request.getParameter("action").equals("annuler")){
                                demandes.remove(demande);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                        }
                    }
                    else if(action.equals("demander")){
                        //if(action.equals("demander")){
                            demandes.add(demande);
                            this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                        //}
                    }
                }
            }
            else if(action.equals("regarder")){
                
            }
        }
        else if(action.equals("regarder")){
            
        }*/
        
        if(action.equals("regarder")){
            
        }
        else{
            if(joueur != null && adversaire != null){
                if(connectes.contains(adversaire)){
                    demande = new Demande(joueur.getIdentifiant(), adversaire.getIdentifiant());
                    demandeAdverse = new Demande(adversaire.getIdentifiant(), joueur.getIdentifiant());
                    if(action.equals("jouer")){
                        //demande = new Demande(adversaire.getIdentifiant(), joueur.getIdentifiant());
                        if(request.getParameter("partie") != null){
                            
                        }
                        else{
                            if(demandes.contains(demande)){
                                demandes.remove(demande);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                            if(demandes.contains(demandeAdverse)){
                                demandes.remove(demandeAdverse);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                            partie = new PartieEchec(joueur, adversaire);
                            if(!parties.contains(partie)){
                                partieManager.create(partie);
                                parties.add(partie);
                                
                                partiesSuivies.put(joueur.getIdentifiant(), partie);
                                partiesSuivies.put(adversaire.getIdentifiant(), partie);
                                
                                this.getServletContext().setAttribute("syncParties", String.valueOf(SyncLogIn.getInstant()));
                                this.getServletContext().setAttribute("syncPartiesSuivies", String.valueOf(SyncLogIn.getInstant()));
                            }
                        }
                    }
                    else if(action.equals("demander")){
                        //demande = new Demande(joueur.getIdentifiant(), adversaire.getIdentifiant());
                        if(request.getParameter("action") != null && request.getParameter("action").equals("annuler")){
                            if(demandes.contains(demande)){
                                demandes.remove(demande);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                            if(demandes.contains(demandeAdverse)){
                                demandes.remove(demandeAdverse);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                        }
                        else{
                            if(!demandes.contains(demande) && !demandes.contains(demandeAdverse)){
                                demandes.add(demande);
                                this.getServletContext().setAttribute("syncDemandes", String.valueOf(SyncLogIn.getInstant()));
                            }
                        }
                    }
                }
            }
        }
        
        //System.out.println(demandes);
        
        synchronized(this){
            this.getServletContext().setAttribute("demandes", demandes);
            this.getServletContext().setAttribute("parties", parties);
            this.getServletContext().setAttribute("partiesSuivies", partiesSuivies);
        }
        
        this.getServletContext().getRequestDispatcher("/gabarit.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
