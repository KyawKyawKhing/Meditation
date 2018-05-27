package com.aceplus.padc_poc_one.data.vo;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by kkk on 5/19/2018.
 */

public class CategoriesProgramsVO implements MainVO {

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private ArrayList<CategoriesProgramsItemVO> categoriesProgramsItemVOS;

    public String getTitle() {
        return title;
    }

    public ArrayList<CategoriesProgramsItemVO> getCategoriesProgramsItemVOS() {
        return categoriesProgramsItemVOS;
    }
}
