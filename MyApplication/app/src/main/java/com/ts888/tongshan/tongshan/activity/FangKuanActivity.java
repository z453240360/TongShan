package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.util.ColorState;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ts888.tongshan.tongshan.R.id.mTxt_status;


public class FangKuanActivity extends AppCompatActivity {

    @BindView(R.id.toolbars_fangkuan)
    Toolbar toolbarsFangkuan;
    @BindView(R.id.mTxt_jiekuanren2)
    TextView mTxtJiekuanren2;
    @BindView(R.id.mTxt_idCard2)
    TextView mTxtIdCard2;
    @BindView(R.id.mTxt_dates2)
    TextView mTxtDates2;
    @BindView(R.id.mTxt_money2)
    TextView mTxtMoney2;
    @BindView(R.id.mTxt_limit2)
    TextView mTxtLimit2;
    @BindView(R.id.mTxt_product2)
    TextView mTxtProduct2;
    @BindView(R.id.mTxt_jiedian2)
    TextView mTxtJiedian2;
    @BindView(R.id.mTxt_beizhu2)
    TextView mTxtBeizhu2;

    private Intent intent;
    private String name;
    private String idCard;
    private String data;
    private String money;
    private String limit;
    private String feilv;
    private String jiedian;
    private String beizhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fang_kuan);
        ButterKnife.bind(this);
        intent = getIntent();

        initToolBar();
        initData();
        setValue();
    }

    private void initToolBar() {
        setSupportActionBar(toolbarsFangkuan);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbarsFangkuan.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setValue() {
        mTxtJiekuanren2.setText(name);
        mTxtIdCard2.setText(idCard);
        mTxtMoney2.setText(money);
        mTxtLimit2.setText(limit);
        mTxtBeizhu2.setText(beizhu);
//        mTxtJiedian2.setText(jiedian);
        mTxtProduct2.setText(feilv);
        mTxtDates2.setText(data);
    }

    private void initData() {
        name = intent.getStringExtra("name");
        idCard = intent.getStringExtra("idCard");
        data = intent.getStringExtra("data");
        money = intent.getStringExtra("money");
        limit = intent.getStringExtra("limit");
        feilv = intent.getStringExtra("feilv");
        jiedian = intent.getStringExtra("jiedian");
        beizhu = intent.getStringExtra("beizhu");

        if (jiedian.equals("01")){
            mTxtJiedian2.setText("录入复核");
        }else if (jiedian.equals("02")){
            mTxtJiedian2.setText("回退门店");
        }else if (jiedian.equals("03")){
            mTxtJiedian2.setText("审批中");
        }else if (jiedian.equals("05")){
            mTxtJiedian2.setText("资金渠道确认");
        } else if (jiedian.equals("06")){
            mTxtJiedian2.setText("面签");
        } else if (jiedian.equals("07")){
            mTxtJiedian2.setText("合同复核");
        }else if (jiedian.equals("09")){
           mTxtJiedian2.setText("取消");
        }else if (jiedian.equals("10")){
            mTxtJiedian2.setText("拒绝");
        }else {
            mTxtJiedian2.setText(jiedian);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
