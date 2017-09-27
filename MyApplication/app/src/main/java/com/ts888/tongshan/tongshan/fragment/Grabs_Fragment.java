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
import com.ts888.tongshan.tongshan.bean.GrabBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ShowTostUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by dongdong on 2017/7/30.
 */

public class Grabs_Fragment extends Fragment implements IMainView {

    @BindView(R.id.mTxt_title)
    TextView mTxtTitle;
    @BindView(R.id.mXRecylerView)
    XRecyclerView mXRecylerView;
    Unbinder unbinder;
    private Present present;
    private GrapInfoAdapter adapter;
    private SharedPreferences sharedPreferences;
    private String token;
    private ParmsBean bean;

    private List<GrabBean.DataBean> mDatas = new ArrayList<>();
    private List<GrabBean.DataBean> mAllDatas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grabs, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        bean = new ParmsBean();
        present.getGrabInfoList(new JinJianBean(), token);//查询所有抢单信息


        adapter = new GrapInfoAdapter(getActivity(),mAllDatas);
        mXRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mXRecylerView.setAdapter(adapter);
        mXRecylerView.setRefreshProgressStyle(ProgressStyle.BallBeat);
        mXRecylerView.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        mXRecylerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mDatas.clear();
                adapter.notifyDataSetChanged();
                present.getGrabInfoList(new JinJianBean(), token);
                mXRecylerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mXRecylerView.loadMoreComplete();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getCode(String s) {
        Log.i("dd", "抢单: "+s);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {
        ShowTostUtil.toast(getActivity(),s);
    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "抢单: " + s);
        Gson gson = new Gson();
        GrabBean grabBean = gson.fromJson(s, GrabBean.class);
        String code = grabBean.getCode();

        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + grabBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        mDatas = grabBean.getData();
        if (mDatas.size()==0){
            return;
        }

        mAllDatas.addAll(mDatas);
        adapter.notifyDataSetChanged();



    }


}
