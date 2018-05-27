package com.aceplus.padc_poc_one.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;


public class MeditateTeachersFragment extends Fragment {


    public MeditateTeachersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meditate_teacher, container, false);
    }

}
