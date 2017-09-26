package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/9/26.
 */

public class PKText extends FrameLayout {

    public PKText(Context context) {
        this(context,null);
    }

    public PKText(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PKText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

    }
}
