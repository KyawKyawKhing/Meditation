package com.aceplus.padc_poc_one.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.aceplus.padc_poc_one.viewholder.CategoriesProgramsitemViewHolder;

/**
 * Created by kkk on 5/18/2018.
 */

public class RecyclerListitemAdapter extends BaseRecyclerAdapter<CategoriesProgramsitemViewHolder, CategoriesProgramsItemVO> {

    private MeditateSeriesDelegate delegate;

    public RecyclerListitemAdapter(Context context, MeditateSeriesDelegate delegate) {
        super(context);
        this.delegate = delegate;
    }

    @Override
    public CategoriesProgramsitemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.recycler_list_item, parent, false);
        return new CategoriesProgramsitemViewHolder(view, delegate);
    }
}
