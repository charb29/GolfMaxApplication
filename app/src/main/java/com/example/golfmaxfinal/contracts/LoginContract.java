package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.User;

public interface LoginContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void loginUser(User user);
    }
}
