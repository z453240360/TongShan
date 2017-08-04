package com.ts888.tongshan.tongshan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.ZhuangTaiBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

/**
 * Created by dongdong on 2017/8/3.
 */

public class ZhuangTaiFragment extends Fragment implements IMainView{

    private Present present;
    private ParmsBean parmsBean;
    private TextView mTxt_zhuangtainame,mTxt_time_zhuangtai2,mTxt_jiekuanname2,mTxt_qixian2,mTxt_shouji2,
            mTxt_jichu2,mTxt_renmai2,mTxt_yinghang2,mTxt_geren2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zhuangtai,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String useC = getArguments().getString("useC");
        String token = getArguments().getString("token");

        mTxt_zhuangtainame = (TextView) view.findViewById(R.id.mTxt_zhuangtainame);
        mTxt_time_zhuangtai2 = (TextView) view.findViewById(R.id.mTxt_time_zhuangtai2);
        mTxt_jiekuanname2 = (TextView) view.findViewById(R.id.mTxt_jiekuanname2);
        mTxt_qixian2 = (TextView) view.findViewById(R.id.mTxt_qixian2);
        mTxt_shouji2 = (TextView) view.findViewById(R.id.mTxt_shouji2);
        mTxt_jichu2 = (TextView) view.findViewById(R.id.mTxt_jichu2);
        mTxt_renmai2 = (TextView) view.findViewById(R.id.mTxt_renmai2);
        mTxt_yinghang2 = (TextView) view.findViewById(R.id.mTxt_yinghang2);
        mTxt_geren2 = (TextView) view.findViewById(R.id.mTxt_geren2);

        parmsBean = new ParmsBean();
        parmsBean.setUserCode(useC);
        present = new Present(this);
        present.getFindScheduleByCode(parmsBean,token);
    }

    @Override
    public void getCode(String s) {

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
        Log.i("dd", "getLoginkkhkkhhk: "+ s);

        Gson gson = new Gson();
        ZhuangTaiBean zhuangTaiBean = gson.fromJson(s, ZhuangTaiBean.class);


        ZhuangTaiBean.DataBean data = zhuangTaiBean.getData();
        String userName = data.getUserName();
        int applyAmt = data.getApplyAmt();
        String applyDate = data.getApplyDate();
        int period = data.getPeriod();
        int verifySchedule = data.getVerifySchedule();


        mTxt_zhuangtainame.setText(userName);
        mTxt_time_zhuangtai2.setText(applyDate);
        mTxt_jiekuanname2.setText(""+applyAmt);
        mTxt_qixian2.setText(""+period+"月");
        mTxt_shouji2.setText("");
        if (verifySchedule==0)
        {
            mTxt_jichu2.setText("已认证");
        }else {
            mTxt_jichu2.setText("");
        }

        mTxt_renmai2.setText("");
        mTxt_yinghang2.setText("");
        mTxt_geren2.setText("");




    }
}
