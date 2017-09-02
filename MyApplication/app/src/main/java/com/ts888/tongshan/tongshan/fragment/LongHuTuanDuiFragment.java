package com.ts888.tongshan.tongshan.fragment;

import android.app.ProgressDialog;
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
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GroupAdapter;
import com.ts888.tongshan.tongshan.adapter.OrgAdapter;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.FindRankingStarffByIdBean;
import com.ts888.tongshan.tongshan.bean.GroupRankingBean;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.bean.OrgRankingBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mBtn_org_dangqian;

/**
 * Created by Administrator on 2017/8/10.
 */

public class LongHuTuanDuiFragment extends Fragment implements IMainView {

    private List<GroupRankingBean.DataBean> mDatas = new ArrayList<>();
    private List<GroupRankingBean.DataBean> mGeRenDatas = new ArrayList<>();
    private Present present;
    private String token;
    private LongHuParmsBean parmsBean;
    private int page = 1;
    private int row = 10;
    private XRecyclerView xrecyclerGroup;
    private Button mBtn_group_dangqian;
    private GroupRankingBean groupRankingBean;
    private GroupAdapter adapter;
    private LinearLayoutManager manager;
    private ProgressDialog progressDialog;
    private boolean isFirst = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_group_longhu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xrecyclerGroup = (XRecyclerView) view.findViewById(R.id.xrecycler_group);
        mBtn_group_dangqian = (Button) view.findViewById(R.id.mBtn_group_dangqian);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading...");
        progressDialog.show();

        parmsBean = new LongHuParmsBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        present = new Present(this);
        token = getArguments().getString("token");
        present.getGroupRanking(parmsBean, token);
        present.getFindRankingByStaffId(new LongHuParmsBean(), token);

        adapter = new GroupAdapter(getActivity(), mGeRenDatas);
        manager = new LinearLayoutManager(getActivity());
        xrecyclerGroup.setLayoutManager(manager);
        xrecyclerGroup.setAdapter(adapter);

        xrecyclerGroup.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xrecyclerGroup.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        xrecyclerGroup.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mGeRenDatas.clear();
                adapter.notifyDataSetChanged();
                parmsBean.setPage(page);
                parmsBean.setRows(row);
                present.getGroupRanking(parmsBean, token);
                xrecyclerGroup.refreshComplete();
            }


            @Override
            public void onLoadMore() {

                if (isFirst) {
                    Toast.makeText(getActivity(), "只显示前10名业绩", Toast.LENGTH_SHORT).show();
                    isFirst = false;
                }


                //加载更多
//                page++;
//                parmsBean.setPage(page);
//                parmsBean.setRows(row);
//                present.getGroupRanking(parmsBean, token);
//                xrecyclerGroup.smoothScrollToPosition(mGeRenDatas.size() - 1);
                xrecyclerGroup.loadMoreComplete();
            }
        });

    }

    @Override
    public void getCode(String s) {
        progressDialog.cancel();
        if (s == null) {
            return;
        }
        Gson gson = new Gson();
        GroupRankingBean orgRankingBean = gson.fromJson(s, GroupRankingBean.class);
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
        Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: 排名" + s);
        Gson gson = new Gson();
        FindRankingStarffByIdBean findRankingStarffById = gson.fromJson(s, FindRankingStarffByIdBean.class);
        String code = findRankingStarffById.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+findRankingStarffById.getMassage(), Toast.LENGTH_SHORT).show();
            mBtn_group_dangqian.setText(""+findRankingStarffById.getMassage());
//            mBtn_group_dangqian.setText("我的团队排名：---");
            return;

        }
        FindRankingStarffByIdBean.DataBean data = findRankingStarffById.getData();
        if (null==data){
            Toast.makeText(getActivity(), ""+findRankingStarffById.getMassage(), Toast.LENGTH_SHORT).show();
            return;
        }
        FindRankingStarffByIdBean.DataBean.GroupRankingDtoBean groupRankingDto = data.getGroupRankingDto();
        boolean b = groupRankingDto instanceof FindRankingStarffByIdBean.DataBean.GroupRankingDtoBean;
        if (!b) {
            mBtn_group_dangqian.setText("我的团队排名：---");
            return;
        }

        int orgRanking = groupRankingDto.getGroupRanking();
        mBtn_group_dangqian.setText("我的团队排名：第 " + orgRanking + " 名");
    }
}
