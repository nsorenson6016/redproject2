/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Users;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface IUserRegistrationEAO {
    public abstract void createNewUser(Users user);
    public abstract String isUsernameInUse(String username);
}