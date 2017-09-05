package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.LikeListAdapter;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by Administrator on 2017/7/31.
 */

public class KeHuFragment extends Fragment implements IMainView {


    private XRecyclerView mKeHu_rl;
    private EditText editText;
    private List<FindScheduleBean.DataBean> list = new ArrayList();

    private List<FindScheduleBean.DataBean> mList = new ArrayList();
    private Present present;
    private ParmsBean parmsBean;
    private JinJianBean jinJianBean;
    private String tokens;
    private int page = 1;
    private int row = 20;
    private LikeListAdapter adapter;
    private LinearLayoutManager manager;
    private boolean isFirst = true;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kehu, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tokens = getArguments().getString("towKey");
        String userCodes = getArguments().getString("key");

        parmsBean = new ParmsBean();
        jinJianBean = new JinJianBean();
        parmsBean.setPage(page);
        parmsBean.setRows(row);
        mKeHu_rl = (XRecyclerView) view.findViewById(R.id.kehu_rl);
        editText = (EditText) view.findViewById(R.id.ed_search1);
        present = new Present(this);
        present.getFindInApprovalApplyInfo(parmsBean, tokens);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                jinJianBean.setName(editable.toString());
                present.getFindInApprovalApplyInfoByUserName(jinJianBean, tokens);
            }
        });

        //Recylerview加载数据
        adapter = new LikeListAdapter(getActivity(), mList);
        mKeHu_rl.setAdapter(adapter);
        manager = new LinearLayoutManager(getActivity());
        mKeHu_rl.setLayoutManager(manager);
        adapter.setOnItemClickListener(new LikeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                callBack.getText(mList.get(pos).getUserCode());
            }
        });

        //下拉刷新，上拉加载
        mKeHu_rl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mList.clear();
                adapter.notifyDataSetChanged();
                parmsBean.setPage(page);
                parmsBean.setRows(row);
                present.getFindInApprovalApplyInfo(parmsBean, tokens);
                mKeHu_rl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                if (page >= 5) {
//                    if (isFirst){
//                        Toast.makeText(getActivity(), "只能查看前50名业绩", Toast.LENGTH_SHORT).show();
//                        isFirst=false;
//                    }
//                    Toast.makeText(getActivity(), "只能查看前50名业绩", Toast.LENGTH_SHORT).show();
                    mKeHu_rl.loadMoreComplete();
                    return;
                }
                page++;
                parmsBean.setPage(page);
                parmsBean.setRows(row);
                present.getFindInApprovalApplyInfo(parmsBean, tokens);
                mKeHu_rl.smoothScrollToPosition(mList.size() - 1);
                mKeHu_rl.loadMoreComplete();

            }
        });
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
        Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {
        Gson g = new Gson();
        FindScheduleBean findScheduleBean = g.fromJson(s, FindScheduleBean.class);
        String code = findScheduleBean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + findScheduleBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        list = findScheduleBean.getData();

        if (list.size() == 0) {
            if (isFirst) {
                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                isFirst = false;
            }
            Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
            return;
        }
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getUpDate(String s) {

    }

    public interface TextCallBack {
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
