package com.ts888.tongshan.tongshan.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GeRenYeJiBean;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;
import com.ts888.tongshan.tongshan.wedget.GeRenWedget;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 个人业绩界面
 */
public class GeRenYeJiActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.mTxt_gerenyeji_Activity)
    TextView mTxtGerenyejiActivity;
    @BindView(R.id.toolbars_gerenyeji_activity)
    Toolbar toolbarsGerenyejiActivity;
    @BindView(R.id.my_wedget1)
    GeRenWedget myWedget1;
    @BindView(R.id.my_wedget2)
    GeRenWedget myWedget2;
    @BindView(R.id.my_wedget3)
    GeRenWedget myWedget3;
    @BindView(R.id.my_wedget4)
    GeRenWedget myWedget4;
    @BindView(R.id.my_wedget5)
    GeRenWedget myWedget5;
    @BindView(R.id.my_wedget6)
    GeRenWedget myWedget6;
    @BindView(R.id.my_wedget7)
    GeRenWedget myWedget7;
    @BindView(R.id.my_wedget8)
    GeRenWedget myWedget8;

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ge_ren_ye_ji);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","888888");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        present = new Present(this);
        present.getUserStatistics(new LongHuParmsBean(),token);

        setSupportActionBar(toolbarsGerenyejiActivity);
        toolbarsGerenyejiActivity.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void cancelLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showFaliure(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: "+s);
        Gson gson = new Gson();
        GeRenYeJiBean geRenYeJiBean = gson.fromJson(s, GeRenYeJiBean.class);
        String code = geRenYeJiBean.getCode();
        if (!code.equals("1"))
        {
            Toast.makeText(this, ""+geRenYeJiBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        GeRenYeJiBean.DataBean data = geRenYeJiBean.getData();

        String cancelCount = data.getCancelCount(); //取消件数
        String loanAmount = data.getLoanAmount(); //放款金额
        String overdueCount = data.getOverdueCount(); //逾期客户
        String piecesOk = data.getPiecesOk(); // 通过件数
        String refuseCount = data.getRefuseCount();//拒绝件数
        String signCount = data.getSignCount(); //签约件数
        String piecesSum = data.getPiecesSum(); //进件量
        String loanCount = data.getLoanCount(); //放款件数

        myWedget1.setTextNumber(piecesSum);
        myWedget1.setTextDanwei("件");
        myWedget1.setTextFenLei("进件量");

        myWedget2.setTextNumber(piecesOk);
        myWedget2.setTextDanwei("件");
        myWedget2.setTextFenLei("通过件数");

        myWedget3.setTextNumber(signCount);
        myWedget3.setTextDanwei("件");
        myWedget3.setTextFenLei("签约件数");

        myWedget4.setTextNumber(loanCount);
        myWedget4.setTextDanwei("件");
        myWedget4.setTextFenLei("放款件数");

        myWedget5.setTextNumber(cancelCount);
        myWedget5.setTextDanwei("件");
        myWedget5.setTextFenLei("取消件数");

        myWedget6.setTextNumber(refuseCount);
        myWedget6.setTextDanwei("件");
        myWedget6.setTextFenLei("拒绝件数");

        myWedget7.setTextNumber(loanAmount);
        myWedget7.setTextDanwei("元");
        myWedget7.setTextFenLei("放款金额");

        myWedget8.setTextNumber(overdueCount);
        myWedget8.setTextDanwei("名");
        myWedget8.setTextFenLei("逾期客户");
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
