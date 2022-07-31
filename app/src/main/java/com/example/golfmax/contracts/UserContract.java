package com.example.golfmax.contracts;

import com.example.golfmax.models.User;

public interface UserContract {

    interface Presenter {
        void onShowData(User user);
    }

    interface View {
        void showData(User user);
    }
}
