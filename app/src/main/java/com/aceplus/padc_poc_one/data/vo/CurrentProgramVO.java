package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkk on 5/19/2018.
 */

public class CurrentProgramVO implements MainVO {

    @SerializedName("title")
    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("background")
    private String background;

    @SerializedName("average-lengths")
    private ArrayList<Integer> averageLengths;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List<SessionsVO> sessionsVOS;

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

    public String getDescription() {
        return description;
    }

    public List<SessionsVO> getSessionsVOS() {
        return sessionsVOS;
    }
}
