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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.ts888.tongshan.tongshan.wedget.PKText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.ts888.tongshan.tongshan.R.id.acceptCity;
import static com.ts888.tongshan.tongshan.R.id.city;
import static com.ts888.tongshan.tongshan.R.id.city2;


/**
 * Created by dongdong on 2017/7/30.
 */

public class CityPk_Fragment extends Fragment implements IMainView {

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private PKParmsBean bean;
    private RelativeLayout sheet;
    private TextView challengeCity,acceptCity,city,city2,money1,money2;
    private int heightPixels;
    private PKText pkText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citypk, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sheet = (RelativeLayout) view.findViewById(R.id.percentSheet);
        challengeCity = (TextView) view.findViewById(R.id.challengeCity);
        acceptCity = (TextView) view.findViewById(R.id.acceptCity);
        city= (TextView) view.findViewById(R.id.city);
        city2= (TextView) view.findViewById(R.id.city2);
        money1 = (TextView) view.findViewById(R.id.challengeCity2);
        money2 = (TextView) view.findViewById(R.id.acceptCity2);
        pkText = (PKText) view.findViewById(R.id.pktxt);

        pkText.setTextHeight(10);

        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        bean = new PKParmsBean();
        present.getCityPKResults(bean, token);//cityPk信息


        heightPixels = getResources().getDisplayMetrics().heightPixels;




//        RelativeLayout.LayoutParams sheetLayoutParams = (RelativeLayout.LayoutParams) sheet.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
//        sheetLayoutParams.height= heightPixels /3+100;
//        sheet.setLayoutParams(sheetLayoutParams);


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
                //动态设置柱体高度
                RelativeLayout.LayoutParams challgedCity = (RelativeLayout.LayoutParams) challengeCity.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
                challgedCity.height = heightPixels/4;// 控件的宽强制设成
                challengeCity.setLayoutParams(challgedCity); //使设置好的布局参数应用到控件

                RelativeLayout.LayoutParams acceptedCity = (RelativeLayout.LayoutParams) acceptCity.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
                acceptedCity.height = (int) (heightPixels * v/4);// 控件的宽强制设成30
                acceptCity.setLayoutParams(acceptedCity); //使设置好的布局参数应用到控件
            }

        }else {
            if (acceptAmount!=0) {
                double v = challengeAmount / acceptAmount;
                //动态设置柱体高度
                RelativeLayout.LayoutParams challgedCity = (RelativeLayout.LayoutParams) challengeCity.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
                challgedCity.height = (int) (heightPixels * v/4);// 控件的宽强制设成30
                challengeCity.setLayoutParams(challgedCity); //使设置好的布局参数应用到控件
                RelativeLayout.LayoutParams acceptedCity = (RelativeLayout.LayoutParams) acceptCity.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
                acceptedCity.height = heightPixels/4;// 控件的宽强制设成30
                acceptCity.setLayoutParams(acceptedCity); //使设置好的布局参数应用到控件
            }
        }

        city.setText(challengeCityName);
        city2.setText(acceptCityName);
        money1.setText((int) challengeAmount+"个元宝");
        money2.setText((int) acceptAmount+"个元宝");
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
