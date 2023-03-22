package com.cognixia.jump.model;

import java.io.Serializable;

// model object used to send in the username and password for a user when they want to authenticate
// and create a token
public class AuthenticationRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public AuthenticationRequest(){

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    
}
