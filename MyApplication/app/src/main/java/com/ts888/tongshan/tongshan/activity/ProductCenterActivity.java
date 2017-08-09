package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.constant.H5API;
import com.ts888.tongshan.tongshan.util.ColorState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductCenterActivity extends AppCompatActivity {

    @BindView(R.id.mTxt_product_Activity)
    TextView mTxtProductActivity;
    @BindView(R.id.toolbars_pro_activity)
    Toolbar toolbarsProActivity;
    @BindView(R.id.mBtn_pd_daikuanyaoqiu)
    Button mBtnPdDaikuanyaoqiu;
    @BindView(R.id.mBtn_pd_biaozhun)
    Button mBtnPdBiaozhun;
    @BindView(R.id.mBtn_pd_jinjian)
    Button mBtnPdJinjian;
    @BindView(R.id.ll_product)
    LinearLayout llProduct;
    @BindView(R.id.chanpindagang)
    TextView chanpindagang;
    @BindView(R.id.mBtn_pd_Ewangtong)
    Button mBtnPdEwangtong;
    @BindView(R.id.Ewang)
    RelativeLayout Ewang;
    @BindView(R.id.txtp1)
    TextView txtp1;
    @BindView(R.id.mBtn_pd_Efangtong)
    Button mBtnPdEfangtong;
    @BindView(R.id.Efang)
    RelativeLayout Efang;
    @BindView(R.id.txtp2)
    TextView txtp2;
    @BindView(R.id.mBtn_pd_Udaitong)
    Button mBtnPdUdaitong;
    @BindView(R.id.Udai)
    RelativeLayout Udai;
    @BindView(R.id.txtp3)
    TextView txtp3;
    @BindView(R.id.mBtn_pd_weidai)
    Button mBtnPdWeidai;
    @BindView(R.id.Eweidai)
    RelativeLayout Eweidai;
    @BindView(R.id.txtp4)
    TextView txtp4;
    @BindView(R.id.mBtn_pd_Eshouxin)
    Button mBtnPdEshouxin;
    @BindView(R.id.Eshouxin)
    RelativeLayout Eshouxin;
    @BindView(R.id.txtp5)
    TextView txtp5;
    @BindView(R.id.mBtn_pd_Ezigu)
    Button mBtnPdEzigu;
    @BindView(R.id.Ezigu)
    RelativeLayout Ezigu;
//    @BindView(R.id.txtp6)
//    TextView txtp6;
    @BindView(R.id.mBtn_pd_Ezhai_shouxin)
    Button mBtnPdEzhaiShouxin;
//    @BindView(R.id.zhaitong_Eigu)
//    RelativeLayout zhaitongEigu;
    @BindView(R.id.txtp7)
    TextView txtp7;
    @BindView(R.id.mBtn_pd_Ezhai_zigu)
    Button mBtnPdEzhaiZigu;
    @BindView(R.id.zhaitong_zigu)
    RelativeLayout zhaitongZigu;
    @BindView(R.id.txtp8)
    TextView txtp8;
    @BindView(R.id.mBtn_pd_Udai_renqun)
    Button mBtnPdUdaiRenqun;
    @BindView(R.id.zhaitong_tuixiu)
    RelativeLayout zhaitongTuixiu;
    @BindView(R.id.activity_product_center)
    ScrollView activityProductCenter;
//    @BindView(R.id.mBtn_pd_Ezhaitong_shouxin)
//    Button mBtnPdEzhaitongShouxin;
    @BindView(R.id.zhaitong_shouxin)
    RelativeLayout zhaitongShouxin;
    @BindView(R.id.txtp9)
    TextView txtp9;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_product_center);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbars_pro_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
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

    @OnClick({R.id.mBtn_pd_daikuanyaoqiu, R.id.mBtn_pd_biaozhun, R.id.mBtn_pd_jinjian, R.id.mBtn_pd_Ewangtong, R.id.mBtn_pd_Efangtong, R.id.mBtn_pd_Udaitong, R.id.mBtn_pd_weidai, R.id.mBtn_pd_Eshouxin, R.id.mBtn_pd_Ezigu, R.id.mBtn_pd_Ezhai_shouxin, R.id.mBtn_pd_Ezhai_zigu, R.id.mBtn_pd_Udai_renqun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_pd_daikuanyaoqiu:  //贷款要求
                startWebActivity(H5API.basicLimitForLoan, "贷款基本要求");
                break;
            case R.id.mBtn_pd_biaozhun://简版征信不良标准
                startWebActivity(H5API.simpleCreditStandar, "简版征信不良标准");
                break;
            case R.id.mBtn_pd_jinjian://进件资料要求
                startWebActivity(H5API.registerRequireData, "进件资料要求");
                break;
            case R.id.mBtn_pd_Ewangtong://E网通
                startWebActivity(H5API.Ewangtong, "E网通");
                break;
            case R.id.mBtn_pd_Efangtong://E房通
                startWebActivity(H5API.Efangtong, "E房通");
                break;
            case R.id.mBtn_pd_Udaitong://U贷通
                startWebActivity(H5API.Elite, "U贷通");
                break;
            case R.id.mBtn_pd_weidai://E微贷
                startWebActivity(H5API.Eweidai, "E微贷");
                break;
            case R.id.mBtn_pd_Eshouxin://E保通-受薪????
                startWebActivity(H5API.Ebaotong, "E保通-受薪");
                break;
            case R.id.mBtn_pd_Ezigu://E保通-自雇
                startWebActivity(H5API.Ebaotong_zigu, "E保通-自雇");
                break;
            case R.id.mBtn_pd_Ezhai_shouxin://E宅通-受薪
                startWebActivity(H5API.Ezhaitong, "E宅通-受薪");
                break;
            case R.id.mBtn_pd_Ezhai_zigu://E宅通-自雇
                startWebActivity(H5API.Ezhaitong_zigu, "E宅通-自雇");
                break;
            case R.id.mBtn_pd_Udai_renqun://U贷人群及退休人群
                startWebActivity(H5API.EliteRetire, "U贷人群及退休人群");
                break;
        }
    }


    public void startWebActivity(String url, String name) {

        Intent intent = new Intent(this, WebActivity.class);

        intent.putExtra("producturl", url);
        intent.putExtra("title", name);

        startActivity(intent);

    }


}
