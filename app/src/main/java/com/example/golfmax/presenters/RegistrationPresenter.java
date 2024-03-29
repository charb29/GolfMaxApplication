package com.example.golfmax.presenters;

import com.example.golfmax.contracts.RegistrationContract;
import com.example.golfmax.models.User;

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
