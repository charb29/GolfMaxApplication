package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.User;

public interface RegistrationContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void registerUser(User user);
    }
}