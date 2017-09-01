package com.ts888.tongshan.tongshan.fragment;

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
import com.ts888.tongshan.tongshan.activity.GongGaoActivity;
import com.ts888.tongshan.tongshan.activity.QiandanActivity;
import com.ts888.tongshan.tongshan.bean.BannerResultBean;
import com.ts888.tongshan.tongshan.bean.BannerTypeBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.PicLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mBtn_chanpin;
import static com.ts888.tongshan.tongshan.R.id.mBtn_longhu;
import static com.ts888.tongshan.tongshan.R.id.mBtn_shisuan;


/**
 * Created by dongdong on 2017/7/30.
 * 首页Fragment
 */

public class ShouyeFragment extends Fragment implements IMainView{

    private Button mBtn_jinjian, mBtn_kehu, mBtn_shisuan, mBtn_chanpin, mBtn_longhu, mBtn_yeji,mBtn_qiangdan,mBtn_gonggao;
    private SharedPreferences sharedPreferences;
    private String token;
    private Present present;
    private BannerTypeBean bean;
    private Banner banner;
    private List<String> imgUrls = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences=getActivity().getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        banner = (Banner) view.findViewById(R.id.banner);

        present = new Present(this);
        bean = new BannerTypeBean();
        bean.setType(1);
        present.getBanner(bean, "");

        mBtn_kehu = (Button) view.findViewById(R.id.mBtn_kehu);
        mBtn_jinjian = (Button) view.findViewById(R.id.mBtn_jinjian);
        mBtn_shisuan = (Button) view.findViewById(R.id.mBtn_shisuan);
        mBtn_chanpin = (Button) view.findViewById(R.id.mBtn_chanpin);
        mBtn_longhu = (Button) view.findViewById(R.id.mBtn_longhu);
        mBtn_yeji = (Button) view.findViewById(R.id.mBtn_yeji);
        mBtn_qiangdan=(Button) view.findViewById(R.id.mBtn_qiangdan);
        mBtn_qiangdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), QiandanActivity.class));
            }
        });
        mBtn_gonggao=(Button) view.findViewById(R.id.mBtn_gonggao);
        mBtn_gonggao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GongGaoActivity.class));
            }
        });


        mBtn_kehu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("kehu");
            }
        });
        mBtn_jinjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("jinjian");
            }
        });
        mBtn_shisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("shisuan");
            }
        });
        mBtn_chanpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("chanpinzhongxin");
            }
        });
        mBtn_longhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("longhubang");
            }
        });
        mBtn_yeji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.getText("gerenyeji");
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

    }

    @Override
    public void getLogin(String s) {

    }


    /**
     * 获取首要banner
     * @param s
     */
    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: "+s);
        Gson gson = new Gson();
        BannerResultBean bannerResultBean = gson.fromJson(s, BannerResultBean.class);
        String code = bannerResultBean.getCode();
        if (!"1".equals(code))
        {
            Toast.makeText(getActivity(), ""+bannerResultBean.getMessage(), Toast.LENGTH_SHORT).show();
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

//                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();

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
