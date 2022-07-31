package com.example.golfmax.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmax.BR;
import com.google.gson.annotations.SerializedName;

public class User extends BaseObservable {

    private long id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
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

    public String toStringUsername() {
        return "User (" +
                " Username = '" + username + '\'' +
                ')';
    }

    public String toStringPassword() {
        return "User (" +
                " Password = '" + password + '\'' +
                ')';
    }

    public String toStringEmail() {
        return "User (" +
                " Email = '" + email + '\'' +
                ')';
    }

}
