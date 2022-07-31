package com.example.golfmax.presenters;

import android.content.Context;

import com.example.golfmax.contracts.PlayerStatisticsContract;

public class PlayerStatisticsPresenter implements PlayerStatisticsContract.Presenter {

    private PlayerStatisticsContract.View view;
    private Context context;

    public PlayerStatisticsPresenter(PlayerStatisticsContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
