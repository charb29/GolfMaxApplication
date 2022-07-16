package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.User;

public interface LoginContract {

    public interface Presenter {
        void onShowData(User user);
    }

    public interface View {
        void loginUser(User user);
    }
}
