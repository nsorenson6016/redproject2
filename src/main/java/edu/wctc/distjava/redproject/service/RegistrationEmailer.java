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
@Service("registrationEmailer")
@Qualifier("regservice")
public class RegistrationEmailer implements IEmailer, Serializable {

    private static final long serialVersionUID = 1L;
    private final String HQ_EMAIL = "geemaildotcomsucks@gmail.com";
    
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
     *                 data = not needed
     */
    
    @Override
    public void sendEmail(String userEmail, Object data) throws MailException {
        SimpleMailMessage emailMsg = new SimpleMailMessage(this.messageTemplate);
        String subject = "Registration - bitAWEctions";
        String message = ("Thank you for registering at bit AWEctions.  You only"
                + " have one more thing to do.  Please to the following web site:"
                + "\n\n" + data.toString());
        
        emailMsg.setTo(userEmail);
        emailMsg.setSubject(subject);
        emailMsg.setText(message);
        
        try {
            sender.send(emailMsg);
        } catch (NullPointerException npe) {
            throw new MailSendException("Email verification error");
            }
        }

    public void emailHQ(String userName, String userEmail, 
            String subject, String message) {
        String emailMessage = ("User Name:  " + userName
                + "\nReal Name: " + subject
                + "\nUser Email:  " + userEmail);
        SimpleMailMessage emailMsg = new SimpleMailMessage(this.messageTemplate);
        emailMsg.setTo(HQ_EMAIL);
        emailMsg.setSubject("New User:  " + subject);
        emailMsg.setText(emailMessage);
        try{
            sender.send(emailMsg);
        } catch (NullPointerException npe){
            throw new MailSendException("Error sending email to home email.");
        }
    }
}