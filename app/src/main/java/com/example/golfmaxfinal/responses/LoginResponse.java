package com.example.golfmaxfinal.responses;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class LoginResponse {

    private String username;
    private String password;
    private String email;
    private long id;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long userId) {
        this.id = userId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Login Response (" +
                " username = '" + username + '\'' +
                " password = '" + password + '\'' +
                " email = '" + email + '\'' +
                " user id = '" + id + '\'' +
                ')';
    }
}
