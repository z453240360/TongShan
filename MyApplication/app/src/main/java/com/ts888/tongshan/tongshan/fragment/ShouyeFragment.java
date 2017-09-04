package com.ts888.tongshan.tongshan.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.activity.GeRenYeJiActivity;
import com.ts888.tongshan.tongshan.activity.GongGaoActivity;
import com.ts888.tongshan.tongshan.activity.JinjianActivity;
import com.ts888.tongshan.tongshan.activity.KeHuActivity;
import com.ts888.tongshan.tongshan.activity.LongHuBangActivity;
import com.ts888.tongshan.tongshan.activity.ProductCenterActivity;
import com.ts888.tongshan.tongshan.activity.QiandanActivity;
import com.ts888.tongshan.tongshan.activity.ShiSuanActivity;
import com.ts888.tongshan.tongshan.bean.BannerResultBean;
import com.ts888.tongshan.tongshan.bean.BannerTypeBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.PicLoader;
import com.ts888.tongshan.tongshan.wedget.ShouyeWedget;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by dongdong on 2017/7/30.
 * 首页Fragment
 */

public class ShouyeFragment extends Fragment implements IMainView {

    private ShouyeWedget wed1,wed2,wed3,wed4,wed5,wed6,wed7,wed8,wed9;
    private SharedPreferences sharedPreferences;
    private String token;
    private Present present;
    private BannerTypeBean bean;
    private Banner banner;
    private List<String> imgUrls = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        banner = (Banner) view.findViewById(R.id.banner);

        present = new Present(this);
        bean = new BannerTypeBean();
        bean.setType(1);
        present.getBanner(bean, "");

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

        wed1 = (ShouyeWedget) view.findViewById(R.id.wed1);//进见
        wed2 = (ShouyeWedget) view.findViewById(R.id.wed2);//客户
        wed3 = (ShouyeWedget) view.findViewById(R.id.wed3);//审批
        wed4 = (ShouyeWedget) view.findViewById(R.id.wed4);//枪弹
        wed5 = (ShouyeWedget) view.findViewById(R.id.wed5);//失算
        wed6 = (ShouyeWedget) view.findViewById(R.id.wed6);//个人业绩
        wed7 = (ShouyeWedget) view.findViewById(R.id.wed7);//龙虎榜
        wed8 = (ShouyeWedget) view.findViewById(R.id.wed8);//公告栏
        wed9 = (ShouyeWedget) view.findViewById(R.id.wed9);//产品中心

        wed4.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QiandanActivity.class));
            }
        });
        wed8.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GongGaoActivity.class));
            }
        });

        wed2.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), KeHuActivity.class));
            }
        });
        wed1.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JinjianActivity.class));
            }
        });

        wed5.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShiSuanActivity.class));
            }
        });

        wed9.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProductCenterActivity.class));
            }
        });

        wed7.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LongHuBangActivity.class));
            }
        });

        wed6.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GeRenYeJiActivity.class));
            }
        });



    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {
//        dialog.show();
    }

    @Override
    public void cancelLoading() {
//        dialog.cancel();
    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }


    /**
     * 获取首要banner
     *
     * @param s
     */
    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: " + s);
        Gson gson = new Gson();
        BannerResultBean bannerResultBean = gson.fromJson(s, BannerResultBean.class);
        String code = bannerResultBean.getCode();
        if (!"1".equals(code)) {
            Toast.makeText(getActivity(), "" + bannerResultBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        List<BannerResultBean.DataBean> data = bannerResultBean.getData();

        for (int i = 0; i < data.size(); i++) {
            BannerResultBean.DataBean dataBean = data.get(i);
            String imgUrl = dataBean.getImgUrl();
            String title = dataBean.getTitle();
            titles.add(title);
            imgUrls.add(imgUrl);
        }

        banner.setImageLoader(new PicLoader());
        banner.setImages(imgUrls);
        banner.isAutoPlay(true);
//        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
//        banner.setBannerAnimation(Transformer.FlipHorizontal);
        banner.setDelayTime(2000);
//        banner.setBannerTitles(titles);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();


            }
        });


    }


    public interface TextCallBack {
        void getText(String str);
    }

    private TextCallBack callBack;

    public void setCallBack(TextCallBack callBack) {
        this.callBack = callBack;
    }


}
