package com.yumeng.webapp.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.validator.routines.EmailValidator;



import java.util.Date;


public class User {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String username;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date accountCreated;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date accountUpdated;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public Date getAccountUpdated() {
        return accountUpdated;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean emailValidation() {
        if(this.username == null){
            return true;
        }
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(this.username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }

    public void setAccountUpdated(Date accountUpdated) {
        this.accountUpdated = accountUpdated;
    }
}