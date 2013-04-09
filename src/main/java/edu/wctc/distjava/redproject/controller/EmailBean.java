package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.service.CustServiceEmailer;
import edu.wctc.distjava.redproject.service.IEmailer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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
    IEmailer emailer;
    
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
    
    public String sendMail(){
        String destination = "index";
        
        emailer = new CustServiceEmailer();
        try{
            emailer.emailMessage(this.message, this.subject);
        } catch (Exception e){
            destination = "policies";
        }
        
        return destination;        
    }
    
    /* validation for drop down menu in customer_service page.  If a subject
     * hasn't been chosen, a validation message will appear after the drop
     * down list.
     */
    
    public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
        String choice = value.toString();
        if (choice.equals("Please choose a subject...")){
            FacesMessage invalidMessage = 
                    new FacesMessage("Please choose a subject.",
                    "Subject not chosen");
            throw new ValidatorException(invalidMessage);
        }
	}
}
