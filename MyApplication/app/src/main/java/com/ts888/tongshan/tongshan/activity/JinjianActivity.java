package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.UserInfiBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

/**
 * 进件界面
 *      输入客户姓名和身份证号码点击查询，获取客户进件状态------getLogin（）；
 *
 */

public class JinjianActivity extends AppCompatActivity implements IMainView {

    private EditText mEd_kehuname, mEd_idCard;
    private TextView mTxt_statue;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private String TAG = "dd";
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jinjian);

        //初始化toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbars_jinjian);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //获取缓存的token
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "888888");

        //初始化控件
        mEd_kehuname = (EditText) findViewById(R.id.mEd_tiaojian_jinjian_Activity);
        mEd_idCard = (EditText) findViewById(R.id.mEd_shenfenzheng_jinjian_Activity);
        mTxt_statue = (TextView) findViewById(R.id.mTxt_xinxi_jinjian_activity);


        //初始化逻辑处理层
        present = new Present(this);

        //按钮的点击事件
        findViewById(R.id.mBtn_chaxun_jinjian_Activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        JinjianActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                ParmsBean parmsBean = new ParmsBean();
                String userName = mEd_kehuname.getText().toString().trim();
                String idCard = mEd_idCard.getText().toString().trim();
                parmsBean.setUserName(userName);
                parmsBean.setIdCard(idCard);
                present.getUserInfo(parmsBean, token); //发送网络请求
            }
        });
    }

    @Override
    public void getCode(String s) {
        Log.i(TAG, "getCode: ");
    }

    @Override
    public void showLoading() {
        Log.i(TAG, "showLoading: ");

    }

    @Override
    public void cancelLoading() {
        Log.i(TAG, "cancelLoading: ");
    }

    @Override
    public void showFaliure(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }

    //获取网络请求信息
    @Override
    public void getLogin(String s) {
        Log.i(TAG, "getLogin: "+s);
        Gson g = new Gson();
        UserInfiBean userInfiBean = g.fromJson(s, UserInfiBean.class);
        String code = userInfiBean.getCode();
        if (!code.equals("1"))
        {
            Toast.makeText(this, ""+userInfiBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        String detail = userInfiBean.getData().getDetail();
        mTxt_statue.setText(detail);

    }

    @Override
    public void getUpDate(String s) {

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
