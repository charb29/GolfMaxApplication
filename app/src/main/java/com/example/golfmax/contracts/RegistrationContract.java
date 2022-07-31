package com.example.golfmax.contracts;

import com.example.golfmax.models.User;

public interface RegistrationContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void registerUser(User user);
    }
}