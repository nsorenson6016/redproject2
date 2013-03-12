/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject2.model;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Neal
 */

@Named
@Stateless
public class BidEAO {
    
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public Bid getBidById(Object id) {
        return getEntityManager().find(Bid.class, id);
    }
 
}
