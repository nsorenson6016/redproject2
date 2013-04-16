/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import edu.wctc.distjava.redproject.model.Bid;
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
 * @author Neal
 */
@Service("endAuctionEmailer")
@Qualifier("auctionWinner")
public class EndAuctionEmailer implements IEmailer, Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private MailSender sender;
    
    @Autowired
    private SimpleMailMessage messageTemplate;
    
    private Bid bid;
    
    @Override
    public void sendEmail(String userEmail, Object data)throws MailException{
        bid = (Bid) data;
        
        String message = ("Congratulations!  You are the winner of a bit " +
                "AWEctions item! \n\nDetails:\n" +
                "\t" + "Product ID:  " + bid.getProductId() + "\n" +
                "\t" + "Amount:  " + bid.getAmount()+ "\n" +
                "\t" + "Username:  " + bid.getBidderUsername().getUsername() + "\n\n" +
                "Please contact the item donator to discuss payment/shipment arragement."
                );

        SimpleMailMessage emailMsg = new SimpleMailMessage(this.messageTemplate);
        String subject = data.toString();
        emailMsg.setTo(userEmail);
        emailMsg.setSubject("bitAWEctions item winner");
        emailMsg.setText(message);
        try {
            sender.send(emailMsg);
        } catch (NullPointerException npe) {
            throw new MailSendException("Email verification error");
            }
        }
    
    @Override
    public void emailHQ (String userName, String email, String subject, String message){}

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
    
    
}
