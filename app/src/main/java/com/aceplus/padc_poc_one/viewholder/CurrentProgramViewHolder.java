package com.aceplus.padc_poc_one.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.CurrentProgramVO;
import com.aceplus.padc_poc_one.data.vo.MainVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkk on 5/19/2018.
 */

public class CurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO> {

    @BindView(R.id.current_cv)
    CardView currentCV;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_start_name)
    TextView tv_name;

    @BindView(R.id.btn_start)
    TextView btn_start;

    @BindView(R.id.tv_start_time)
    TextView tv_time;

    @BindView(R.id.iv_main_bg)
    ImageView iv_main_bg;

    private MeditateSeriesDelegate currentProgramDelegate;

    CurrentProgramVO currentProgramVO;

    public CurrentProgramViewHolder(View itemView, MeditateSeriesDelegate currentProgramDelegate) {
        super(itemView);
        this.currentProgramDelegate = currentProgramDelegate;
    }

    @Override
    public void setData(CurrentProgramVO data) {
        currentProgramVO = data;
        tv_name.setText(data.getTitle());
        btn_start.setText(data.getCurrentPeriod());
        String time = data.getAverageLengths().get(0) + " mins";
        tv_time.setText(time);
//        iv_main_bg.setImageDrawable(itemView.getContext().getResources().getDrawable(data.getMain_bg()));
    }

    @OnClick(R.id.btn_start)
    void onClickPeriod() {
        currentProgramDelegate.onCurrentItemTap();
    }

    @OnClick(R.id.current_cv)
    void onClickCurrentProgram() {
        currentProgramDelegate.onCurrentItemTap();
    }
}
