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
import com.ts888.tongshan.tongshan.fragment.CityPk_Fragment;
import com.ts888.tongshan.tongshan.fragment.Grabs_Fragment;
import com.ts888.tongshan.tongshan.fragment.Grabs_MineFragment;
import com.ts888.tongshan.tongshan.fragment.GroupPk_Fragment;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PK_Activity extends AppCompatActivity {

    @BindView(R.id.toolbars_qiangdan)
    Toolbar toolbarsQiangdan;
    @BindView(R.id.ll)
    RadioGroup ll;
    @BindView(R.id.grab_frame)
    FrameLayout grabFrame;
    private ArrayList<Fragment> list = new ArrayList<>();
    private FragmentManager manager;
    private Fragment lastFragment;
    private CityPk_Fragment cityPk;
    private GroupPk_Fragment groupPk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pk_);
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

         cityPk = new CityPk_Fragment();
         groupPk = new GroupPk_Fragment();

        list.add(cityPk);
        list.add(groupPk);

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
