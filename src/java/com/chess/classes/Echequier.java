package com.chess.classes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author galbanie
 */
public final class Echequier {
    // Le plateau Map
    private Map<Position,Piece> plateau;
    // Etat de l'echequier
    private EtatPlateau etat;
    // Piece selectionée
    private Entry<Position, Piece> selection;
    //Liste des capturés noirs
    private List<Piece> capturesBlack;
    //Liste des capturés white
    private List<Piece> capturesWhite;
    
    public Echequier(boolean initialise) {
        plateau = new HashMap<Position, Piece>(64);
        capturesBlack = new LinkedList<Piece>();
        capturesWhite = new LinkedList<Piece>();
        etat = EtatPlateau.AUCUN;
        selection = null;
        if(initialise) this.initialiser();
    }
    
    public Echequier(){
        this(true);
    }
    
    public void initialiser(){
        if(!etat.equals(EtatPlateau.PRET)){
            selection = null;
            capturesBlack = new LinkedList<Piece>();
            capturesWhite = new LinkedList<Piece>();
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
    
    public boolean selectionner(Position position){
        if((etat.equals(EtatPlateau.PRET) || etat.equals(EtatPlateau.EN_COURS)) && plateau.containsKey(position)){
            for(Entry<Position, Piece> entry : plateau.entrySet()) {
                if(entry.getKey().equals(position)){
                    selection = entry;
                    break;
                }
            }
            if(selection != null && selection.getValue() != null) return true;
        }
        return false;
    }
    
    public boolean selectionner(int ligne, int colonne){
        return selectionner(new Position(ligne, colonne));
    }
    
    public String getNamePieceSelectionnee(){
        return (selection!=null && selection.getValue() != null ) ? selection.getValue().toString() : "None";
    }
    
    public List<Position> positionsPieces(TypePiece typePiece, ColorPiece color){
        List<Position> positions =  new LinkedList<Position>();
        Piece piece;
        for(int i = 1; i < 9; i++)
            for(int j = 1; j < 9; j++) {
                piece = plateau.get(new Position(i,j));
                if(piece != null && piece.getClass() == typePiece.getClassPiece() && piece.getCouleur().equals(color))
                    positions.add(new Position(i,j));
            }
        return positions;
    }
    
    public List<Position> positionsPieces(TypePiece typePiece){
        List<Position> positions =  new LinkedList<Position>();
        positions.addAll(positionsPieces(typePiece, ColorPiece.BLACK));
        positions.addAll(positionsPieces(typePiece, ColorPiece.WHITE));
        return positions;
    }
    
    public boolean deplacer(Position position){
        if((etat.equals(EtatPlateau.PRET) || etat.equals(EtatPlateau.EN_COURS)) && plateau.containsKey(position) && selection != null && selection.getValue() != null){
            Entry<Position, Piece> cible = null;
            for(Entry<Position, Piece> entry : plateau.entrySet()) {
                if(entry.getKey().equals(position)){
                    cible = entry;
                    break;
                }
            }
            
           // si l'entrée existe dans la map
           if(cible != null){
               // si la piece selectionnée peut se déplacer à la position de la cible
               if(selection.getValue().deplacer(selection.getKey(), cible.getKey())){
                   // Si à la position de la cible il y a une piece
                   if(cible.getValue() != null){
                       // si la piece cible est de la même couleur que la pièce sélectionnée
                       if(cible.getValue().getCouleur().equals(selection.getValue().getCouleur())){
                           // si la piece selectionner est un Roi et que la cible de destination est un Pion
                            if(selection.getValue().getClass().equals(TypePiece.ROI.getClassPiece()) && cible.getValue().getClass().equals(TypePiece.PION.getClass())){
                                // Le Roi echange de place avec le Pion
                                plateau.put(cible.getKey(), selection.getValue());
                                plateau.put(selection.getKey(), cible.getValue());
                                // on deselectionne
                                selection = null;
                                return true;
                            }
                       }
                       else{
                           if(cible.getValue().getCouleur().equals(ColorPiece.BLACK)) capturesBlack.add(cible.getValue());
                           else capturesWhite.add(cible.getValue());
                       }
                   }
                   plateau.put(cible.getKey(), selection.getValue());
                   plateau.put(selection.getKey(), null);
                   // on deselectionne
                   selection = null;
                   return true;
               }
           }
           
        }
        return false;
    }

    public Map<Position, Piece> getPlateau() {
        return plateau;
    }

    public List<Piece> getCapturesBlack() {
        return capturesBlack;
    }

    public List<Piece> getCapturesWhite() {
        return capturesWhite;
    }
    
}
