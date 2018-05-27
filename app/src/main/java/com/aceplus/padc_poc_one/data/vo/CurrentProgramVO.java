package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by kkk on 5/19/2018.
 */

public class CurrentProgramVO implements MainVO{

    @SerializedName("title")
    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("background")
    private String background;

    @SerializedName("average-lengths")
    private ArrayList<Integer> averageLengths;

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public ArrayList<Integer> getAverageLengths() {
        return averageLengths;
    }
}
