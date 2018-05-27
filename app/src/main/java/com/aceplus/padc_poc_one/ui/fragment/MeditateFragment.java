package com.aceplus.padc_poc_one.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.adapter.ViewpagerAdapter;


public class MeditateFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewpagerAdapter adapter;

    public MeditateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        TabLayout.Tab tab = tabLayout.getTabAt(1); // Count Starts From 0
        tab.select();

        return view;
    }

    public void setupViewPager(ViewPager vp) {
        adapter = new ViewpagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new MeditateTeachersFragment(), "ON THE GO");
        adapter.addFragment(new MeditateSeriesFragment(), "SERIES");
        adapter.addFragment(new MeditateTeachersFragment(), "TEACHERS");
        adapter.notifyDataSetChanged();
        vp.setOffscreenPageLimit(adapter.getCount());
        vp.setAdapter(adapter);

    }

}
