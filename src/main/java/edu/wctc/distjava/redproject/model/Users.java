package edu.wctc.distjava.redproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author scottodya
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled"),
    @NamedQuery(name = "Users.findByAddress1", query = "SELECT u FROM Users u WHERE u.address1 = :address1"),
    @NamedQuery(name = "Users.findByAddress2", query = "SELECT u FROM Users u WHERE u.address2 = :address2"),
    @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city"),
    @NamedQuery(name = "Users.findByState", query = "SELECT u FROM Users u WHERE u.state = :state"),
    @NamedQuery(name = "Users.findByZip", query = "SELECT u FROM Users u WHERE u.zip = :zip"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByActiveDate", query = "SELECT u FROM Users u WHERE u.activeDate = :activeDate")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
//    private boolean enabled;
    private int enabled;
    @Size(max = 80)
    @Column(name = "address1")
    private String address1;
    @Size(max = 45)
    @Column(name = "address2")
    private String address2;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 4)
    @Column(name = "state")
    private String state;
    @Size(max = 10)
    @Column(name = "zip")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "email")
    private String email;
    @Column(name = "active_date")
    @Temporal(TemporalType.DATE)
    private Date activeDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username", fetch=FetchType.EAGER, orphanRemoval=true)
    private Collection<Authorities> authoritiesCollection;
    @OneToMany(mappedBy = "donatingUsername")
    private Collection<Product> productCollection;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        if (enabled) {this.enabled = 1;}
            else {this.enabled = 0;}
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        if (enabled==1) return true;
        else return false;
    }

    public void setEnabled(boolean enabled) {
        if (enabled) {this.enabled = 1;}
            else {this.enabled = 0;}
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Collection<Authorities> getAuthoritiesCollection() {
        return authoritiesCollection;
    }

    public void setAuthoritiesCollection(Collection<Authorities> authoritiesCollection) {
        this.authoritiesCollection = authoritiesCollection;
    }

    /*
     * gets all of the Authorities that a user has in the form of a list of strings.
     * used by users.xhtml
     */
    public List<String> getAuthorities() {
        List<String> authList = new ArrayList <String>();
        for (Authorities a:authoritiesCollection){
            authList.add(a.toString());
        }
        return authList;
    }
    
    /*
     * sets the authorities collection if a list of strings is entered.
     * used by users.xhtml
    */
    public void setAuthorities(List<String> authList){
        List<Authorities> auths = new ArrayList<Authorities>();
        Authorities auth = new Authorities();
        for (String s:authList){
            auth.setAuthority(s);
        }
        auths.add(auth);
        authoritiesCollection = auths;
    }
   

    @XmlTransient
//    public Collection<Product> getProductCollection() {
//        return productCollection;
//    }
//
//    public void setProductCollection(Collection<Product> productCollection) {
//        this.productCollection = productCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    // toString - method to return User as a string.  Used by the email sent to HQ.
    @Override
    public String toString() {
        // if there is nothing entered in the Address 2 box, the full address is Address 1 only.
        String fullAddress = "";
        if (address2==null || address2.equals("")){
            fullAddress += address1;
        }
        else {
            fullAddress += address1 + "\n" + address2;
        }
        
        // returns username, full name, address, phone & email
        return username + "\n\n"
                + "Name: " + firstName + " " + lastName + "\n"
                + "Address: " + fullAddress + "\n"
                + "         " + city + ", " + state + "  " + zip + "\n"
                + "Phone: " + phone+ "\n\n"
                + email;
    }
    
} 