package com.ts888.tongshan.tongshan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.bean.OrgRankingBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class LongHuMenDianFragment extends Fragment implements IMainView{
    private String token;
    private Present present;
    private LongHuParmsBean parmsBean;
    private int page=1;
    private int row = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.adapter_geren,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        token = getArguments().getString("token");
        present = new Present(this);
        parmsBean = new LongHuParmsBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        present.getOrgRanking(parmsBean,token);

    }

    @Override
    public void getCode(String s) {
        Log.i("dd", "getCode: "+s);
        Gson gson = new Gson();
        OrgRankingBean orgRankingBean = gson.fromJson(s, OrgRankingBean.class);
        List<OrgRankingBean.DataBean> data = orgRankingBean.getData();



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
