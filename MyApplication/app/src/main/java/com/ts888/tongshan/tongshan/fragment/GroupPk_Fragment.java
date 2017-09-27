package com.ts888.tongshan.tongshan.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GroupPKBean;
import com.ts888.tongshan.tongshan.bean.PKParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ShowTostUtil;
import com.ts888.tongshan.tongshan.wedget.PKText;
import com.ts888.tongshan.tongshan.wedget.PK_RangeText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.data;
import static android.R.attr.focusable;
import static android.R.attr.max;
import static android.R.attr.switchMinWidth;
import static android.R.attr.value;


/**
 * Created by dongdong on 2017/7/30.
 */

public class GroupPk_Fragment extends Fragment implements IMainView {

    @BindView(R.id.PK1)
    PKText PK1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.PK2)
    PKText PK2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.PK3)
    PKText PK3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.PK4)
    PKText PK4;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.PK5)
    PKText PK5;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.range1)
    PK_RangeText range1;
    @BindView(R.id.range2)
    PK_RangeText range2;
    @BindView(R.id.range3)
    PK_RangeText range3;
    @BindView(R.id.range4)
    PK_RangeText range4;
    @BindView(R.id.range5)
    PK_RangeText range5;
    Unbinder unbinder;

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private PKParmsBean bean;
    private List<GroupPKBean.DataBean> mDatas;
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Integer> maxMap = new HashMap<>();
    private ArrayList<Integer> value = new ArrayList<>();
    private String maxHeight = "";
    private int heightTotal;
    private Integer maxNum;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grouppk, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        heightTotal = getActivity().getResources().getDisplayMetrics().heightPixels;//获取屏幕高度
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        bean = new PKParmsBean();
        present.getTeamResults(bean, token);//团队PK
    }

    //获取团队PK数据
    @Override
    public void getCode(String s) {
        Log.i("dd", "团队PK: " + s);
        Gson gson = new Gson();
        GroupPKBean groupPKBean = gson.fromJson(s, GroupPKBean.class);
        String code = groupPKBean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + groupPKBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        mDatas = groupPKBean.getData();
        if (mDatas.size() == 0) {
            ShowTostUtil.toast(getActivity(), "没有参考数据");
            return;
        }

        for (int i = 0; i < mDatas.size(); i++) {
            int results = mDatas.get(i).getResults();
            value.add(results);
            map.put(results, i);
            maxMap.put(i, results);
            setName(i);
        }

        Collections.sort(value);

        maxNum = map.get(value.get(value.size() - 1));


        for (int i = 0; i < value.size(); i++) {
            setRange(i);
        }


        int maxValueIndex = setHeight(maxNum);
        if (maxValueIndex < 0) {
            return;
        }


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
        Log.i("dd", "团队PK2: " + s);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //设置柱状列表的显示的元宝数额和对应的地区
    private void setName(int s) {
        switch (s) {
            case 0:
                ll1.setVisibility(View.VISIBLE);
                range1.setVisibility(View.VISIBLE);
                PK1.getText_money().setText(mDatas.get(0).getResults() + "");//设置显示金额
                PK1.getTxt_area().setText(mDatas.get(0).getTeamName());//所属地区
                break;

            case 1:
                ll2.setVisibility(View.VISIBLE);
                range2.setVisibility(View.VISIBLE);
                PK2.getText_money().setText(mDatas.get(1).getResults() + "");//设置显示金额
                PK2.getTxt_area().setText(mDatas.get(1).getTeamName());//所属地区
                break;

            case 2:
                ll3.setVisibility(View.VISIBLE);
                range3.setVisibility(View.VISIBLE);
                PK3.getText_money().setText(mDatas.get(2).getResults() + "");//设置显示金额
                PK3.getTxt_area().setText(mDatas.get(2).getTeamName());//所属地区

                break;

            case 3:
                ll4.setVisibility(View.VISIBLE);
                range4.setVisibility(View.VISIBLE);
                PK4.getText_money().setText(mDatas.get(3).getResults() + "");//设置显示金额
                PK4.getTxt_area().setText(mDatas.get(3).getTeamName());//所属地区
                break;


            case 4:

                ll5.setVisibility(View.VISIBLE);
                range5.setVisibility(View.VISIBLE);
                PK5.getText_money().setText(mDatas.get(4).getResults() + "");//设置显示金额
                PK5.getTxt_area().setText(mDatas.get(4).getTeamName());//所属地区
                break;

        }
    }

    //返回最大值对应的满高度
    private int setHeight(int heightNum) {
        switch (heightNum) {
            case 0:
                PK1.setTextHeight(setOtherHeight(heightNum, 0));
                PK2.setTextHeight(setOtherHeight(heightNum, 1));
                PK3.setTextHeight(setOtherHeight(heightNum, 2));
                PK4.setTextHeight(setOtherHeight(heightNum, 3));
                PK5.setTextHeight(setOtherHeight(heightNum, 4));
                return 0;

            case 1:

                PK1.setTextHeight(setOtherHeight(heightNum, 0));
                PK2.setTextHeight(setOtherHeight(heightNum, 1));
                PK3.setTextHeight(setOtherHeight(heightNum, 2));
                PK4.setTextHeight(setOtherHeight(heightNum, 3));
                PK5.setTextHeight(setOtherHeight(heightNum, 4));
                return 1;

            case 2:


                PK1.setTextHeight(setOtherHeight(heightNum, 0));
                PK2.setTextHeight(setOtherHeight(heightNum, 1));
                PK3.setTextHeight(setOtherHeight(heightNum, 2));
                PK4.setTextHeight(setOtherHeight(heightNum, 3));
                PK5.setTextHeight(setOtherHeight(heightNum, 4));
                return 2;

            case 3:

                PK1.setTextHeight(setOtherHeight(heightNum, 0));
                PK2.setTextHeight(setOtherHeight(heightNum, 1));
                PK3.setTextHeight(setOtherHeight(heightNum, 2));
                PK4.setTextHeight(setOtherHeight(heightNum, 3));
                PK5.setTextHeight(setOtherHeight(heightNum, 4));
                return 3;
            case 4:

                PK1.setTextHeight(setOtherHeight(heightNum, 0));
                PK2.setTextHeight(setOtherHeight(heightNum, 1));
                PK3.setTextHeight(setOtherHeight(heightNum, 2));
                PK4.setTextHeight(setOtherHeight(heightNum, 3));
                PK5.setTextHeight(setOtherHeight(heightNum, 4));
                return 4;
        }

        return -1;
    }

    //设置其他柱体的高度
    private int setOtherHeight(int maxIndex, int otherNumIndex) {
        if (otherNumIndex < mDatas.size()) {
            if (otherNumIndex != maxIndex) {
                double maxResults = (double) mDatas.get(maxIndex).getResults();
                double otherResults = (double) mDatas.get(otherNumIndex).getResults();
                double radio = otherResults / maxResults;
                return (int) (heightTotal / 3.5 * radio);
            }
            return (int) (heightTotal / 3.5);
        }
        return 0;
    }

    //设置底部显示的排名信息
    private void setRange(int index) {
        if (index >= value.size()) {
            return;
        }
        switch (index) {
            case 0:
                range1.getmTxt_rangeName().setText(mDatas.get(map.get(value.get(value.size() - 1 - index))).getTeamName());//团队名称
                break;
            case 1:
                range2.getmTxt_rangeName().setText(mDatas.get(map.get(value.get(value.size() - 1 - index))).getTeamName());//团队名称
                break;
            case 2:
                range3.getmTxt_rangeName().setText(mDatas.get(map.get(value.get(value.size() - 1 - index))).getTeamName());//团队名称
                break;
            case 3:
                range4.getmTxt_rangeName().setText(mDatas.get(map.get(value.get(value.size() - 1 - index))).getTeamName());//团队名称
                break;
            case 4:
                range5.getmTxt_rangeName().setText(mDatas.get(map.get(value.get(value.size() - 1 - index))).getTeamName());//团队名称
                break;
        }
    }

}
