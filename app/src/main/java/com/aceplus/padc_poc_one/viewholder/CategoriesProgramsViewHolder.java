package com.aceplus.padc_poc_one.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.adapter.RecyclerListitemAdapter;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkk on 5/19/2018.
 */

public class CategoriesProgramsViewHolder extends BaseViewHolder<CategoriesProgramsVO> {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.recyclerView_Horizontal)
    RecyclerView recyclerView;
    RecyclerListitemAdapter adapter;

    private MeditateSeriesDelegate delegate;

    public CategoriesProgramsViewHolder(View itemView, MeditateSeriesDelegate delegate) {
        super(itemView);
        this.delegate = delegate;
        adapter = new RecyclerListitemAdapter(itemView.getContext(), delegate);
    }

    @Override
    public void setData(CategoriesProgramsVO data) {
        tv_title.setText(data.getTitle());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter.setNewData(data.getCategoriesProgramsItemVOS());
        adapter.setCategory(data);
    }

}
