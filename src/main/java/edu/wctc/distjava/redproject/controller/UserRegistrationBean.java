/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.service.UserRegistrationService;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Owner@
 */
@Named
@Scope("request")
public class UserRegistrationBean implements Serializable{
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmation;
    private String phoneNum;
    private String address;
    private String addressTwo;
    private String city;
    private String state;
    private String zipCode;
    private String userMessage = "";
    private String successMessage;
    @Inject
    private UserRegistrationService urService;
    
    public String isUsernameInUse() {
        
        
        userMessage = null; //urService.isUsernameInUse(username);
        
        return userMessage;
        
  }
    
    public String createNewUser (){
        return successMessage;
    }

    
    //GETTERS & SETTERS
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }


    public UserRegistrationService getUrService() {
        return urService;
    }

    public void setUrService(UserRegistrationService urService) {
        this.urService = urService;
    }

    
    
}
