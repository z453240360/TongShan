package com.ts888.tongshan.tongshan;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.activity.ShiSuanActivity;
import com.ts888.tongshan.tongshan.activity.YeWuActivity;
import com.ts888.tongshan.tongshan.bean.CodeDataBean;
import com.ts888.tongshan.tongshan.bean.LoginBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.ICallBack;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

import static android.R.attr.data;
import static com.ts888.tongshan.tongshan.R.id.mEd_user_password;

public class MainActivity extends AppCompatActivity implements IMainView {

    private Present present;

    private EditText mEd_phoneNumber, mEd_code;

    private String TAG = "dd";
    private String phoneNo;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ProgressDialog dialog;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.StatusBarLightMode(this);

        ColorState.setWindowStatusBarColor(this, Color.WHITE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        present = new Present(this);
        mEd_phoneNumber = (EditText) findViewById(R.id.mEd_user_phoneNumber);
        mEd_code = (EditText) findViewById(mEd_user_password);
//        mEd_phoneNumber.setText("18616850003");
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        dialog = new ProgressDialog(this);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        activity_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                return manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mBtn_getPassword:

                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        MainActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
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
//        ProgressDialog.show(this,"登陆中","");
        dialog.show();

    }

    @Override
    public void cancelLoading() {
        //退出加载框

        dialog.dismiss();
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
        if (!code .equals("1")) {
            Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        String token = loginBean.getData().getToken();
        String userCode = loginBean.getData().getUserCode();
        editor.putString("userCode",userCode);
        editor.putString("token",token);
        editor.putString("phoneNo",loginBean.getData().getPhoneNo());
        editor.commit();
        dialog.dismiss();
        mEd_code.setText("");
        startActivity(new Intent(MainActivity.this, YeWuActivity.class));

    }
}
