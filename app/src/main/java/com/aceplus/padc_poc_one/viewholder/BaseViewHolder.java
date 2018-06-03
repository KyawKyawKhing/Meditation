package com.aceplus.padc_poc_one.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by kkk on 5/19/2018.
 */

public abstract class BaseViewHolder<I> extends RecyclerView.ViewHolder {

    BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void setData(I data);

}
