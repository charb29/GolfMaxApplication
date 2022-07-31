package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.Score;

public interface ScoreContract {

    interface Presenter {
        void onShowUserScore(Score userScore);
        void onShowGuest1Score(Score guest1Score);
        void onShowGuest2Score(Score guest2Score);
        void onShowGuest3Score(Score guest3Score);
    }

    interface View {
        void showUserScore(Score userScore);
        void showGuest1Score(Score guest1Score);
        void showGuest2Score(Score guest2Score);
        void showGuest3Score(Score guest3Score);
    }
}
