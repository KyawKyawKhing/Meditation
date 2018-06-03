package com.aceplus.padc_poc_one.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.aceplus.padc_poc_one.ui.fragment.MeditateFragment;
import com.aceplus.padc_poc_one.ui.fragment.MeditateSeriesFragment;
import com.aceplus.padc_poc_one.ui.fragment.MeFragment;
import com.aceplus.padc_poc_one.ui.fragment.MeditateTeachersFragment;
import com.google.gson.Gson;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements MeditateSeriesDelegate {

    Toolbar toolbar;
    private static BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        MainActivity.BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        displayView(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_meditate:
                    displayView(1);
                    return true;
                case R.id.navigation_me:
                    displayView(2);
                    return true;
                case R.id.navigation_more:
                    displayView(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onCurrentItemTap() {
        Intent intent = DetailShowActivity.newIntentCurrentProgram(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onListItemTap(String categoryId, String categoryItemId) {
        Intent intent = DetailShowActivity.newIntentProgramInCategoryId(getApplicationContext(), categoryId, categoryItemId);
        startActivity(intent);
    }


    public static class BottomNavigationViewHelper {

        @SuppressLint("RestrictedApi")
        static void removeShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //noinspection RestrictedApi
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    //noinspection RestrictedApi
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BottomNav", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e) {
                Log.e("BottomNav", "Unable to change value of shift mode", e);
            }
        }
    }

    private void displayView(Integer i) {
        Fragment fragment = null;
        String title = "";
        switch (i) {
            case 1:
                fragment = new MeditateFragment();
                title = "Meditate";
                break;
            case 2:
                fragment = new MeFragment();
                title = "Me";
                break;
            case 3:
                fragment = new MeditateTeachersFragment();
                title = "More";
                break;
        }
        if (fragment != null) {
            getSupportActionBar().setTitle(title);
            getSupportFragmentManager().beginTransaction().replace(R.id.mainTabframe, fragment).commit();

        }
    }

    public static void setTab(int menu_id) {
        navigation.setSelectedItemId(menu_id);
    }
}
