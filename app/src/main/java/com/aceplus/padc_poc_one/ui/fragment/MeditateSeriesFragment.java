package com.aceplus.padc_poc_one.ui.fragment;


import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.adapter.RecyclerViewAdapter;
import com.aceplus.padc_poc_one.data.model.MeditateModel;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.aceplus.padc_poc_one.events.RestApiEvents;
import com.aceplus.padc_poc_one.ui.activity.DetailShowActivity;
import com.aceplus.padc_poc_one.ui.activity.MainActivity;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MeditateSeriesFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    MeditateSeriesDelegate meditateSeriesDelegate;

    public MeditateSeriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meditate_series, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(getContext(), meditateSeriesDelegate);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        adapter.setNewList(MeditateModel.getInstance().getMainVOList());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAllDataLoaded(RestApiEvents.AllDataLoadedEvent event) {
        adapter.setNewList(event.getMainVOList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorDataLoaded(RestApiEvents.ErrorInvokingAPIEvent event) {
        Toast.makeText(getContext(), event.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MeditateSeriesDelegate) {
            meditateSeriesDelegate = (MeditateSeriesDelegate) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        meditateSeriesDelegate = null;
    }
}
