package com.aceplus.padc_poc_one.viewholder;

import android.view.View;
import android.widget.TextView;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.SessionsVO;

import butterknife.BindView;

/**
 * Created by kkk on 5/27/2018.
 */

public class SessionViewHolder extends BaseViewHolder<SessionsVO> {

    @BindView(R.id.tv_no)
    public TextView tvNo;

    @BindView(R.id.tv_session_title)
    TextView tvSessionTitle;

    @BindView(R.id.tv_session_length)
    TextView tvSessionLength;

    public SessionViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SessionsVO data) {
        tvSessionTitle.setText(data.getTitle());
        String min = String.valueOf(data.getLengthSeconds() / 60);
        String sec = String.valueOf(data.getLengthSeconds() % 60);
        String time = min + ":" + sec;
        tvSessionLength.setText(time);
    }
}
