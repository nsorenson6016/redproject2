/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Owner
 */
@Repository
@Scope("request")
public class UserRegistrationEAO implements IUserRegistrationEAO {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void createNewUser(Users user) {
        em.persist(user);
    }

    @Override
    public String isUsernameInUse(String username) {
        Users user = getEm().find(Users.class, username);
        
        return (user != null) ? username : null;
         
    }
    
    
}