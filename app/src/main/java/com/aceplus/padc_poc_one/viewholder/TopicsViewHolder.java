package com.aceplus.padc_poc_one.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.TopicVO;
import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkk on 5/19/2018.
 */

public class TopicsViewHolder extends BaseViewHolder<TopicVO> {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_desp)
    TextView tv_desp;
    @BindView(R.id.iv_main_bg)
    ImageView iv_bg;
    @BindView(R.id.iv_content)
    ImageView iv_item;

    private int[] photoList = {R.mipmap.rv_ver_land8, R.mipmap.rv_ver_land6, R.mipmap.rv_ver_land4};

    public TopicsViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(TopicVO data) {
        Random random = new Random();
        Context context = this.itemView.getContext();
        tv_title.setText(data.getTopicName());
        tv_desp.setText(data.getTopicDesc());
        Glide.with(context).load(photoList[random.nextInt(photoList.length - 1)]).into(iv_bg);
//        iv_bg.setImageDrawable(context.getResources().getDrawable(photoList[random.nextInt(photoList.length - 1)]));
    }
}
