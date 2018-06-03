package com.aceplus.padc_poc_one.data.model;

import android.util.Log;

import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.data.vo.SingleVO;
import com.aceplus.padc_poc_one.events.RestApiEvents;
import com.aceplus.padc_poc_one.network.MeditateDataAgentImpl;
import com.aceplus.padc_poc_one.network.MeditateDateAgent;
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
    private MeditateDateAgent meditateDateAgent;


    private MeditateModel() {
        EventBus.getDefault().register(this);
        mainVOList = new ArrayList<>();
        meditateDateAgent = MeditateDataAgentImpl.getInstance();
    }

    public static MeditateModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MeditateModel();
        }
        return INSTANCE;
    }

    public void allDataLoaded() {
        meditateDateAgent.loadCurrentProgram(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramLoaded(RestApiEvents.CurrentProgramDataLoadedEvent event) {
        mainVOList.add(event.getCurrentProgramVO());
        Log.e("mainvo list size", mainVOList.size() + "");
        MeditateDataAgentImpl.getInstance().loadCategoriesPrograms(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesProgramsDataLoaded(RestApiEvents.CategoriesProgramsDataLoadedEvent event) {
        mainVOList.addAll(event.getCategoriesProgramsVOList());
        Log.e("mainvo list size", mainVOList.size() + "");
        mainVOList.add(new SingleVO("All Topics"));
        Log.e("mainvo list size", mainVOList.size() + "");
        MeditateDataAgentImpl.getInstance().loadTopics(pageIndex, AppConstants.ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicsDataLoaded(RestApiEvents.TopicsDataLoadedEvent event) {
        mainVOList.addAll(event.getTopicVOList());
        Log.e("mainvo list size", mainVOList.size() + "");
        RestApiEvents.AllDataLoadedEvent allDataLoadedEvent = new RestApiEvents.AllDataLoadedEvent(mainVOList);
        EventBus.getDefault().post(allDataLoadedEvent);
    }

    public List<MainVO> getMainVOList() {
        if (mainVOList.isEmpty()) {
            mainVOList = new ArrayList<>();
        }
        return mainVOList;
    }

    public CurrentProgramVO getCurrentProgramVO() {
        for (MainVO mainVO : mainVOList) {
            if (mainVO instanceof CurrentProgramVO) {
                return (CurrentProgramVO) mainVO;
            }
        }
        return null;
    }

    public CategoriesProgramsItemVO getCategoriesProgramsItemVO(String categoryId, String categoryItemId) {
        for (MainVO mainVO : mainVOList) {
            if (mainVO instanceof CategoriesProgramsVO) {
                if (((CategoriesProgramsVO) mainVO).getCategoryId().equals(categoryId)) {
                    for (CategoriesProgramsItemVO categoriesProgramsItemVO : ((CategoriesProgramsVO) mainVO).getCategoriesProgramsItemVOS()) {
                        if (categoriesProgramsItemVO.getProgramId().equals(categoryItemId)) {
                            return categoriesProgramsItemVO;
                        }
                    }
                }
            }
        }
        return null;
    }
}
