package com.ts888.tongshan.tongshan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.util.ColorState;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QiandanActivity extends AppCompatActivity {

    @BindView(R.id.mTxt_qiangdan)
    TextView mTxtQiangdan;
    @BindView(R.id.rc_qiandan)
    XRecyclerView rcQiandan;
    private Toolbar toolbarsQiangdan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qiandan);
        ButterKnife.bind(this);

        initToobar();
    }

    private void initToobar() {
        //设置自定义标题栏

        toolbarsQiangdan = (Toolbar) findViewById(R.id.toolbars_qiangdan);
        setSupportActionBar(toolbarsQiangdan);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbarsQiangdan.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
