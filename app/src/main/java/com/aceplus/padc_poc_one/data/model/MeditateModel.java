package com.aceplus.padc_poc_one.data.model;

import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.events.RestApiEvents;
import com.aceplus.padc_poc_one.network.MeditateDataAgentImpl;
import com.aceplus.padc_poc_one.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkk on 5/26/2018.
 */

public class MeditateModel {

    private static MeditateModel INSTANCE;
    private List<MainVO> mainVOList;
    private int pageIndex = 1;


    private MeditateModel() {
        EventBus.getDefault().register(this);
        mainVOList = new ArrayList<>();
    }

    public static MeditateModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MeditateModel();
        }
        return INSTANCE;
    }

    public void allDataLoaded() {
        MeditateDataAgentImpl.getInstance().loadCurrentProgram(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramLoaded(RestApiEvents.CurrentProgramDataLoadedEvent event) {
        mainVOList.add(event.getCurrentProgramVO());
        MeditateDataAgentImpl.getInstance().loadCategoriesPrograms(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesProgramsDataLoaded(RestApiEvents.CategoriesProgramsDataLoadedEvent event) {
        mainVOList.addAll(event.getCategoriesProgramsVOList());
        MeditateDataAgentImpl.getInstance().loadTopics(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicsDataLoaded(RestApiEvents.TopicsDataLoadedEvent event) {
        mainVOList.addAll(event.getTopicVOList());
        RestApiEvents.AllDataLoadedEvent allDataLoadedEvent = new RestApiEvents.AllDataLoadedEvent(mainVOList);
        EventBus.getDefault().post(allDataLoadedEvent);
    }

    public List<MainVO> getMainVOList() {
        if (mainVOList.isEmpty()) {
            mainVOList = new ArrayList<>();
        }
        return mainVOList;
    }
}
