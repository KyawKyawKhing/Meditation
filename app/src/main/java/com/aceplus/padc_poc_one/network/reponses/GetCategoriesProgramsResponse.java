package com.aceplus.padc_poc_one.network.reponses;

import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kkk on 5/26/2018.
 */

public class GetCategoriesProgramsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("categoriesPrograms")
    private List<CategoriesProgramsVO> categoriesPrograms;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<CategoriesProgramsVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }
}
