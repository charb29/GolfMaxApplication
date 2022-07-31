package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.User;

public interface UserContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void showData(User user);
    }
}
