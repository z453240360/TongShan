package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.fragment.JichuXinXiFragment;
import com.ts888.tongshan.tongshan.fragment.KeHuFragment;
import com.ts888.tongshan.tongshan.fragment.ZhuangTaiFragment;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

public class XiangQingActivity extends AppCompatActivity implements IMainView{

    private Present present;
    private ParmsBean parmsBean;
    private FragmentManager manager;
    private String token;
    private String useC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xiang_qing);
        useC = getIntent().getStringExtra("useC");
        token = getIntent().getStringExtra("token");
        manager = getSupportFragmentManager();

        JichuXinXiFragment jichuXinXiFragment = new JichuXinXiFragment();
        Bundle bundle = new Bundle();
        bundle.putString("useC",useC);
        bundle.putString("token",token);
        jichuXinXiFragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.frame_xiangqing, jichuXinXiFragment).commit();

    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.mBnt_jichu:

                JichuXinXiFragment jichuXinXiFragment = new JichuXinXiFragment();
                Bundle bundle = new Bundle();
                bundle.putString("useC",useC);
                bundle.putString("token",token);
                jichuXinXiFragment.setArguments(bundle);
                manager.beginTransaction().replace(R.id.frame_xiangqing, jichuXinXiFragment).commit();
                break;

            case R.id.mBnt_jichu2:

                ZhuangTaiFragment zhuangTaiFragment = new ZhuangTaiFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("useC",useC);
                bundle2.putString("token",token);
                zhuangTaiFragment.setArguments(bundle2);
                manager.beginTransaction().replace(R.id.frame_xiangqing, zhuangTaiFragment).commit();
                break;
        }
    }
}
