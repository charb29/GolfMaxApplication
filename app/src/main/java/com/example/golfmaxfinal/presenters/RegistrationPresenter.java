package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.RegistrationContract;
import com.example.golfmaxfinal.models.User;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private final RegistrationContract.View view;

    public RegistrationPresenter(RegistrationContract.View view) {
        this.view = view;
    }

    @Override
    public void onShowData(User user) {
        view.registerUser(user);
    }
}
