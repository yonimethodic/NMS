package com.epms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Yonatan
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "MiddleName")
    private String middleName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "UserName")
    private String userName;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Email")
    private String email;    
    
    @Column(name = "PhoneNo")
    private String phoneno;    
   
    @Column(name = "IsActive")
    private Boolean isActive;
    
    @Column(name = "GetSMSNotification")
    private Boolean smsNotification;
    
    @Column(name = "GetEMailNotification")
    private Boolean eMailNotification;
    
    @Column(name = "LastLogIn")
    private Date lastLogIn;
    
    @Column(name = "DateCreated")
    private Date dateCreated;
    
    @Column(name = "DateModified")
    private Date dateModified;   
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "UserID")}, inverseJoinColumns = {@JoinColumn(name = "AppRoleID")})
    private Set<AppRole> role = new HashSet<>(0);
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return phoneno;
    }

    public void setPosition(String position) {
        this.phoneno = position;
    }

    
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Boolean getsmsNotification() {
        return smsNotification;
    }
    public void setsmsNotification(Boolean smsNotification) {
        this.smsNotification = smsNotification;
    }
    public Boolean geteMailNotification() {
        return smsNotification;
    }
    public void seteMailNotification(Boolean eMailNotification) {
        this.eMailNotification = eMailNotification;
    }
    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Set<AppRole> getRole() {
        return role;
    }

    public void setRole(Set<AppRole> role) {
        this.role = role;
    }  
}
