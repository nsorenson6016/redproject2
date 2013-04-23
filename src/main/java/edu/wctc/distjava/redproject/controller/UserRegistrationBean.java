/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.eao.IUserRegistrationEAO;
import edu.wctc.distjava.redproject.model.Authorities;
import edu.wctc.distjava.redproject.model.Users;
import edu.wctc.distjava.redproject.service.IEmailer;
import edu.wctc.distjava.redproject.service.UserRegistrationService;
import edu.wctc.distjava.redproject.util.FacesUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 *
 * @author Owner@
 */
@Named
@Scope("request")
public class UserRegistrationBean implements Serializable{
    private String username = "";
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
    private String userCheck = "";
    private String IN_USE = "Username is already in use!";
    @Inject
    private UserRegistrationService urService;
    private Users user;
   
    @Autowired
    @Qualifier("regservice")
    private IEmailer emailer;
    
    public void usernameInUse(ValueChangeEvent event) {
        user = new Users();
        
        user.setUsername(username);
        username = user.getUsername();
        userCheck = urService.isUsernameInUse(username);
        if(userCheck != null){
            FacesUtils.addErrorMessage("Username is already in use!");
        }
        
        
  }
    
    public void passwordsMatch(ValueChangeEvent event) {
//       password = getPassword();
//       confirmation = getConfirmation();
       
       if (password.equals(confirmation)){
           FacesUtils.addErrorMessage("Passwords match.");
       }else{
           FacesUtils.addErrorMessage("Confirmation does not match password.");
       }
        
    }
    
    private String encodeSha512(String pwd, String salt) {
        
        ShaPasswordEncoder pe = new ShaPasswordEncoder(512);
        pe.setIterations(1024);
        String hash = pe.encodePassword(pwd, salt);
        
        return hash;
        
    }
    
    public String createNewUser (){
        user = new Users();
        user.setUsername(username);
        user.setPassword(encodeSha512(password, username));
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress1(address);
        user.setAddress2(address);
        user.setCity(city);
        user.setState(state);
        user.setZip(zipCode);
        user.setEnabled(false);
        List<Authorities> auths = new ArrayList<Authorities>();
        Authorities auth = new Authorities();
        auth.setAuthority("ROLE_MEMBER");
        auths.add(auth);
        user.setAuthoritiesCollection(auths);
        auth.setUsername(user.getUsername());
        String destination = "registrationComplete";
        
        urService.createNewUser( user);
        
        try {
            emailer.sendEmail(email, username);
            emailer.emailHQ(username, email, (firstName + " " + lastName), "");
        } catch (Exception e){
            destination = "emailerror.xhtml";
            System.out.println(e.toString());
        }
        
        return destination;
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

    public UserRegistrationService getUrService() {
        return urService;
    }

    public void setUrService(UserRegistrationService urService) {
        this.urService = urService;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}