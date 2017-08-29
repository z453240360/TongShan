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
import com.google.gson.JsonObject;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GeRenAdapter;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.FindRankingStarffByIdBean;
import com.ts888.tongshan.tongshan.bean.IndividualRanking;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.data;
import static android.R.string.no;
import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.ts888.tongshan.tongshan.R.id.xrecycler_geren;

/**
 * Created by Administrator on 2017/8/10.
 */

public class LongHuGeRenFragment extends Fragment implements IMainView {
    Unbinder unbinder;
    private List<IndividualRanking.DataBean> mDatas = new ArrayList<>();
    private List<IndividualRanking.DataBean> mGeRenDatas = new ArrayList<>();
    private GeRenAdapter adapter;
    private String token;
    private Present present;
    private LongHuParmsBean parmsBean;
    private XRecyclerView xrecyclerGeren;
    private int page = 1;
    private int row = 10;
    private boolean isFirst = true;
    private LinearLayoutManager manager;
    private Button mBtn_geren_dangqian;
    private ProgressDialog progressDialog;

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
        mBtn_geren_dangqian = (Button) view.findViewById(R.id.mBtn_geren_dangqian);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading...");
        progressDialog.show();


        present = new Present(this);
        token = getArguments().getString("token");
        parmsBean = new LongHuParmsBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        present.getIndividualRanking(parmsBean, token);
        present.getFindRankingByStaffId(new LongHuParmsBean(),token);//查询个人排名

        adapter = new GeRenAdapter(getActivity(), mGeRenDatas);
        manager = new LinearLayoutManager(getActivity());
        xrecyclerGeren.setLayoutManager(manager);
        xrecyclerGeren.setAdapter(adapter);

        //=======================================================================
        // 更改刷新 加载 按钮的样式
        //=======================================================================
        xrecyclerGeren.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xrecyclerGeren.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);


        //下拉刷新，上拉加载
        xrecyclerGeren.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mGeRenDatas.clear();
                parmsBean.setPage(page);
                parmsBean.setRows(row);
                present.getIndividualRanking(parmsBean, token);
                xrecyclerGeren.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                if (page>=5){
                    if (isFirst){
                        Toast.makeText(getActivity(), "只能查看前50名业绩", Toast.LENGTH_SHORT).show();
                        isFirst=false;
                    }
//                    Toast.makeText(getActivity(), "只能查看前50名业绩", Toast.LENGTH_SHORT).show();
                    xrecyclerGeren.loadMoreComplete();
                    return;
                }
                page++;
                parmsBean.setPage(page);
                parmsBean.setRows(row);
                present.getIndividualRanking(parmsBean, token);
                xrecyclerGeren.smoothScrollToPosition(mGeRenDatas.size()-1);
                xrecyclerGeren.loadMoreComplete();

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
        Log.i(TAG, "个人列表数据: "+s);
        progressDialog.cancel();
        if (s.equals("")){
            return;
        }
        Log.i(TAG, "IndividualRanking:+列表 "+s);
        Gson g = new Gson();
        IndividualRanking individualRanking = g.fromJson(s, IndividualRanking.class);
        String code = individualRanking.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+individualRanking.getMessage(), Toast.LENGTH_SHORT).show();
        }
        mDatas = individualRanking.getData();

        if (mDatas.size()==0){
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
        Log.i(TAG, "个人排名: "+s);
        if (s.equals("")){
            return;
        }
        Gson gson = new Gson();
        FindRankingStarffByIdBean findRankingStarffById = gson.fromJson(s, FindRankingStarffByIdBean.class);

        String code = findRankingStarffById.getCode();
        //message 字段
        String massage = findRankingStarffById.getMassage();

        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+massage, Toast.LENGTH_SHORT).show();
            mBtn_geren_dangqian.setText(massage+"");
            return;
        }
        FindRankingStarffByIdBean.DataBean data = findRankingStarffById.getData();

        if (null==data){
            Toast.makeText(getActivity(), ""+findRankingStarffById.getMassage(), Toast.LENGTH_SHORT).show();
            return;
        }
        Object individualRankingDto = data.getIndividualRankingDto();
        boolean b = individualRankingDto instanceof FindRankingStarffByIdBean.DataBean.IndividualRankingDtoBean;
        if (!b){
            mBtn_geren_dangqian.setText("我的当前名次：---");
            return;
        }
        int individualRanking = data.getIndividualRankingDto().getIndividualRanking();
        mBtn_geren_dangqian.setText("我的当前名次：第 "+individualRanking+" 名");
    }
}
