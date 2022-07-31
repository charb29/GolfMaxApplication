package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.ScoreContract;
import com.example.golfmaxfinal.models.Score;

public class ScorePresenter implements ScoreContract.Presenter {

    private ScoreContract.View view;
    private Context context;

    public ScorePresenter(ScoreContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowUserScore(Score userScore) {
        view.showUserScore(userScore);
    }

    @Override
    public void onShowGuest1Score(Score guest1Score) { view.showGuest1Score(guest1Score);}

    public void onShowGuest2Score(Score guest2Score) { view.showGuest2Score(guest2Score);}

    public void onShowGuest3Score(Score guest3Score) { view.showGuest3Score(guest3Score);}
}
