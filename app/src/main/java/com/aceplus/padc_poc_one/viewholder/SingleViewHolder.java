package com.aceplus.padc_poc_one.viewholder;

import android.view.View;
import android.widget.TextView;

import com.aceplus.padc_poc_one.R;
import com.aceplus.padc_poc_one.data.vo.SingleVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkk on 5/19/2018.
 */

public class SingleViewHolder extends BaseViewHolder<SingleVO> {

    @BindView(R.id.tv_title)
    TextView tv_title;

    public SingleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void setData(SingleVO data) {
        tv_title.setText(data.getTitle());
    }
}
