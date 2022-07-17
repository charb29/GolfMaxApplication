package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.PlayerStatistics;

public interface PlayerStatisticsContract {

    public interface Presenter {
        void onShowData(PlayerStatistics playerStatistics);
    }

    public interface View {
        void showData(PlayerStatistics playerStatistics);
    }
}
