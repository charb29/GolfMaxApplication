package com.example.golfmax.presenters;

import com.example.golfmax.contracts.LoginContract;
import com.example.golfmax.models.User;

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
