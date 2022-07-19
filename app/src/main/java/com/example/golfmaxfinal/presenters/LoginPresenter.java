package com.example.golfmaxfinal.presenters;

import com.example.golfmaxfinal.contracts.LoginContract;
import com.example.golfmaxfinal.models.User;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onShowData(User user) {
        view.loginUser(user);
    }
}
