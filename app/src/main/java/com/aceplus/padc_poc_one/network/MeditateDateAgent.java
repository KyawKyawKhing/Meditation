package com.aceplus.padc_poc_one.network;

/**
 * Created by kkk on 5/26/2018.
 */

public interface MeditateDateAgent {

    void loadCurrentProgram(int pageNo, String accessToken);

    void loadCategoriesPrograms(int pageNo, String accessToken);

    void loadTopics(int pageNo, String accessToken);

}
