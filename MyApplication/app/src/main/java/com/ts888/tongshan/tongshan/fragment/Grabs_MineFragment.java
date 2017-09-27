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
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GrapMineAdapter;
import com.ts888.tongshan.tongshan.bean.GrapMyBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dongdong on 2017/7/30.
 */

public class Grabs_MineFragment extends Fragment implements IMainView {

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private ParmsBean bean;
    private List<GrapMyBean.DataBean> myDatas=new ArrayList<>();
    private List<GrapMyBean.DataBean> myAllDatas=new ArrayList<>();
    private GrapMineAdapter grapMineAdapter;
    private XRecyclerView xRl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grabs_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xRl = (XRecyclerView) view.findViewById(R.id.myGrapRl);
        init();
    }

    private void init() {
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        present.getMyGrabList(new JinJianBean(), token);//我的订单信息

        grapMineAdapter = new GrapMineAdapter(getActivity(),myAllDatas);
        xRl.setLayoutManager(new LinearLayoutManager(getActivity()));
        xRl.setAdapter(grapMineAdapter);
        xRl.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xRl.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        xRl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                myAllDatas.clear();
                grapMineAdapter.notifyDataSetChanged();
                present.getMyGrabList(new JinJianBean(), token);
                xRl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRl.loadMoreComplete();
            }
        });

//        bean = new ParmsBean();
//        bean.setPhoneNo("1332342342420");
//        present.cancelGrab(bean, token);//取消订单
    }

    @Override
    public void getCode(String s) {
        Log.i("dd", "取消订单: " + s);
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
        Log.i("dd", "我的订单查询: " + s);
        Gson gson = new Gson();
        GrapMyBean grapMyBean = gson.fromJson(s, GrapMyBean.class);
        String code = grapMyBean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + grapMyBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        myDatas = grapMyBean.getData();
        myAllDatas.addAll(myAllDatas);
        grapMineAdapter.notifyDataSetChanged();
    }
}
