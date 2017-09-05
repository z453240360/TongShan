package com.ts888.tongshan.tongshan.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.UserBaseInfoBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

import static android.R.attr.data;
import static com.ts888.tongshan.tongshan.R.id.view;

/**
 * Created by Administrator on 2017/8/1.
 * 基础信息展示页面 *
 */

public class JichuXinXiFragment extends Fragment implements IMainView {

    private Present present;
    private ParmsBean parmsBean;
    private ProgressDialog dialog;
    private TextView mTxt_shenfenid, mTxt_jiekuanname2, mTxt_shouji2, mTxt_jine2, mTxt_hunyin2, mTxt_xueli2, mTxt_dizhi2, mTxt_xinzhi2, mTxt_danwei2, mTxt_danweidianhua2, mTxt_xingzhi2, mTxt_zhiji2, mTxt_ruzhi2, mTxt_dangyue, mTxt_danweidizhi2, mTxt_dangyue2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xiangqing, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String useC = getArguments().getString("useC");
        String token = getArguments().getString("token");
        dialog = new ProgressDialog(getActivity());
        Log.i("dd", "onViewCreated: " + useC + token);
        mTxt_shenfenid = (TextView) view.findViewById(R.id.mTxt_shenfenid);


//        mTxt_jine2 = (TextView) view.findViewById(R.id.mTxt_jine2);
        mTxt_xueli2 = (TextView) view.findViewById(R.id.mTxt_xueli2);
        mTxt_dizhi2 = (TextView) view.findViewById(R.id.mTxt_dizhi2);
        mTxt_ruzhi2 = (TextView) view.findViewById(R.id.mTxt_ruzhi2);
        mTxt_zhiji2 = (TextView) view.findViewById(R.id.mTxt_zhiji2);
        mTxt_hunyin2 = (TextView) view.findViewById(R.id.mTxt_hunyin2);
        mTxt_dangyue = (TextView) view.findViewById(R.id.mTxt_dangyue);
        mTxt_xinzhi2 = (TextView) view.findViewById(R.id.mTxt_xinzhi2);
        mTxt_danwei2 = (TextView) view.findViewById(R.id.mTxt_danwei2);
        mTxt_shouji2 = (TextView) view.findViewById(R.id.mTxt_shouji2);
        mTxt_dangyue2 = (TextView) view.findViewById(R.id.mTxt_dangyue2);
        mTxt_xingzhi2 = (TextView) view.findViewById(R.id.mTxt_xingzhi2);
        mTxt_danweidizhi2 = (TextView) view.findViewById(R.id.mTxt_danweidizhi2);
        mTxt_jiekuanname2 = (TextView) view.findViewById(R.id.mTxt_jiekuanname2);
        mTxt_danweidianhua2 = (TextView) view.findViewById(R.id.mTxt_danweidianhua2);

        mTxt_dizhi2.setMovementMethod(ScrollingMovementMethod.getInstance());
        mTxt_danweidizhi2.setMovementMethod(ScrollingMovementMethod.getInstance());
        mTxt_dizhi2.setHorizontallyScrolling(true);
        mTxt_danweidizhi2.setHorizontallyScrolling(true);
        parmsBean = new ParmsBean();
        parmsBean.setUserCode(useC);
//        parmsBean.setUserCode("TS_20170614103419437225140");


        present = new Present(this);

        present.getFindUserBaseInfoByCode(parmsBean, token);


    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void cancelLoading() {
        dialog.cancel();
    }

    @Override
    public void showFaliure(String s) {
        Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {
        Log.i("dd", "getLogin:____________ " + s);

        Gson gson = new Gson();
        UserBaseInfoBean userBaseInfoBean = gson.fromJson(s, UserBaseInfoBean.class);

        String code = userBaseInfoBean.getCode();
        if (!code.equals("1")){
            Toast.makeText(getActivity(), ""+userBaseInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        UserBaseInfoBean.DataBean data = userBaseInfoBean.getData();

        if (data == null) {
            return;
        }

        String dizhi2 = data.getResidenceProvinceName() + data.getResidenceCityName() + data.getResidenceRegionName() + data.getResidenceAddress();
        if (dizhi2 .equals("nullnullnullnull")) {
            dizhi2="";
        }
        String danweidizhi2 = data.getJobCompanyProvinceName() + data.getJobCompanyCityName() + data.getJobCompanyRegionName() + data.getJobCompanyAddress();

        if (danweidizhi2 .equals("nullnullnullnull")) {
            danweidizhi2="";
        }

        mTxt_shenfenid.setText(data.getUserName());
        mTxt_jiekuanname2.setText(data.getIdCard());
        mTxt_shouji2.setText(data.getRegisterPhoneNo());
        mTxt_hunyin2.setText(data.getMarriageName());
        mTxt_xueli2.setText(data.getDegreeName());
        mTxt_dizhi2.setText(dizhi2);
        mTxt_xinzhi2.setText(data.getResidenceConditionName());
        mTxt_danwei2.setText(data.getJobCompanyName());
        mTxt_danweidianhua2.setText(data.getJobCompanyPhone());
        mTxt_xingzhi2.setText(data.getJobCompanyConditionName());
        mTxt_zhiji2.setText(data.getCurrJobSeniorityName());
        mTxt_ruzhi2.setText(data.getEntryDate());
        mTxt_dangyue2.setText(data.getMonthSalaryName());
        mTxt_danweidizhi2.setText(danweidizhi2);
    }

    @Override
    public void getUpDate(String s) {

    }
}
