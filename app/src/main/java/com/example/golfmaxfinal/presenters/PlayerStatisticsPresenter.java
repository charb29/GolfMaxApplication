package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.PlayerStatisticsContract;
import com.example.golfmaxfinal.models.PlayerStatistics;

public class PlayerStatisticsPresenter implements PlayerStatisticsContract.Presenter {

    private PlayerStatisticsContract.View view;
    private Context context;

    public PlayerStatisticsPresenter(PlayerStatisticsContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
