/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Neal Sorenson
 * @version 1.0
 */

@Service("custServiceEmailer")
@Qualifier("custservice")
public class CustServiceEmailer implements IEmailer, Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private MailSender sender;
    
    @Autowired
    private SimpleMailMessage messageTemplate;

    public MailSender getSender() {
        return sender;
    }

    public void setSender(MailSender sender) {
        this.sender = sender;
    }

    public SimpleMailMessage getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(SimpleMailMessage messageTemplate) {
        this.messageTemplate = messageTemplate;
    }    
    
    /* sendEmail - requires what was entered in the email and subject fields 
     *                of the customer_service page.  Sets the To, Subject and 
     *                message for an email.  Then it sends the email, catching
     *                the NullPointerException.
     * 
     * variables: userEmail = user's email address
     *                 data = data entered in SUBJECT line in cuustomer_service
     *                        page
    */
    @Override
    public void sendEmail(String userEmail, Object data)throws MailException{
        String message = ("Thank you for your inquiry.  We will get back to you"
                + " within 48 hours.");
        
        SimpleMailMessage emailMsg = new SimpleMailMessage(this.messageTemplate);
        String subject = data.toString();
        emailMsg.setTo(userEmail);
        emailMsg.setSubject(subject);
        emailMsg.setText(message);
        try{
            sender.send(emailMsg);
        } catch (NullPointerException npe){
            throw new MailSendException("Email verification error");
    }
}
}