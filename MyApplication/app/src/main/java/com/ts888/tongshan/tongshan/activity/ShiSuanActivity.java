package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.ShisuanParmBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.List;

public class ShiSuanActivity extends AppCompatActivity implements IMainView{

    private Present present;
    private ParmsBean parmsBean;
    private SharedPreferences sharedPreferences;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_suan);

        present = new Present(this);
        parmsBean = new ParmsBean();

        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        String userCode = sharedPreferences.getString("userCode","88888");
        token = sharedPreferences.getString("token", "888888");

        present.getFindCalcParameter(parmsBean,token);
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
        Log.i("dd", "getLogin: "+s);
        Gson gson = new Gson();

        ShisuanParmBean shiSuanBean = gson.fromJson(s, ShisuanParmBean.class);
        ShisuanParmBean.DataBean data = shiSuanBean.getData();
        List<Integer> periods = data.getPeriods();

        ShisuanParmBean.DataBean.ProductInfosBean productInfos = data.getProductInfos();
        String elite13813 = productInfos.get_$Elite13813();
        String elite17861 = productInfos.get_$Elite17861();
        String elite158296 = productInfos.get_$Elite158296();
        String elite198202 = productInfos.get_$Elite198202();
        String elite218278 = productInfos.get_$Elite218278();
        String elite238115 = productInfos.get_$Elite238115();
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.mBtn_check:
                parmsBean.setProductCode("1");
                parmsBean.setApplyAmt((int)1.38);
                parmsBean.setPeriod(12);
                present.getCalcContractInfoData(parmsBean,token);
                break;
        }
    }
}
