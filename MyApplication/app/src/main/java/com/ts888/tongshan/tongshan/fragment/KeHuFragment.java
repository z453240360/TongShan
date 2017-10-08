package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SearchView;
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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.ts888.tongshan.tongshan.R.id.ed_search1;

/**
 * Created by Administrator on 2017/7/31.
 */

public class KeHuFragment extends Fragment implements IMainView {


    private XRecyclerView mKeHu_rl;
    private SearchView editText;
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
    private RelativeLayout activity_main;

    @Override
    public void onResume() {
        super.onResume();
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
    }

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
        editText = (SearchView) view.findViewById(ed_search1);
        editText.setIconifiedByDefault(false);
        editText.clearFocus();
        present = new Present(this);
        present.getFindInApprovalApplyInfo(parmsBean, tokens);

        Class<? extends SearchView> aClass = editText.getClass();
        //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
        Field ownField = null;
        try {
            ownField = aClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(editText);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        editText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                jinJianBean.setName(s);
                present.getFindInApprovalApplyInfoByUserName(jinJianBean, tokens);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                jinJianBean.setName(s);
                present.getFindInApprovalApplyInfoByUserName(jinJianBean, tokens);
                return false;
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
                if (!(editText.getQuery().toString()).equals("")) {
                    mList.clear();
                    jinJianBean.setName(editText.getQuery().toString());
                    present.getFindInApprovalApplyInfoByUserName(jinJianBean, tokens);
                    mKeHu_rl.refreshComplete();

                } else {
                    page = 1;
                    mList.clear();
                    editText.clearFocus();
                    adapter.notifyDataSetChanged();
                    parmsBean.setPage(page);
                    parmsBean.setRows(row);
                    present.getFindInApprovalApplyInfo(parmsBean, tokens);
                    mKeHu_rl.refreshComplete();
                }
            }

            @Override
            public void onLoadMore() {
                if (!(editText.getQuery().toString()).equals("")) {
                    jinJianBean.setName(editText.getQuery().toString());
                    present.getFindInApprovalApplyInfoByUserName(jinJianBean, tokens);
                    mKeHu_rl.loadMoreComplete();
                } else {
                    page++;
                    parmsBean.setPage(page);
                    parmsBean.setRows(row);
                    present.getFindInApprovalApplyInfo(parmsBean, tokens);
                    mKeHu_rl.smoothScrollToPosition(mList.size() - 1);
                    mKeHu_rl.loadMoreComplete();
                }
            }
        });

        //设置点击空白处，自动隐藏键盘
        activity_main = (RelativeLayout) view.findViewById(R.id.rl1);
        activity_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager manager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                return manager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
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
//            if (isFirst) {
//                Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
//                isFirst = false;
//                return;
//            }
//            Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
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
