/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import edu.wctc.distjava.redproject.eao.UserEAO;
import edu.wctc.distjava.redproject.model.Users;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository("userService")
@Service
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(readOnly=true)
public class UserService {
    @Inject
    UserEAO eao;
    
    public Users findUserByUserName(String username){
        Users u = eao.findUserByUserName(username);
        return u;
    }

    public UserEAO getEao() {
        return eao;
    }

    public void setEao(UserEAO eao) {
        this.eao = eao;
    }
    
}
