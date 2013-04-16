/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.model.Bid;
import edu.wctc.distjava.redproject.service.IEmailer;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Neal
 */
@Named("endauctionemailbean")
@Scope("request")
public class EndAuctionEmailBean {
    private Bid bid;
    private String name;
    private String subject;
    private String email;
    private String message;
    
 @Autowired
 @Qualifier("auctionWinner")
    private IEmailer emailer;
 
    public EndAuctionEmailBean(){}

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IEmailer getEmailer() {
        return emailer;
    }

    public void setEmailer(IEmailer emailer) {
        this.emailer = emailer;
    }
    
    public void sendEmail(){
        try{
            emailer.sendEmail(email, bid);
        } catch (Exception e){
            throw new RuntimeException("Error delivering auction winner email "
                    + "for item " + bid.getProductId());
        }
    }
}
