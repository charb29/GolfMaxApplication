package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.LoginContract;
import com.example.golfmaxfinal.models.User;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private Context context;

    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowData(User user) {
        view.loginUser(user);
    }
}
