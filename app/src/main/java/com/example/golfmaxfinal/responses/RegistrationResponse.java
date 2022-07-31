package com.example.golfmaxfinal.responses;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class RegistrationResponse {

    private String username;
    private String email;
    private String password;

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

    @NonNull
    @Override
    public String toString() {
        return "Login Response (" +
                " username = '" + username + '\'' +
                " password = '" + password + '\'' +
                " email = '" + email + '\'' +
                ')';
    }
}
