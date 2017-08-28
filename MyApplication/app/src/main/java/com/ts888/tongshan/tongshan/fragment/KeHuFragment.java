package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.LikeListAdapter;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class KeHuFragment extends Fragment implements IMainView {


    private RecyclerView mKeHu_rl;
    private List<FindScheduleBean.DataBean> list = new ArrayList();
    private Present present;
    private ParmsBean parmsBean;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kehu, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String tokens = getArguments().getString("towKey");
        String userCodes = getArguments().getString("key");

        parmsBean = new ParmsBean();
        parmsBean.setPage(1);
        parmsBean.setRows(20);
        mKeHu_rl = (RecyclerView) view.findViewById(R.id.kehu_rl);
        present = new Present(this);
        present.getFindInApprovalApplyInfo(parmsBean,tokens);
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
        Gson g = new Gson();
        FindScheduleBean findScheduleBean = g.fromJson(s, FindScheduleBean.class);
        String code = findScheduleBean.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+findScheduleBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
        final List<FindScheduleBean.DataBean> data = findScheduleBean.getData();


        LikeListAdapter adapter = new LikeListAdapter(getActivity(),data);

        mKeHu_rl.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        mKeHu_rl.setLayoutManager(manager);

        adapter.setOnItemClickListener(new LikeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                callBack.getText(data.get(pos).getUserCode());
            }
        });

    }

    @Override
    public void getUpDate(String s) {

    }

    public interface TextCallBack{
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack){
        this.callBack = callBack;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
