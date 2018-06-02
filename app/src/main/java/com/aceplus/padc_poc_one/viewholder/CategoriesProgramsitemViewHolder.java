package com.aceplus.padc_poc_one.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.CategoriesProgramsItemVO;
import com.aceplus.padc_poc_one.delegates.MeditateSeriesDelegate;
import com.bumptech.glide.Glide;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkk on 5/21/2018.
 */

public class CategoriesProgramsitemViewHolder extends BaseViewHolder<CategoriesProgramsItemVO> implements View.OnClickListener {
    @BindView(R.id.iv_main)
    ImageView iv_main;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_time)
    TextView tv_time;

    private int[] photoList = {R.mipmap.rv_hor6, R.mipmap.rv_hor5, R.mipmap.rv_hor2};

    private MeditateSeriesDelegate delegate;
    private CategoriesProgramsItemVO categoriesProgramsItemVO;

    public CategoriesProgramsitemViewHolder(View itemView, MeditateSeriesDelegate delegate) {
        super(itemView);
        this.delegate = delegate;
        itemView.setOnClickListener(this);
    }

    @Override
    public void setData(CategoriesProgramsItemVO data) {
        categoriesProgramsItemVO = data;
        Random random = new Random();
        Context context = itemView.getContext();
//        iv_main.setImageDrawable(context.getResources().getDrawable(data.getBgImage()));
        Glide.with(context).load(photoList[random.nextInt(photoList.length - 1)]).into(iv_main);
//        iv_main.setImageDrawable(context.getResources().getDrawable(photoList[random.nextInt(photoList.length)]));
        tv_name.setText(data.getTitle());
        String time = data.getAverageLengths().get(0) + " mins";
        tv_time.setText(time);
    }

    @Override
    public void onClick(View v) {
        delegate.onTapListItem(categoriesProgramsItemVO);
    }
}