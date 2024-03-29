package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.service.CustServiceEmailer;
import edu.wctc.distjava.redproject.service.IEmailer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Neal Sorenson
 */

@Named("custservemailbean")
@Scope("session")
public class CustServEmailBean {
    private String name;
    private String email; 
    private String subject;
    private String message;

 @Autowired
 @Qualifier("custservice")
    private IEmailer emailer;
    
    public CustServEmailBean(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

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
    
    public String sendMail(){
        String destination = "index";
        
        try{
            emailer.sendEmail(email, subject);
            emailer.emailHQ(name, email, subject, message);
        } catch (Exception e){
            destination = "emailerror";
        }
        
        return destination;        
    }

}
