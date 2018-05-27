package com.aceplus.padc_poc_one.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkk on 4/5/2018.
 */
public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public final List<Fragment> fragmentList = new ArrayList<>();
    public final List<String> fragmentStrings = new ArrayList<>();

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentStrings.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentStrings.add(title);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
