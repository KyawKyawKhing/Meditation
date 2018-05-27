package com.aceplus.padc_poc_one.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.adapter.RecyclerViewAdapter;
import com.aceplus.padc_poc_one.data.model.MeditateModel;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.aceplus.padc_poc_one.events.RestApiEvents;
import com.aceplus.padc_poc_one.ui.activity.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MeditateSeriesFragment extends Fragment implements MeditateSeriesDelegate {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    public MeditateSeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meditate_series, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(getContext(), this);
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

    @Override
    public void onTapPeriod() {
        MainActivity.setTab(R.id.navigation_me);
    }
}
