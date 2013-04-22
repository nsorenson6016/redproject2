/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import edu.wctc.distjava.redproject.eao.IUserRegistrationEAO;
import edu.wctc.distjava.redproject.model.Users;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly=true)
public class UserRegistrationService {
    @Inject
    IUserRegistrationEAO userRegEao;
    
    public String isUsernameInUse(String username) {
        return userRegEao.isUsernameInUse(username);
    }
    
    @Transactional(readOnly=false, rollbackFor=Exception.class)
    public void createNewUser(Users user) {
        userRegEao.createNewUser(user);
    }
    
    // If doing a write operation you must annotate your methods with
    // @Transactional(readOnly=false, rollbackFor=Exception.class)

    public IUserRegistrationEAO getUserRegEao() {
        return userRegEao;
    }

    public void setUserRegEao(IUserRegistrationEAO userRegEao) {
        this.userRegEao = userRegEao;
    }
    
}