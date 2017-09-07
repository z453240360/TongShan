package com.ts888.tongshan.tongshan.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.activity.FangKuanActivity;
import com.ts888.tongshan.tongshan.adapter.LikeListAdapter2;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.Jinjian2_Bean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/7/31.
 */

public class KeHuFragment2 extends Fragment implements IMainView {


    private XRecyclerView mKeHu_rl;
    private SearchView ed_search1;
//    private com.ts888.tongshan.tongshan.wedget.SearchView my_search;
    private Present present;
    private String tokens;
    private LikeListAdapter2 adapter2;
    private LinearLayoutManager manager;
    private boolean isFirst = true;
    private JinJianBean bean;
    private List<Jinjian2_Bean.DataBean> mDates = new ArrayList<>();
    private List<Jinjian2_Bean.DataBean> mDatess = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kehu2, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initToken();
        init(view);

        //进件查询
        present.findApplyInfo(bean, tokens);//返回数据为空
        adapter2 = new LikeListAdapter2(getActivity(), mDatess);
        //Recylerview加载数据
        mKeHu_rl.setAdapter(adapter2);
        manager = new LinearLayoutManager(getActivity());
        mKeHu_rl.setLayoutManager(manager);

        adapter2.setOnItemClickListener(new LikeListAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {

                Jinjian2_Bean.DataBean dataBean = mDatess.get(pos);
                Intent intent = new Intent(getActivity(), FangKuanActivity.class);

                intent.putExtra("name",dataBean.getName());
                intent.putExtra("idCard",dataBean.getIdCardNo());
                intent.putExtra("data",dataBean.getApplyDate());
                intent.putExtra("money",dataBean.getApprovalAmount());
                intent.putExtra("limit",dataBean.getLoanLife());
                intent.putExtra("feilv",dataBean.getProductRate());
                intent.putExtra("jiedian",dataBean.getTaskNode());
                intent.putExtra("beizhu",dataBean.getRemark());
                startActivity(intent);

            }
        });


//        下拉刷新，上拉加载
        mKeHu_rl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mDatess.clear();
                adapter2.notifyDataSetChanged();
                String s = ed_search1.getQuery().toString();

                bean.setName(s);
                present.findApplyInfo(bean, tokens);
                mKeHu_rl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mKeHu_rl.loadMoreComplete();

            }
        });

        ed_search1.setIconifiedByDefault(false);

        Class<? extends SearchView> aClass = ed_search1.getClass();
        //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
        Field ownField = null;
        try {
            ownField = aClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(ed_search1);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        ed_search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mDatess.clear();
                adapter2.notifyDataSetChanged();

                bean.setName(query);
                present.findApplyInfo(bean, tokens);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        my_search.setCallBack(new com.ts888.tongshan.tongshan.wedget.SearchView.SearchCallBack() {
//            @Override
//            public void onSearchCallBack(String s) {
//                present.findApplyInfo(bean, tokens);
//            }
//        });
    }

    private void init(View view) {
        bean = new JinJianBean();
        mKeHu_rl = (XRecyclerView) view.findViewById(R.id.kehu_rl);
        ed_search1= (SearchView) view.findViewById(R.id.ed_search1);

        ed_search1.setIconifiedByDefault(false);

//        my_search = (com.ts888.tongshan.tongshan.wedget.SearchView) view.findViewById(R.id.ed_search1);
        present = new Present(this);
    }

    private void initToken() {
        tokens = getArguments().getString("towKey");
        String userCodes = getArguments().getString("key");

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

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getLogin:+进件 " + s);
        Gson gson = new Gson();
        Jinjian2_Bean jinjian2_bean = gson.fromJson(s, Jinjian2_Bean.class);
        String code = jinjian2_bean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + jinjian2_bean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        mDates = jinjian2_bean.getData();
        if (mDates.size() == 0) {
            return;
        }
        mDatess.addAll(mDates);
        adapter2.notifyDataSetChanged();


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
