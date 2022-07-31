package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.UserContract;
import com.example.golfmaxfinal.models.User;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;
    private Context context;

    public UserPresenter(UserContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowData(User user) {
        view.showData(user);
    }
}
