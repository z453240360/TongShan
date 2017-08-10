package com.ts888.tongshan.tongshan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.model.IMainView;

public abstract class BaseActivity extends AppCompatActivity implements IMainView{

    /** 日志输出标志 **/
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);
    }





}
