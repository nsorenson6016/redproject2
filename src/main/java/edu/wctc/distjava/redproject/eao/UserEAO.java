/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Neal
 */
@Repository("userEAO")
@Scope("request")
public class UserEAO implements IUserEAO{
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Users getUserById(Object id){
        return null;
    }

    @Override
    public void create(Users user){
        
    }

    @Override
    public void update(Users user){}
    
    @Override
    public Users findUser(Long id){
        return null;
    }
    
    @Override
    public List<Users> findUserEntities(){
        return null;
    }
    
    @Override
    public List<Users> findUserEntities(int maxResults, int firstResult){
        return null;
    }

    @Override
    public int getUserCount(){
        return 0;
    }
    
    @Override
    public List<Users> findUserEntitiesByStatus(){
        return null;
    }
    
    @Override
    public Users findUserByUserName (String name){
        Users foundUser = getEm().find(Users.class, name);
        
        return foundUser;
    }
}
