package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.RegistrationContract;
import com.example.golfmaxfinal.models.User;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private RegistrationContract.View view;
    private Context context;

    public RegistrationPresenter(RegistrationContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowData(User user) {
        view.registerUser(user);
    }
}
