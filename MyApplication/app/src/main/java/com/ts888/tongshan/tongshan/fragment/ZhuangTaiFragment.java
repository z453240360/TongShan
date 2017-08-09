package com.ts888.tongshan.tongshan.fragment;

import android.graphics.Color;
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
import com.ts888.tongshan.tongshan.yuansuan.YuanSuan;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dongdong on 2017/8/3.
 * 显示用户状态信息
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
        Log.i("dd", "getLogin: "+s);
        Gson gson = new Gson();
        ZhuangTaiBean zhuangTaiBean = gson.fromJson(s, ZhuangTaiBean.class);
        ZhuangTaiBean.DataBean data = zhuangTaiBean.getData();
        String userName = data.getUserName();
        int applyAmt = data.getApplyAmt();
        String applyDate = data.getApplyDate();
        int period = data.getPeriod();
        int verifySchedule = data.getVerifySchedule();

        float v = (float)(applyAmt / 10000);
        DecimalFormat fnum = new DecimalFormat("##0.00");
        String dd=fnum.format(v);

        mTxt_zhuangtainame.setText(userName);
        mTxt_time_zhuangtai2.setText(applyDate);
        mTxt_jiekuanname2.setText(""+dd+"  万元");
        mTxt_qixian2.setText(""+period+"个月");
        mTxt_shouji2.setText("");


        ArrayList<Integer> number = YuanSuan.getNumber(verifySchedule);
        for (int i = 0; i < number.size(); i++) {
            Integer verifysche = number.get(i);
            if (verifysche==2){
                mTxt_jichu2.setText("已认证");
                mTxt_jichu2.setTextColor(Color.rgb(39,183,94));
            }else if (verifysche==4){
                mTxt_renmai2.setText("已认证");
                mTxt_renmai2.setTextColor(Color.rgb(39,183,94));
            }else if (verifysche==8){
                mTxt_geren2.setText("已认证");
                mTxt_geren2.setTextColor(Color.rgb(39,183,94));
            }else if (verifysche==16){
                mTxt_yinghang2.setText("已认证");
                mTxt_yinghang2.setTextColor(Color.rgb(39,183,94));
            }else if (verifysche==0){
                Log.i("", "getLogin: ");
            }
        }

    }

    @Override
    public void getUpDate(String s) {

    }
}
