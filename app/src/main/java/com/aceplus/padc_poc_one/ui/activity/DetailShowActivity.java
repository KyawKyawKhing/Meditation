package com.aceplus.padc_poc_one.ui.activity;

import android.content.Context;
import android.content.Intent;
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
import com.aceplus.padc_poc_one.data.model.MeditateModel;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
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

    @BindView(R.id.session_title)
    TextView sessionTitle;

    SessionAdapter sessionAdapter;
    MeditateModel meditateModel;

    private static String IE_VO = "vo";
    private static String IE_CATEGORY_ID = "categoryId";
    private static String IE_CATEGORY_ITEM_ID = "categoryItemId";
    private static String IE_CURRENT_VO = "currentVO";
    private static String IE_CATEGORY_VO = "categoriesVO";

    public static Intent newIntentCurrentProgram(Context context) {
        Intent intent = new Intent(context, DetailShowActivity.class);
        intent.putExtra(IE_VO, IE_CURRENT_VO);
        return intent;
    }

    public static Intent newIntentProgramInCategoryId(Context context, String categoryId, String categoryItemId) {
        Intent intent = new Intent(context, DetailShowActivity.class);
        intent.putExtra(IE_VO, IE_CATEGORY_VO);
        intent.putExtra(IE_CATEGORY_ID, categoryId);
        intent.putExtra(IE_CATEGORY_ITEM_ID, categoryItemId);
        return intent;
    }

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

        meditateModel = MeditateModel.getInstance();

        if (getIntent().getStringExtra(IE_VO).equals(IE_CATEGORY_VO)) {
            String categoryId = getIntent().getStringExtra(IE_CATEGORY_ID);
            String categoryItemId = getIntent().getStringExtra(IE_CATEGORY_ITEM_ID);
            CategoriesProgramsItemVO programsItemVO = meditateModel.getCategoriesProgramsItemVO(categoryId, categoryItemId);
            getSupportActionBar().setTitle(programsItemVO.getTitle());
            tvDescription.setText(programsItemVO.getDescription());
            sessionAdapter.setNewData(programsItemVO.getSessionsVOS());
            if (sessionAdapter.getItemCount() == 0) {
                sessionTitle.setVisibility(View.GONE);
            }
        } else if (getIntent().getStringExtra(IE_VO).equals(IE_CURRENT_VO)) {
            CurrentProgramVO currentProgramVO = meditateModel.getCurrentProgramVO();
            getSupportActionBar().setTitle(currentProgramVO.getTitle());
            tvDescription.setText(currentProgramVO.getDescription());
            if (sessionAdapter.getItemCount() == 0) {
                sessionTitle.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }
}
