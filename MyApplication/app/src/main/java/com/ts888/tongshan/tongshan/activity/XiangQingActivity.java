package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.fragment.JichuXinXiFragment;
import com.ts888.tongshan.tongshan.fragment.KeHuFragment;
import com.ts888.tongshan.tongshan.fragment.ZhuangTaiFragment;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;

import static android.R.id.list;

public class XiangQingActivity extends AppCompatActivity implements IMainView {

    private Present present;
    private ParmsBean parmsBean;
    private FragmentManager manager;
    private String token;
    private String useC;
    private Fragment lastFragment;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
//        //设置Window为全透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xiang_qing);
        useC = getIntent().getStringExtra("useC");
        token = getIntent().getStringExtra("token");
        manager = getSupportFragmentManager();

        radioGroup = (RadioGroup) findViewById(R.id.RG_xiangqing);
        initFragments();

        manager.beginTransaction().add(R.id.frame_xiangqing, list.get(0)).commit();
        lastFragment = list.get(0);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                Log.i("dd", "onCheckedChanged: "+i);
                RadioButton select = (RadioButton) findViewById(i);

                int index = Integer.parseInt(select.getTag().toString());
                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.frame_xiangqing, list.get(index)).commit();
                }
                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
            }
        });


    }

    private void initFragments() {

        JichuXinXiFragment jichuXinXiFragment = new JichuXinXiFragment();
        Bundle bundle = new Bundle();

        bundle.putString("useC", "TS_20170614103419437225140");
        //bundle.putString("useC", useC);//TODO 替换本来的USECODE需要的
        bundle.putString("token", token);
        jichuXinXiFragment.setArguments(bundle);
        list.add(jichuXinXiFragment);

        ZhuangTaiFragment zhuangTaiFragment = new ZhuangTaiFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("useC", useC);
        bundle2.putString("token", token);
        zhuangTaiFragment.setArguments(bundle2);

        list.add(zhuangTaiFragment);


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

}
