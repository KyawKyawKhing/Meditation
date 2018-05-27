package com.aceplus.padc_poc_one.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * Created by kkk on 5/25/2018.
 */

public class ProgressCCV extends RelativeLayout {
    public ProgressCCV(Context context) {
        super(context);
    }

    public ProgressCCV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressCCV(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
