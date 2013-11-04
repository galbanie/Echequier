package com.chess.classes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author galbanie
 */
public class Echequier {
    
    private Map<Position,Piece> plateau;
    
    private EtatPlateau etat;

    public Echequier() {
        plateau = new HashMap<Position, Piece>(64);
        etat = EtatPlateau.AUCUN;
    }
    
    public void initialiser(){
        if(!etat.equals(EtatPlateau.PRET)){
            
            for(int i = 1; i < 9; i++){
                for(int j = 1; j < 9; j++){
                    if(i == 1){
                        switch(j){
                            case 1 : plateau.put(new Position(i,j), new Tour(ColorPiece.WHITE));
                            break;
                            case 2 : plateau.put(new Position(i,j),new Chevalier(ColorPiece.WHITE));
                            break;
                            case 3 : plateau.put(new Position(i,j), new Fou(ColorPiece.WHITE));
                            break;
                            case 4 : plateau.put(new Position(i,j), new Reine(ColorPiece.WHITE));
                            break;
                            case 5 : plateau.put(new Position(i,j), new Roi(ColorPiece.WHITE));
                            break;
                            case 6 : plateau.put(new Position(i,j), new Fou(ColorPiece.WHITE));
                            break;
                            case 7 : plateau.put(new Position(i,j),new Chevalier(ColorPiece.WHITE));
                            break;
                            case 8 : plateau.put(new Position(i,j), new Tour(ColorPiece.WHITE));
                            break;
                        }
                    }
                    else if(i == 2){
                        plateau.put(new Position(i,j), new Pion(ColorPiece.WHITE));
                    }
                    else if(i == 7){
                        plateau.put(new Position(i,j), new Pion(ColorPiece.BLACK));
                    }
                    else if(i == 8){
                        switch(j){
                            case 1 : plateau.put(new Position(i,j), new Tour(ColorPiece.BLACK));
                            break;
                            case 2 : plateau.put(new Position(i,j),new Chevalier(ColorPiece.BLACK));
                            break;
                            case 3 : plateau.put(new Position(i,j), new Fou(ColorPiece.BLACK));
                            break;
                            case 4 : plateau.put(new Position(i,j), new Reine(ColorPiece.BLACK));
                            break;
                            case 5 : plateau.put(new Position(i,j), new Roi(ColorPiece.BLACK));
                            break;
                            case 6 : plateau.put(new Position(i,j), new Fou(ColorPiece.BLACK));
                            break;
                            case 7 : plateau.put(new Position(i,j),new Chevalier(ColorPiece.BLACK));
                            break;
                            case 8 : plateau.put(new Position(i,j), new Tour(ColorPiece.BLACK));
                            break;
                        }
                    }
                    else plateau.put(new Position(i,j),null);

                }
            }
                
            etat = EtatPlateau.PRET;
        }
    }

    public EtatPlateau getEtat() {
        return etat;
    }
    
}
