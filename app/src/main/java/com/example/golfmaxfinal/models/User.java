package com.example.golfmaxfinal.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmaxfinal.BR;

public class User extends BaseObservable {

    private long id;
    private String username;
    private String password;
    private String email;

    public User() {}

    public User(long id, String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User Info (" +
                " username = '" + username + '\'' +
                " password = '" + password + '\'' +
                " email = '" + email + '\'' +
                " id = '" + id + '\'' +
                ')';
    }
}
