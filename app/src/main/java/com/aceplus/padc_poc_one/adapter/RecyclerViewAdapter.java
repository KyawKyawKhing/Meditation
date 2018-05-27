package com.aceplus.padc_poc_one.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.aceplus.padc_poc_one.viewholder.BaseViewHolder;
import com.aceplus.padc_poc_one.viewholder.CategoriesProgramsViewHolder;
import com.aceplus.padc_poc_one.viewholder.TopicsViewHolder;
import com.aceplus.padc_poc_one.viewholder.SingleViewHolder;
import com.aceplus.padc_poc_one.viewholder.CurrentProgramViewHolder;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsVO;
import com.aceplus.padc_poc_one.data.vo.TopicVO;
import com.aceplus.padc_poc_one.data.vo.SingleVO;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by kkk on 5/17/2018.
 */

public class RecyclerViewAdapter extends BaseRecyclerAdapter<BaseViewHolder, MainVO> {

    private final int START_HERE_LAYOUT = 0;
    private final int HORIZONTAL_RV_LAYOUT = 1;
    private final int TV_LAYOUT = 2;
    private final int MAIN = 3;

    private MeditateSeriesDelegate meditateSeriesDelegate;

    public RecyclerViewAdapter(Context context, MeditateSeriesDelegate meditateSeriesDelegate) {
        super(context);
        this.meditateSeriesDelegate = meditateSeriesDelegate;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == START_HERE_LAYOUT) {
            View start_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meditation_start, parent, false);
            return new CurrentProgramViewHolder(start_view, meditateSeriesDelegate);
        } else if (viewType == HORIZONTAL_RV_LAYOUT) {
            View horizontal_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
            return new CategoriesProgramsViewHolder(horizontal_view);
        } else if (viewType == TV_LAYOUT) {
            View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_tv, parent, false);
            return new SingleViewHolder(single_view);
        } else {
            View main_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_main_item, parent, false);
            return new TopicsViewHolder(main_view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramVO) {
            return START_HERE_LAYOUT;
        } else if (mData.get(position) instanceof CategoriesProgramsVO) {
            return HORIZONTAL_RV_LAYOUT;
        } else if (mData.get(position) instanceof SingleVO) {
            return TV_LAYOUT;
        } else if (mData.get(position) instanceof TopicVO) {
            return MAIN;
        }
        return -1;
    }

    public void setNewList(List<MainVO> objectArrayList) {
        mData = objectArrayList;
        notifyDataSetChanged();
    }


}
