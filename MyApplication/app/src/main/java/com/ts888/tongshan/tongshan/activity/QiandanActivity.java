package com.ts888.tongshan.tongshan.activity;

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
import com.ts888.tongshan.tongshan.fragment.Grabs_Fragment;
import com.ts888.tongshan.tongshan.fragment.Grabs_MineFragment;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QiandanActivity extends AppCompatActivity {


    @BindView(R.id.ll)
    RadioGroup ll;
    @BindView(R.id.grab_frame)
    FrameLayout grabFrame;
    @BindView(R.id.mRb_shouye)
    RadioButton mRbShouye;
    @BindView(R.id.mRb_xiaoxi)
    RadioButton mRbXiaoxi;
    private Toolbar toolbarsQiangdan;
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qiandan);
        ButterKnife.bind(this);
        initToobar();
        initFragment();
    }

    private void initToobar() {
        //设置自定义标题栏

        toolbarsQiangdan = (Toolbar) findViewById(R.id.toolbars_qiangdan);
        setSupportActionBar(toolbarsQiangdan);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbarsQiangdan.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    //添加Fragment
    private void initFragment() {
        manager = getSupportFragmentManager();

        Grabs_Fragment grabs_fragment = new Grabs_Fragment();
        Grabs_MineFragment grabs_mineFragment = new Grabs_MineFragment();

        list.add(grabs_fragment);
        list.add(grabs_mineFragment);

        manager.beginTransaction().add(R.id.grab_frame, list.get(0)).commit();
        lastFragment = list.get(0);

        ll.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton select = (RadioButton) findViewById(i);
                int index = Integer.parseInt(select.getTag().toString());

                if (list.get(index).isAdded()) {
                    manager.beginTransaction().show(list.get(index)).commit();
                } else {
                    manager.beginTransaction().add(R.id.grab_frame, list.get(index)).commit();
                }

                manager.beginTransaction().hide(lastFragment).commit();
                lastFragment = list.get(index);
            }
        });


        grabs_fragment.setCallBack(new Grabs_Fragment.TextCallBack() {
            @Override
            public void getText(String str) {
                if (str.equals("succesed")) {
                    mRbXiaoxi.setChecked(true);
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
