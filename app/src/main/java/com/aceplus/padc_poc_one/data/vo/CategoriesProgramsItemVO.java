package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by kkk on 5/17/2018.
 */

public class CategoriesProgramsItemVO {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

    @SerializedName("description")
    private String description;

    @SerializedName("sessions")
    private List<SessionsVO> sessionsVOS;


    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionsVO> getSessionsVOS() {
        return sessionsVOS;
    }
}
