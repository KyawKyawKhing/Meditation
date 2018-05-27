package com.aceplus.padc_poc_one.network;

import android.util.Log;

import com.aceplus.padc_poc_one.events.RestApiEvents;
import com.aceplus.padc_poc_one.network.reponses.GetCategoriesProgramsResponse;
import com.aceplus.padc_poc_one.network.reponses.GetCurrentProgramResponse;
import com.aceplus.padc_poc_one.network.reponses.GetTopicsResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kkk on 5/26/2018.
 */

public class MeditateDataAgentImpl implements MeditateDateAgent {
    private static MeditateDataAgentImpl objInstance;

    private MeditateAPI meditateAPI;

    private MeditateDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        meditateAPI = retrofit.create(MeditateAPI.class);

    }

    public static MeditateDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new MeditateDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadCurrentProgram(int pageNo, String accessToken) {
        Call<GetCurrentProgramResponse> loadCurrentProgramCall = meditateAPI.getCurrentProgram(pageNo, accessToken);
        loadCurrentProgramCall.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                Log.e("Response current", response.body().toString());
                if (response.code() == 200) {
                    GetCurrentProgramResponse getCurrentProgramResponse = response.body();
                    if (getCurrentProgramResponse != null) {
                        RestApiEvents.CurrentProgramDataLoadedEvent currentProgramDataLoadedEvent = new RestApiEvents.CurrentProgramDataLoadedEvent(
                                getCurrentProgramResponse.getCurrentProgram());
                        EventBus.getDefault().post(currentProgramDataLoadedEvent);
                    } else {
                        RestApiEvents.ErrorInvokingAPIEvent errorEvent
                                = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadCategoriesPrograms(int pageNo, String accessToken) {
        Call<GetCategoriesProgramsResponse> loadCategoriesProgramsCall = meditateAPI.getCategoriesPrograms(pageNo, accessToken);
        loadCategoriesProgramsCall.enqueue(new Callback<GetCategoriesProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesProgramsResponse> call, Response<GetCategoriesProgramsResponse> response) {
                Log.e("Response categories", response.body().toString());
                if (response.code() == 200) {
                    GetCategoriesProgramsResponse getCategoriesProgramsResponse = response.body();
                    if (getCategoriesProgramsResponse != null && getCategoriesProgramsResponse.getCategoriesPrograms().size() > 0) {
                        Log.e("Sent Programs size", getCategoriesProgramsResponse.getCategoriesPrograms().size() + "");
                        RestApiEvents.CategoriesProgramsDataLoadedEvent categoriesProgramsDataLoadedEvent = new RestApiEvents.CategoriesProgramsDataLoadedEvent(
                                getCategoriesProgramsResponse.getPage(), getCategoriesProgramsResponse.getCategoriesPrograms());
                        EventBus.getDefault().post(categoriesProgramsDataLoadedEvent);
                    } else {
                        RestApiEvents.ErrorInvokingAPIEvent errorEvent
                                = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesProgramsResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadTopics(int pageNo, String accessToken) {
        Call<GetTopicsResponse> loadTopicsCall = meditateAPI.getTopics(pageNo, accessToken);
        loadTopicsCall.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                Log.e("Response topics", response.body().toString());
                if (response.code() == 200) {
                    GetTopicsResponse getTopicsResponse = response.body();
                    if (getTopicsResponse != null && getTopicsResponse.getTopics().size() > 0) {
                        Log.e("Sent topics size", getTopicsResponse.getTopics().size() + "");
                        RestApiEvents.TopicsDataLoadedEvent topicsDataLoadedEvent = new RestApiEvents.TopicsDataLoadedEvent(
                                getTopicsResponse.getPage(), getTopicsResponse.getTopics());
                        EventBus.getDefault().post(topicsDataLoadedEvent);
                    } else {
                        RestApiEvents.ErrorInvokingAPIEvent errorEvent
                                = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }


}
