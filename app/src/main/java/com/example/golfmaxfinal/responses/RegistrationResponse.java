package com.example.golfmaxfinal.responses;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {

    private String username;
    private String email;
    private String password;
    private long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Login Response (" +
                " username = '" + username + '\'' +
                " password = '" + password + '\'' +
                " email = '" + email + '\'' +
                " user id = '" + userId + '\'' +
                ')';
    }
}
