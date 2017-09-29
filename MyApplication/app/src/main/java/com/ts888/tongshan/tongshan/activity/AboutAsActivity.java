package com.ts888.tongshan.tongshan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.util.ColorState;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutAsActivity extends AppCompatActivity {

    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.toolbars_qiangdan)
    Toolbar toolbarsQiangdan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about_as);
        ButterKnife.bind(this);
        initToobar();
        String txt = "创新的移动办公：\n" +
                "通过手机，随时随地掌握进件情况；\n" +
                "\n" +
                "便捷沟通：\n" +
                "随时与意向客户联系，提高进件成功率；\n" +
                "\n" +
                "协作高效：\n" +
                "龙虎榜、个人业绩、团队pk，抢单等，提高销售人员工作热情；\n" +
                "\n" +
                "产品中心知识库：\n" +
                "产品大纲、贷款基本要求、简版征信不良标准、进件资料要求，销售人员的移动秘书，随时了解产品动向。";

        txt2.setText(txt);
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
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
