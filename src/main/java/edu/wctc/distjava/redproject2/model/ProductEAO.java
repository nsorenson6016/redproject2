/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject2.model;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Neal
 */

@Repository
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly=true)
public class ProductEAO {
    
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    
//    @Transactional(readOnly = false, rollbackFor = Exception.class)
//    public void delete() {}

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public Product getProductById(Object id) {
        return getEntityManager().find(Product.class, id);
    }
 
}
