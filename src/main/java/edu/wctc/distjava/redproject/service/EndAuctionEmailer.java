/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Neal
 */
public class EndAuctionEmailer implements IEmailer, Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private MailSender sender;
    
    @Autowired
    private SimpleMailMessage messageTemplate;
    
    public void emailMessage(String message, Object data)throws MailException{
        
    }
}
