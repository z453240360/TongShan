package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GrapInfoAdapter;
import com.ts888.tongshan.tongshan.bean.CityPKBean;
import com.ts888.tongshan.tongshan.bean.GrabBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.PKParmsBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by dongdong on 2017/7/30.
 */

public class CityPk_Fragment extends Fragment implements IMainView {

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private PKParmsBean bean;
    private String currentMonth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citypk, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currentMonth = getCurrentMonth();

        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        bean = new PKParmsBean();


        bean.setStartTime(currentMonth);
        present.getCityPKResults(bean, token);//cityPk信息
    }


    @Override
    public void getCode(String s) {
        Log.i("dd", "city: "+s);
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

    //获取当前系统的月份
    public String getCurrentMonth(){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        if(month<9){
            int i =  month + 1;
            return "0"+i+"";
        }


        return month+1+"";
    }

}
