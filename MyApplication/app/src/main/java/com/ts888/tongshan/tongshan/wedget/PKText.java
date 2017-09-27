package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
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

public class PKText extends FrameLayout {

    private StokeText text_money, txt_area;
    private TextView mTxt;
    private float dimension;
    private int color;
    private int bg;

    public StokeText getText_money() {
        return text_money;
    }

    public void setText_money(StokeText text_money) {
        this.text_money = text_money;
    }

    public StokeText getTxt_area() {
        return txt_area;
    }

    public void setTxt_area(StokeText txt_area) {
        this.txt_area = txt_area;
    }

    public TextView getmTxt() {
        return mTxt;
    }

    public void setmTxt(TextView mTxt) {
        this.mTxt = mTxt;
    }

    public PKText(Context context) {
        this(context, null);
    }

    public PKText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PKText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PKText);
        dimension = ta.getDimension(R.styleable.PKText_pkTxt_width, 0);
        color = ta.getColor(R.styleable.PKText_pkTxt_color, Color.WHITE);
        bg = ta.getResourceId(R.styleable.PKText_pk_backGroud, R.color.colorBlue);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.wedget_pk, null);
        addView(view);
        text_money = (StokeText) view.findViewById(R.id.wedget_money);
        txt_area = (StokeText) view.findViewById(R.id.wedget_area);
        mTxt = (TextView) view.findViewById(R.id.mTxt_height);
        mTxt.setBackgroundColor(color);
        mTxt.setBackgroundResource(bg);

    }


    public void setTextHeight(int sheetHeight) {

            //动态设置柱体高度
            RelativeLayout.LayoutParams challgedCity = (RelativeLayout.LayoutParams) mTxt.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
            challgedCity.height = sheetHeight;// 控件的宽强制设成
            mTxt.setLayoutParams(challgedCity); //使设置好的布局参数应用到控件
    }
}
