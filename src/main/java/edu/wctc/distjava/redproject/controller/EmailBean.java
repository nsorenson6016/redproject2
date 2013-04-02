package edu.wctc.distjava.redproject.controller;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Neal Sorenson
 */

@Named("emailbean")
@Scope("request")
public class EmailBean {
    private String email;
    private String subject;
    private String message;
    
    public EmailBean(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String processInfo(){
        return "emailresults";
    }
    
}
