package com.ts888.tongshan.tongshan.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.activity.FangKuanActivity;
import com.ts888.tongshan.tongshan.adapter.LikeListAdapter3;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.Jinjian3_bean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.edit;
import static com.ts888.tongshan.tongshan.R.id.ed_search1;

/**
 * Created by Administrator on 2017/7/31.
 * 已放款信息
 */

public class KeHuFragment3 extends Fragment implements IMainView {


    private XRecyclerView mKeHu_rl;
    private Present present;
    private SearchView searchView;
    private String tokens;
    private LinearLayoutManager manager;
    private boolean isFirst=true;
    private JinJianBean jinJianBean;
    private LikeListAdapter3 adapter3;
    private List<Jinjian3_bean.DataBean> mDates=new ArrayList<>();
    private List<Jinjian3_bean.DataBean> mDatess=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kehu3, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tokens = getArguments().getString("towKey");
        String userCodes = getArguments().getString("key");

        mKeHu_rl = (XRecyclerView) view.findViewById(R.id.kehu_rl);
        searchView = (SearchView) view.findViewById(ed_search1);

        present = new Present(this);
        jinJianBean = new JinJianBean();
        //放款查询
        present.findLoanInfo(jinJianBean,tokens);
        adapter3=new LikeListAdapter3(getActivity(),mDatess);



//        //Recylerview加载数据
        mKeHu_rl.setAdapter(adapter3);
        manager = new LinearLayoutManager(getActivity());
        mKeHu_rl.setLayoutManager(manager);
        adapter3.setOnItemClickListener(new LikeListAdapter3.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                Jinjian3_bean.DataBean dataBean = mDatess.get(pos);
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

        //下拉刷新，上拉加载
        mKeHu_rl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mDatess.clear();
                adapter3.notifyDataSetChanged();
                jinJianBean.setName(searchView.getQuery().toString());
                present.findLoanInfo(jinJianBean,tokens);
                mKeHu_rl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mKeHu_rl.loadMoreComplete();
            }
        });

        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();
        Class<? extends SearchView> aClass = searchView.getClass();
        //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
        Field ownField = null;
        try {
            ownField = aClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(searchView);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mDatess.clear();
                adapter3.notifyDataSetChanged();

                jinJianBean.setName(s);
                present.findLoanInfo(jinJianBean,tokens);
                mKeHu_rl.refreshComplete();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mDatess.clear();
                adapter3.notifyDataSetChanged();

                jinJianBean.setName(s);
                present.findLoanInfo(jinJianBean,tokens);
                mKeHu_rl.refreshComplete();
                return false;
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

    }

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getLogin:放款 "+s);
        Gson gson = new Gson();
        Jinjian3_bean jinjian3_bean = gson.fromJson(s, Jinjian3_bean.class);
        String code = jinjian3_bean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + jinjian3_bean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        mDates = jinjian3_bean.getData();
        if (mDates.size()==0){
            return;
        }
        mDatess.addAll(mDates);
        adapter3.notifyDataSetChanged();
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
