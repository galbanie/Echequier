package com.chess.outils;


import com.chess.classes.Demande;
import com.chess.modeles.entite.Joueur;
import com.chess.modeles.entite.PartieEchec;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author galbanie
 */
public class Refresh extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        JSONObject jsonObjet = new JSONObject();
        
        Joueur joueur = (Joueur)request.getSession().getAttribute("joueur");
        LinkedHashSet<Joueur> connectes = (LinkedHashSet<Joueur>)this.getServletContext().getAttribute("connectes");
        LinkedHashSet<Demande> demandes = ( LinkedHashSet<Demande>)this.getServletContext().getAttribute("demandes");
        LinkedHashSet<PartieEchec> parties = ( LinkedHashSet<PartieEchec>)this.getServletContext().getAttribute("parties");
        HashMap<String,PartieEchec> partiesSuivies = (HashMap<String,PartieEchec>)this.getServletContext().getAttribute("partiesSuivies");
        
        String identifiant = (joueur != null) ? joueur.getIdentifiant() : "";
        
        String pathServeur = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
        
        jsonObjet.put("pathServeur", pathServeur);
        
        jsonObjet.put("contextPath",(String)this.getServletContext().getContextPath());
        
        jsonObjet.put("joueur", identifiant);
        
        jsonObjet.put("syncConnectes",(String)this.getServletContext().getAttribute("syncConnectes"));
        
        jsonObjet.put("connectes", connectes);
        
        jsonObjet.put("syncDemandes", (String)this.getServletContext().getAttribute("syncDemandes"));
        
        jsonObjet.put("demandes", demandes);
        
        jsonObjet.put("syncParties", (String)this.getServletContext().getAttribute("syncParties"));
        
        jsonObjet.put("parties", parties);
        
        jsonObjet.put("syncPartiesSuivies", (String)this.getServletContext().getAttribute("syncPartiesSuivies"));
        
        jsonObjet.put("partiesSuivies", partiesSuivies);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        out.println(jsonObjet.toJSONString());
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
