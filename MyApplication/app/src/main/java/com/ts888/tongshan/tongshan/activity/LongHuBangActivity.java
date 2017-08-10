package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.fragment.GengDuoFragment;
import com.ts888.tongshan.tongshan.fragment.LongHuGeRenFragment;
import com.ts888.tongshan.tongshan.fragment.LongHuMenDianFragment;
import com.ts888.tongshan.tongshan.fragment.LongHuTuanDuiFragment;
import com.ts888.tongshan.tongshan.fragment.ShouyeFragment;
import com.ts888.tongshan.tongshan.fragment.XiaoXiFragment;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

public class LongHuBangActivity extends AppCompatActivity {

    @BindView(R.id.mRg_longhu)
    RadioGroup mRgLonghu;
    @BindView(R.id.frame_longhu)
    FrameLayout frameLonghu;

    private Toolbar toolbar;
    private FragmentManager manager;
    private Fragment lastFragment;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏和标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_long_hu_bang);
        ButterKnife.bind(this);

        intiToolBar();

        init();

    }

    private void init() {
        manager = getSupportFragmentManager();
        initFragment();
        manager.beginTransaction().add(R.id.frame_longhu, list.get(0)).commit();
        lastFragment = list.get(0);
        initRg();
    }

    private void intiToolBar() {
        //设置标题栏
        toolbar = (Toolbar) findViewById(R.id.toolbars_longhu);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    private void initFragment() {

        LongHuGeRenFragment geRenFragment = new LongHuGeRenFragment();
        LongHuTuanDuiFragment tuanDuiFragment = new LongHuTuanDuiFragment();
        LongHuMenDianFragment menDianFragment = new LongHuMenDianFragment();

        list.add(geRenFragment);
        list.add(tuanDuiFragment);
        list.add(menDianFragment);
    }

    private void initRg() {
        mRgLonghu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton select = (RadioButton) findViewById(i);
                int index = Integer.parseInt(select.getTag().toString());

                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.frame_longhu, list.get(index)).commit();
                }

                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
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
