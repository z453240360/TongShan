package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;

/**
 * Created by Administrator on 2017/9/26.
 */

public class PK_RangeText extends FrameLayout {

    private final int color;
    private TextView mTxt_range,mTxt_rangeName;
    private String num;

    public TextView getmTxt_range() {
        return mTxt_range;
    }

    public void setmTxt_range(TextView mTxt_range) {
        this.mTxt_range = mTxt_range;
    }

    public TextView getmTxt_rangeName() {
        return mTxt_rangeName;
    }

    public void setmTxt_rangeName(TextView mTxt_rangeName) {
        this.mTxt_rangeName = mTxt_rangeName;
    }

    public PK_RangeText(Context context) {
        this(context, null);
    }

    public PK_RangeText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PK_RangeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PK_RangeText);
        color = ta.getColor(R.styleable.PK_RangeText_pkTxt_RangeColor, Color.WHITE);
        num = ta.getString(R.styleable.PK_RangeText_pkTxt_rangeNum);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.wedget_pk_range, null);
        addView(view);
        mTxt_range = (TextView) view.findViewById(R.id.mTxt_numberPK);
        mTxt_rangeName = (TextView) view.findViewById(R.id.mTxt_numberPKName);
        mTxt_range.setText(num);
        mTxt_range.setTextColor(color);
        mTxt_rangeName.setTextColor(color);
        mTxt_range.setTypeface(Typeface.createFromAsset(context.getAssets(),"liti.TTF"));
    }

}
