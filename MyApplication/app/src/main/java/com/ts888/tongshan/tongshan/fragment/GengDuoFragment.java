package com.ts888.tongshan.tongshan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by dongdong on 2017/7/30.
 * 业务页显示的第三个按钮对应的页面（更多页面）
 */

public class GengDuoFragment extends Fragment {

    @BindView(R.id.mBtn_updata)
    Button mBtnUpdata;
    @BindView(R.id.img_center)
    ImageView imgCenter;
    @BindView(R.id.mTxt_gerenname)
    TextView mTxtGerenname;
    @BindView(R.id.mTxt_bangding)
    TextView mTxtBangding;
    @BindView(R.id.mTxt_phoneNumber)
    TextView mTxtPhoneNumber;
    @BindView(R.id.mTxt_mendian)
    TextView mTxtMendian;
    @BindView(R.id.mTxt_address)
    TextView mTxtAddress;
    @BindView(R.id.mBtn_bangzhu)
    Button mBtnBangzhu;
    @BindView(R.id.mBtn_women)
    Button mBtnWomen;
    @BindView(R.id.mBtn_tuichu)
    Button mBtnTuichu;
    Unbinder unbinder;
    private Button mBtn_updata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gengduo, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtn_updata = (Button) view.findViewById(R.id.mBtn_updata);

        mBtn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.getText("updata");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtn_updata, R.id.img_center, R.id.mBtn_bangzhu, R.id.mBtn_women, R.id.mBtn_tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_updata:
                break;
            case R.id.img_center:
                break;
            case R.id.mBtn_bangzhu:
                break;
            case R.id.mBtn_women:
                break;
            case R.id.mBtn_tuichu:
                break;
        }
    }


    public interface TextCallBack {
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack) {
        this.callBack = callBack;
    }
}
