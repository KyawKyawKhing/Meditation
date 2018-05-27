package com.aceplus.padc_poc_one.network.reponses;

import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kkk on 5/26/2018.
 */

public class GetCurrentProgramResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgram;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
