package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kkk on 5/19/2018.
 */

public class TopicVO implements MainVO{

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("icon")
    private String icon;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }
}
