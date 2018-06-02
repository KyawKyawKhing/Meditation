package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kkk on 5/27/2018.
 */

public class SessionsVO implements MainVO {
    @SerializedName("title")
    private String title;

    @SerializedName("length-in-seconds")
    private long lengthSeconds;

    public String getTitle() {
        return title;
    }

    public long getLengthSeconds() {
        return lengthSeconds;
    }
}
