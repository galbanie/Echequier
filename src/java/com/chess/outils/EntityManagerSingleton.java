/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.outils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author galbanie
 */
public class EntityManagerSingleton {
    private EntityManagerSingleton(){
    }

    private static class EMSingletonHolder{
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EchequierPersistance");
        private static final EntityManager em = emf.createEntityManager();
    }

    public static EntityManager getInstance(){
        return EMSingletonHolder.em;
    }
}
