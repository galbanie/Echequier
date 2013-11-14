/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.modeles.manager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author galbanie
 * @param <E>
 */
public class Manager<E> {
    private final EntityManager em;
    private Query query;

    public Manager(EntityManager em) {
        this.em = em;
        this.query = null;
    }
    
    /**
     *
     * @param entity
     * @return
     */
    public E create(E entity){
        if(entity == null) return null;
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
    
    public E find(Class classEntity,Object id){
        em.getTransaction().begin();
        E entity = (E) em.find(classEntity, id);
        em.getTransaction().commit();
        return entity;
    }
    
    public E update(E entity){
        if(entity == null) return null;
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }
    
    public void delete(E entity){
        if(entity != null){
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        }
    }
    
    public List<E> findResultList(){
        List<E> entitys = null;
        if(query != null) entitys = query.getResultList();
        query = null;
        return entitys;
    }
    
    public E findSingleResult(){
        E entity = null;
        try{
            if(query != null)entity = (E) query.getSingleResult();
            query = null;
        }
        catch(NoResultException e){
            entity = null;
        }
        return entity;
    }
    
    public void createQuery(String str){
        query = em.createQuery(str);
    }
    
    public void createNamedQuery(String str){
        query = em.createNamedQuery(str);
    }
    
    public void setParametre(String parametre, Object valeur){
        if(query != null) query.setParameter(parametre, valeur);
    }
    
}
