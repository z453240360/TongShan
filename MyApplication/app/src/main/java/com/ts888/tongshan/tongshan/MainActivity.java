package com.ts888.tongshan.tongshan;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.activity.YeWuActivity;
import com.ts888.tongshan.tongshan.bean.CodeDataBean;
import com.ts888.tongshan.tongshan.bean.LoginBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.ICallBack;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity implements IMainView {

    private Present present;

    private EditText mEd_phoneNumber, mEd_code;

    private String TAG = "dd";
    private String phoneNo;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColor(this, Color.WHITE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        dialog = new Dialog(this);
        present = new Present(this);

        mEd_phoneNumber = (EditText) findViewById(R.id.mEd_user_phoneNumber);
        mEd_code = (EditText) findViewById(R.id.mEd_user_password);
        mEd_phoneNumber.setText("18616850003");
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mBtn_getPassword:

                ParmsBean parmsBean1 = new ParmsBean();
                phoneNo = mEd_phoneNumber.getText().toString().trim();
                if (null == phoneNo) {
                    Toast.makeText(this, "输入的号码有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                //获取验证码
                parmsBean1.setPhoneNo(phoneNo);
                present.loadData(parmsBean1);

                break;

            case R.id.mBtn_logIn:
                ParmsBean parmsBean2 = new ParmsBean();

                String verifyCode = mEd_code.getText().toString().trim();
                if (null == phoneNo || null == verifyCode) {
                    Toast.makeText(this, "输入的号码有误", Toast.LENGTH_SHORT).show();
                }
                //登陆账号
                parmsBean2.setPhoneNo(phoneNo);
                parmsBean2.setVerifyCode(verifyCode);

                present.login(parmsBean2);

                break;
        }
    }

    @Override
    public void getCode(String s) {
        Gson g = new Gson();
        CodeDataBean codeDataBean = g.fromJson(s, CodeDataBean.class);
        //获得返回的验证码
        String data = codeDataBean.getData();
        if (data == null) {
            Toast.makeText(this, "" + codeDataBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        mEd_code.setText(data);
        Log.i(TAG, "getCode: ");

    }

    @Override
    public void showLoading() {
        //显示加载框

    }

    @Override
    public void cancelLoading() {
        //退出加载框
    }

    @Override
    public void showFaliure(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {
        Gson g = new Gson();
        LoginBean loginBean = g.fromJson(s, LoginBean.class);

        String code = loginBean.getCode();
        Log.i(TAG, "getLogin: "+s);
        if (!code .equals("1")) {
            Toast.makeText(this, "请求错误" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        String token = loginBean.getData().getToken();
        String userCode = loginBean.getData().getUserCode();
        editor.putString("userCode",userCode);
        editor.putString("token",token);
        editor.putString("phoneNo",loginBean.getData().getPhoneNo());
        editor.commit();
        startActivity(new Intent(MainActivity.this, YeWuActivity.class));

    }
}
