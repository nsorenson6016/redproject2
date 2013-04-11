/*
 * WebNavigationBean - used to redirect a user to the sites listed in this class.
 */
package edu.wctc.distjava.redproject.controller;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Neal Sorenson
 */

@Named("webBean")
@Scope("request")
public class WebNavigationBean {
    public String toIndex(){
        return "index";
    }
    
    public String toCustServ(){
        return "customer_service";
    }
    
    public String toEmailResults(){
        return "emailresults";
    }
    
    public String toPolicies(){
        return "policies";
    }
    
    public String toLogin(){
        return "login";
    }
    
}
