package com.aceplus.padc_poc_one.events;

import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.data.vo.TopicVO;

import java.util.List;

/**
 * Created by kkk on 5/26/2018.
 */

public class RestApiEvents {

    public static class AllDataLoadedEvent {
        private List<MainVO> mainVOList;

        public AllDataLoadedEvent(List<MainVO> mainVOList) {
            this.mainVOList = mainVOList;
        }

        public List<MainVO> getMainVOList() {
            return mainVOList;
        }
    }

    public static class CurrentProgramDataLoadedEvent {
        private CurrentProgramVO currentProgramVO;

        public CurrentProgramDataLoadedEvent(CurrentProgramVO currentProgramVO) {
            this.currentProgramVO = currentProgramVO;
        }

        public CurrentProgramVO getCurrentProgramVO() {
            return currentProgramVO;
        }
    }

    public static class CategoriesProgramsDataLoadedEvent {
        private int loadedPageIndex;
        private List<CategoriesProgramsVO> categoriesProgramsVOList;

        public CategoriesProgramsDataLoadedEvent(int loadedPageIndex, List<CategoriesProgramsVO> categoriesProgramsVOList) {
            this.loadedPageIndex = loadedPageIndex;
            this.categoriesProgramsVOList = categoriesProgramsVOList;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<CategoriesProgramsVO> getCategoriesProgramsVOList() {
            return categoriesProgramsVOList;
        }
    }

    public static class TopicsDataLoadedEvent {
        private int loadedPageIndex;
        private List<TopicVO> topicVOList;

        public TopicsDataLoadedEvent(int loadedPageIndex, List<TopicVO> topicVOList) {
            this.loadedPageIndex = loadedPageIndex;
            this.topicVOList = topicVOList;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicVO> getTopicVOList() {
            return topicVOList;
        }
    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }
}
