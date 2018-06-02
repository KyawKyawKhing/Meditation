package com.aceplus.padc_poc_one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkk on 5/24/2018.
 */

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder, W> extends RecyclerView.Adapter<T> {

    protected List<W> mData;
    protected LayoutInflater mLayoutInflator;

    public BaseRecyclerAdapter(Context context) {
        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> newData) {
        mData = newData;
        notifyDataSetChanged();
    }
}
