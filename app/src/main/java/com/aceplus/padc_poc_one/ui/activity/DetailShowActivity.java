package com.aceplus.padc_poc_one.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.adapter.SessionAdapter;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailShowActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.description)
    TextView tvDescription;

    @BindView(R.id.rv_session)
    RecyclerView rvSession;

    SessionAdapter sessionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sessionAdapter = new SessionAdapter(getApplicationContext());
        rvSession.setAdapter(sessionAdapter);
        rvSession.setLayoutManager(new LinearLayoutManager(this));

        Gson gson = new Gson();
        if (getIntent().getStringExtra("vo").equals("current")) {
            CurrentProgramVO currentProgramVO = gson.fromJson(getIntent().getStringExtra("detailVO"), CurrentProgramVO.class);
            getSupportActionBar().setTitle(currentProgramVO.getTitle());
            tvDescription.setText(currentProgramVO.getDescription());
            sessionAdapter.setNewData(currentProgramVO.getSessionsVOS());
            Log.e("current ", currentProgramVO.getDescription());
        } else if (getIntent().getStringExtra("vo").equals("categories")) {
            CategoriesProgramsItemVO categoriesProgramsItemVO = gson.fromJson(getIntent().getStringExtra("detailVO"), CategoriesProgramsItemVO.class);
            Log.e("categories", categoriesProgramsItemVO.getDescription());
            getSupportActionBar().setTitle(categoriesProgramsItemVO.getTitle());
            tvDescription.setText(categoriesProgramsItemVO.getDescription());
            sessionAdapter.setNewData(categoriesProgramsItemVO.getSessionsVOS());
        } else Log.e("nothing", "don't get");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }
}
