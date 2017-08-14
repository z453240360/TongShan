package com.ts888.tongshan.tongshan.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GeRenAdapter;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.IndividualRanking;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.data;
import static android.content.ContentValues.TAG;
import static com.ts888.tongshan.tongshan.R.id.xrecycler_geren;

/**
 * Created by Administrator on 2017/8/10.
 */

public class LongHuGeRenFragment extends Fragment implements IMainView {
    Unbinder unbinder;
    private List<IndividualRanking.DataBean> mDatas = new ArrayList<>();
    private GeRenAdapter adapter;
    private String token;
    private Present present;
    private LongHuParmsBean parmsBean;
    private XRecyclerView xrecyclerGeren;
    private int page=1;
    private int row = 10;
    private boolean isFirst = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_geren_longhu, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(getActivity());
        xrecyclerGeren = (XRecyclerView) view.findViewById(R.id.xrecycler_geren);
        present = new Present(this);
        token = getArguments().getString("token");
        parmsBean = new LongHuParmsBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        present.getIndividualRanking(parmsBean,token);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getCode(String s) {
        if (isFirst){

            Gson g = new Gson();
            IndividualRanking individualRanking = g.fromJson(s, IndividualRanking.class);
            mDatas = individualRanking.getData();
            adapter = new GeRenAdapter(getActivity(), mDatas);
            xrecyclerGeren.setLayoutManager(new LinearLayoutManager(getActivity()));
            xrecyclerGeren.setAdapter(adapter);
            isFirst=false;
        }else {
            Gson g = new Gson();
            IndividualRanking individualRanking = g.fromJson(s, IndividualRanking.class);
            List<IndividualRanking.DataBean> data = individualRanking.getData();
            adapter = new GeRenAdapter(getActivity(), mDatas);
            xrecyclerGeren.setLayoutManager(new LinearLayoutManager(getActivity()));
            xrecyclerGeren.setAdapter(adapter);
        }


        //=======================================================================
        // 更改刷新 加载 按钮的样式
        //=======================================================================
        xrecyclerGeren.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xrecyclerGeren.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);


        //暴露出来的刷新加载的方法
        xrecyclerGeren.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {



                        //刷新
//                        mDatas.add(0, "刷新出来的数据");
                        adapter.notifyItemInserted(0);

                        //取消刷新的小圆圈: 刷新完成
                        xrecyclerGeren.refreshComplete();
                    }
                }, 1000);

            }

            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载更多
//                        mDatas.add("加载更多");

                        adapter.notifyItemInserted(mDatas.size());

                        //加载更多完成,取消加载更多的按钮
                        xrecyclerGeren.loadMoreComplete();
                    }
                }, 1000);

            }
        });
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
