package com.example.golfmaxfinal.requests;

import androidx.annotation.NonNull;

public class RegistrationRequest {

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
        return "Registration Request (" +
                " username = '" + username + '\'' +
                " password = '" + password + '\'' +
                " email = '" + email + '\'' +
                ')';
    }
}
