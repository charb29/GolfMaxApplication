package com.example.golfmax.presenters;

import android.content.Context;

import com.example.golfmax.contracts.UserContract;
import com.example.golfmax.models.User;

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
