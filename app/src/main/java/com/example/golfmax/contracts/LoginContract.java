package com.example.golfmax.contracts;

import com.example.golfmax.models.User;

public interface LoginContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void loginUser(User user);
    }
}
