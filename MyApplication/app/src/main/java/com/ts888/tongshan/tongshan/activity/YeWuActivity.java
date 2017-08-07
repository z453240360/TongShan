package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.fragment.GengDuoFragment;
import com.ts888.tongshan.tongshan.fragment.ShouyeFragment;
import com.ts888.tongshan.tongshan.fragment.XiaoXiFragment;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;

public class YeWuActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private String token = null;
    private String TAG = "dd";

    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;
    private RadioGroup mRgMain;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ye_wu);

        toolbar = (Toolbar) findViewById(R.id.toolbars_yewu_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "888888");              //获取存储的token
        Log.i(TAG, "onCreate: "+token);
        init();
    }

    private void init() {

        mRgMain = (RadioGroup) findViewById(R.id.mRg_main);
        manager = getSupportFragmentManager();
        initFragment();
        manager.beginTransaction().add(R.id.mFl_main, list.get(0)).commit();
        lastFragment = list.get(0);
        initRg();

    }

    private void initRg() {
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton select = (RadioButton) findViewById(i);
                int index = Integer.parseInt(select.getTag().toString());

                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.mFl_main, list.get(index)).commit();
                }

                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
            }
        });

    }


    private void initFragment() {

        ShouyeFragment shouyeFragment = new ShouyeFragment();
        XiaoXiFragment xiaoXiFragment = new XiaoXiFragment();
        GengDuoFragment gengDuoFragment = new GengDuoFragment();

        list.add(shouyeFragment);
        list.add(xiaoXiFragment);
        list.add(gengDuoFragment);


        shouyeFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                if (str.equals("jinjian")){
                    startActivity(new Intent(YeWuActivity.this, JinjianActivity.class));
                }else if (str.equals("kehu")){
                    startActivity(new Intent(YeWuActivity.this, KeHuActivity.class));
                }else if (str.equals("shisuan")){
                    startActivity(new Intent(YeWuActivity.this, ShiSuanActivity.class));
                }
            }
        });

        gengDuoFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                if (str.equals("updata"))
                {
                    startActivity(new Intent(YeWuActivity.this, UpdataActivity.class));
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
