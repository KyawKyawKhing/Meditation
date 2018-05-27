package com.aceplus.padc_poc_one;

import android.app.Application;

import com.aceplus.padc_poc_one.data.model.MeditateModel;

/**
 * Created by kkk on 5/26/2018.
 */

public class MeditateApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MeditateModel.getInstance().allDataLoaded();
    }
}
