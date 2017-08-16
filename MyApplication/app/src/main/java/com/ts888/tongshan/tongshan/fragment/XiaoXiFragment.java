package com.ts888.tongshan.tongshan.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.wedget.MyPaintView;


/**
 * Created by dongdong on 2017/7/30.
 */

public class XiaoXiFragment extends Fragment {
    private MyPaintView mpv;
    private Button mBtn_clear,mBtn_changeColor;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xiaoxi,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mpv = (MyPaintView) view.findViewById(R.id.paintView);
        mBtn_changeColor = (Button) view.findViewById(R.id.paint_color);
        mBtn_clear = (Button) view.findViewById(R.id.paint_clear);
        textView = (TextView) view.findViewById(R.id.paint_title);

        textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"wawa.TTF"));
        mBtn_changeColor.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"wawa.TTF"));
        mBtn_clear.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"wawa.TTF"));


        mBtn_clear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mpv.clear();
                return false;
            }
        });

        mBtn_changeColor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mpv.changeColor();
                return false;
            }
        });






    }
}
