package com.ts888.tongshan.tongshan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

public class TestActivity extends AppCompatActivity implements IMainView{

    private Present present;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        present = new Present(this);

        FindCalcParameterBean parameterBean = new FindCalcParameterBean();
        parameterBean.setProductCode("Elite1.38");
        parameterBean.setApplyAmt(11000);
        parameterBean.setPeriod(12);



        ParmsBean b = new ParmsBean();

        present.getCalcContractInfoData(parameterBean,"eb783d1212d5787173d51ab636fb8ed9");

//        present.getFindCalcParameter(b,"eb783d1212d5787173d51ab636fb8ed9");

    }

    @Override
    public void getCode(String s) {
        Log.i("dd", "getCode: "+s);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {
        Log.i("dd", "getLogin:+++ "+s);
    }
}
