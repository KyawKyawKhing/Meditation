package com.aceplus.padc_poc_one.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.data.vo.SessionsVO;
import com.aceplus.padc_poc_one.viewholder.BaseViewHolder;
import com.aceplus.padc_poc_one.viewholder.SessionViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hakerfaker on 6/1/2018.
 */

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder, SessionsVO> {

    public SessionAdapter(Context context) {
        super(context);
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.sessions_list_item, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String no = (position + 1) + "";
        holder.tvNo.setText(no);
    }
}
