package com.ts888.tongshan.tongshan.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.OrgAdapter;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.FindRankingStarffByIdBean;
import com.ts888.tongshan.tongshan.bean.IndividualRanking;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.bean.OrgRankingBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mBtn_geren_dangqian;


/**
 * Created by Administrator on 2017/8/10.
 * 门店战绩： 默认只显示前5名战绩
 */

public class LongHuMenDianFragment extends Fragment implements IMainView {
    private String token;
    private Present present;
    private LongHuParmsBean parmsBean;
    private int page = 1;
    private int row = 5;

    private List<OrgRankingBean.DataBean> mDatas = new ArrayList<>();
    private List<OrgRankingBean.DataBean> mGeRenDatas = new ArrayList<>();
    private OrgAdapter adapter;
    private XRecyclerView xrecyclerGeren;
    private LinearLayoutManager manager;
    private Button mBtn_org_dangqian;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_org_longhu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        token = getArguments().getString("token");
        xrecyclerGeren = (XRecyclerView) view.findViewById(R.id.xrecycler_org);
        mBtn_org_dangqian = (Button) view.findViewById(R.id.mBtn_org_dangqian);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading...");
        progressDialog.show();

        present = new Present(this);
        parmsBean = new LongHuParmsBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        present.getOrgRanking(parmsBean, token);//获取数组对象
        present.getFindRankingByStaffId(new LongHuParmsBean(), token);//获取排名

        adapter = new OrgAdapter(getActivity(), mGeRenDatas);
        manager = new LinearLayoutManager(getActivity());
        xrecyclerGeren.setLayoutManager(manager);
        xrecyclerGeren.setAdapter(adapter);




//        刷新动画
        xrecyclerGeren.setRefreshProgressStyle(ProgressStyle.BallBeat);
//        xrecyclerGeren.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);

////
////        //暴露出来的刷新加载的方法
        xrecyclerGeren.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                page = 1;
//                mGeRenDatas.clear();
//                parmsBean.setPage(page);
//                parmsBean.setRows(row);
//                present.getOrgRanking(parmsBean, token);
                xrecyclerGeren.refreshComplete();
            }


            @Override
            public void onLoadMore() {

                Toast.makeText(getActivity(), "只显示前5名业绩", Toast.LENGTH_SHORT).show();

                //下拉加载更多，目前不需要
//                page++;
//                parmsBean.setPage(page);
//                parmsBean.setRows(row);
//                present.getOrgRanking(parmsBean, token);
//                xrecyclerGeren.smoothScrollToPosition(mGeRenDatas.size() - 1);
                xrecyclerGeren.loadMoreComplete();
            }
        });


    }

    @Override
    public void getCode(String s) {
        progressDialog.cancel();
        if (s==null){
            return;
        }
        Gson gson = new Gson();
        OrgRankingBean orgRankingBean = gson.fromJson(s, OrgRankingBean.class);
        String code = orgRankingBean.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+orgRankingBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        mDatas = orgRankingBean.getData();
        if (mDatas.size() == 0) {
            Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
            return;
        }
        mGeRenDatas.addAll(mDatas);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: 排名"+s);
        Gson gson = new Gson();
        FindRankingStarffByIdBean findRankingStarffById = gson.fromJson(s, FindRankingStarffByIdBean.class);
        String code = findRankingStarffById.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+findRankingStarffById.getMassage(), Toast.LENGTH_SHORT).show();
            mBtn_org_dangqian.setText(""+findRankingStarffById.getMassage());
            return;
        }
        FindRankingStarffByIdBean.DataBean data = findRankingStarffById.getData();

        if (null==data){
            Toast.makeText(getActivity(), ""+findRankingStarffById.getMassage(), Toast.LENGTH_SHORT).show();
            return;
        }

        FindRankingStarffByIdBean.DataBean.OrgRankingDtoBean orgRankingDto1 = data.getOrgRankingDto();

        boolean b = orgRankingDto1 instanceof FindRankingStarffByIdBean.DataBean.OrgRankingDtoBean;
        if (!b){
            mBtn_org_dangqian.setText("我的门店排名：---");
            return;
        }
        int orgRanking = orgRankingDto1.getOrgRanking();
        mBtn_org_dangqian.setText("我的门店排名：第 " + orgRanking + " 名");
    }
}
