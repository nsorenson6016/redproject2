/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import edu.wctc.distjava.redproject.eao.UserRegistrationEAOI;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Owner
 */
@Service
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly=true)
public class UserRegistrationService {
    @Inject
    UserRegistrationEAOI userRegEao;
    
    public String isUsernamereInUse(String username) {
        return null;
    }
    
    // If doing a write operation you must annotate your methods with
    // @Transactional(readOnly=false, rollbackFor=Exception.class)

    public UserRegistrationEAOI getUserRegEao() {
        return userRegEao;
    }

    public void setUserRegEao(UserRegistrationEAOI userRegEao) {
        this.userRegEao = userRegEao;
    }
    
}
