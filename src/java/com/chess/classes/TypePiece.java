/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.classes;

/**
 *
 * @author galbanie
 */
public enum TypePiece {
    ROI(Roi.class,Roi.class.getName()),
    REINE(Reine.class,Reine.class.getName()),
    FOU(Fou.class,Fou.class.getName()),
    CHEVALIER(Chevalier.class,Chevalier.class.getName()),
    TOUR(Tour.class,Tour.class.getName()),
    PION(Pion.class,Pion.class.getName());

    private TypePiece(Class classPiece, String classNamePiece) {
        this.classPiece = classPiece;
        this.classNamePiece = classNamePiece;
    }
    
    private final Class classPiece;
    private final String classNamePiece;

    public Class getClassPiece() {
        return classPiece;
    }

    public String getClassNamePiece() {
        return classNamePiece;
    }
    
    
}
