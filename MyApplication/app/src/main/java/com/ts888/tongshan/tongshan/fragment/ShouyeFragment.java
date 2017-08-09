package com.ts888.tongshan.tongshan.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.ts888.tongshan.tongshan.R;

import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mBtn_chanpin;
import static com.ts888.tongshan.tongshan.R.id.mBtn_shisuan;


/**
 * Created by dongdong on 2017/7/30.
 * 首页Fragment
 *
 */

public class ShouyeFragment extends Fragment {

    private Button mBtn_jinjian,mBtn_kehu,mBtn_shisuan,mBtn_chanpin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtn_kehu = (Button) view.findViewById(R.id.mBtn_kehu);
        mBtn_jinjian = (Button) view.findViewById(R.id.mBtn_jinjian);
        mBtn_shisuan = (Button) view.findViewById(R.id.mBtn_shisuan);
        mBtn_chanpin = (Button) view.findViewById(R.id.mBtn_chanpin);

        mBtn_kehu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("kehu");
            }
        });

        mBtn_jinjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("jinjian");
            }
        });

        mBtn_shisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("shisuan");
            }
        });

        mBtn_chanpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("chanpinzhongxin");
            }
        });
    }





    public interface TextCallBack{
        void getText(String str);
    }

    private TextCallBack callBack;

    public void setCallBack(TextCallBack callBack){
        this.callBack = callBack;
    }





}
