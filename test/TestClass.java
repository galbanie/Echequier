
import com.chess.classes.Demande;
import com.chess.classes.Echequier;
import com.chess.modeles.entite.Deplacement;
import com.chess.modeles.entite.Position;
import com.chess.modeles.entite.Joueur;
import com.chess.modeles.entite.PartieEchec;
import com.chess.modeles.manager.Manager;
import com.chess.outils.EntityManagerSingleton;
import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author galbanie
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joueur joueur = new Joueur("galba", "galba@moi.toi", "1234567");
        
        //PartieEchec partie = new PartieEchec(joueur, joueur);
        
        //Manager<Joueur> joueurManager = new Manager<Joueur>(EntityManagerSingleton.getInstance());
        Manager partieManager = new Manager(EntityManagerSingleton.getInstance());
        
        /*System.out.println(joueurManager.find(Joueur.class, 1));
        
        System.out.println(joueur.toJSONString());
        System.out.println(partie.toJSONString());*/
        //joueurManager.createNamedQuery("Joueur.findByIdentifiant");
        //joueurManager.setParametre("identifiant", "galbanie");
        //Joueur adversaire = joueurManager.findSingleResult();
        //Demande demande1 = new Demande(joueur.getIdentifiant(), adversaire.getIdentifiant());
        //Demande demande2 = new Demande(adversaire.getIdentifiant(), joueur.getIdentifiant());
        //System.out.println(joueurManager.findSingleResult());
        //System.out.println(demande1.equals(demande2));
        
        PartieEchec partie = new PartieEchec(joueur, new Joueur("test", "testemail", "1234567"));
        partieManager.create(partie);
        partie.selectionner(new Position(2, 1));
        partie.deplacer(new Position(3, 1));
        partie.selectionner(new Position(8, 2));
        partie.deplacer(new Position(6, 3));
        partieManager.update(partie);
        System.out.println(partie.getDeplacement().size());
        
        //System.out.println(partie);
        
        /*Echequier chess = new Echequier();
        
        String choix = "";
        
        Scanner scan = new Scanner(System.in);
       
        
        while(!choix.equals("quitter")){
            System.out.println(chess);
            System.out.println("-------------------------------------------");
            System.out.println("deplacer");
            System.out.println("-------------------------------------------");
            System.out.print("choix : ");
            choix = scan.nextLine();
            if(choix.equals("deplacer")){
                System.out.print("ligne depart : ");
                int lignedep = Integer.parseInt(scan.nextLine());
                System.out.print("colonne depart : ");
                int colonnedep = Integer.parseInt(scan.nextLine());
                System.out.print("ligne arrive : ");
                int lignearr = Integer.parseInt(scan.nextLine());
                System.out.print("colonne arrive : ");
                int colonnearr = Integer.parseInt(scan.nextLine());
                System.out.println(chess.selectionner(new Position(lignedep, colonnedep)));
                System.out.println(chess.deplacer(new Position(lignearr, colonnearr)));
            }
            
        }*/
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierUP");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();*/
        
        /*Deplacement dep = new Deplacement(new Position(1, 5), new Position(5, 1));
        System.out.println(dep);*/
    }
    
}
