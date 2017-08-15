package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;

/**
 * Created by Administrator on 2017/8/15.
 */

public class GeRenWedget extends FrameLayout {


    private View inflate;
    private TextView mTxt_number_wedget,mTxt_danwei_wedget,mTxt_fenlei_wedget;

    public GeRenWedget(Context context) {
        super(context);
        init(context);
    }

    public GeRenWedget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        inflate = LayoutInflater.from(context).inflate(R.layout.wedget_gerenyeji, null);
        addView(inflate);
        mTxt_number_wedget = (TextView) inflate.findViewById(R.id.mTxt_number_wedget);
        mTxt_danwei_wedget = (TextView) inflate.findViewById(R.id.mTxt_danwei_wedget);
        mTxt_fenlei_wedget = (TextView) inflate.findViewById(R.id.mTxt_fenlei_wedget);
    }


    //设置数量
    public void setTextNumber(String s){
        mTxt_number_wedget.setText(s);
    }

    //设置单位
    public void setTextDanwei(String s){
        mTxt_danwei_wedget.setText(s);
    }

    //设置分类
    public void setTextFenLei(String s){
        mTxt_fenlei_wedget.setText(s);
    }


}
