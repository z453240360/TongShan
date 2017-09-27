package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.CityPKBean;
import com.ts888.tongshan.tongshan.bean.PKParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.wedget.PKText;

/**
 * Created by dongdong on 2017/7/30.
 */

public class CityPk_Fragment extends Fragment implements IMainView {

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private PKParmsBean bean;
    private int heightPixels;
    private PKText challageCityPK,acceptCityPK;
    private TextView mTxt_moneyNumPK;
    private int money=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citypk, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        challageCityPK = (PKText) view.findViewById(R.id.challageCityPK);
        acceptCityPK = (PKText) view.findViewById(R.id.acceptCityPK);
        mTxt_moneyNumPK = (TextView) view.findViewById(R.id.mTxt_moneyPK);


        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        bean = new PKParmsBean();
        present.getCityPKResults(bean, token);//cityPk信息
        heightPixels = getResources().getDisplayMetrics().heightPixels;

    }


    @Override
    public void getCode(String s) {
        Log.i("dd", "cityPK: "+s);
        Gson gson = new Gson();
        CityPKBean cityPKBean = gson.fromJson(s, CityPKBean.class);
        String code = cityPKBean.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+cityPKBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        CityPKBean.DataBean data = cityPKBean.getData();
        String challengeCityName = data.getChallengeCityName();//挑战方城市名
        String acceptCityName = data.getAcceptCityName();//被挑战方城市名称
        double challengeDisplayNumber = data.getChallengeDisplayNumber();//挑战方柱状图参考
        double acceptDisplayNumber = data.getAcceptDisplayNumber();//被挑战方柱状图参考
        double challengeAmount = data.getChallengeAmount();
        double acceptAmount = data.getAcceptAmount();




        if (challengeAmount>acceptAmount){

            if (challengeAmount!=0) {
                double v = acceptAmount / challengeAmount;
                challageCityPK.setTextHeight((int)(heightPixels/3.5));
                acceptCityPK.setTextHeight((int)(heightPixels/3.5*v));
                money = (int)(challengeAmount-acceptAmount);
            }

        }else {
            if (acceptAmount!=0) {
                double v = challengeAmount / acceptAmount;
                acceptCityPK.setTextHeight((int)(heightPixels/3.5));
                challageCityPK.setTextHeight((int)(heightPixels/3.5*v));
                money = (int)(acceptAmount-challengeAmount);
            }
        }


        acceptCityPK.getText_money().setText((int) acceptAmount+"");
        acceptCityPK.getTxt_area().setText(acceptCityName);
        challageCityPK.getText_money().setText((int) challengeAmount+"");
        challageCityPK.getTxt_area().setText(challengeCityName);
        mTxt_moneyNumPK.setText(money+"");

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

    }

    @Override
    public void getUpDate(String s) {

    }

}
