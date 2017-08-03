package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.UserInfiBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

public class JinjianActivity extends AppCompatActivity implements IMainView {

    private EditText mEd_kehuname, mEd_idCard;
    private TextView mTxt_statue;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private String TAG = "dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jinjian);

        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "888888");

        mEd_kehuname = (EditText) findViewById(R.id.mEd_tiaojian_jinjian_Activity);
        mEd_idCard = (EditText) findViewById(R.id.mEd_shenfenzheng_jinjian_Activity);
        mTxt_statue = (TextView) findViewById(R.id.mTxt_xinxi_jinjian_activity);

        present = new Present(this);


        findViewById(R.id.mBtn_chaxun_jinjian_Activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParmsBean parmsBean = new ParmsBean();
                String userName = mEd_kehuname.getText().toString().trim();
                //余杭
                String idCard = mEd_idCard.getText().toString().trim();
                //51022819811213629X
                parmsBean.setUserName(userName);
                parmsBean.setIdCard(idCard);

                present.getUserInfo(parmsBean, token);
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
        Log.i(TAG, "showFaliure: ");
    }

    @Override
    public void getLogin(String s) {
        Log.i(TAG, "getLogin: "+s);
        Gson g = new Gson();
        UserInfiBean userInfiBean = g.fromJson(s, UserInfiBean.class);
        String detail = userInfiBean.getData().getDetail();
        mTxt_statue.setText(detail);

    }
}
