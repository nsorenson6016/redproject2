/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.service;

import org.springframework.mail.MailException;
/**
 *
 * @author Neal
 */
public interface IEmailer {
    void emailMessage(String message, Object data) throws MailException;
}