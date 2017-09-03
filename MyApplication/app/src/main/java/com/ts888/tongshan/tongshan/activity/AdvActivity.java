package com.ts888.tongshan.tongshan.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.BannerResultBean;
import com.ts888.tongshan.tongshan.bean.BannerTypeBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private BannerTypeBean bean;
    private Present present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);
        ButterKnife.bind(this);

        present = new Present(this);
        bean = new BannerTypeBean();
        bean.setType(0);

        present.getBanner(bean,"");

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

    @Override
    public void getUpDate(String s) {
        Log.i("dd", "getUpDate: "+s);
        Gson gson = new Gson();
        BannerResultBean bannerResultBean = gson.fromJson(s, BannerResultBean.class);
        String code = bannerResultBean.getCode();
        if (!"1".equals(code))
        {
            Toast.makeText(this, ""+bannerResultBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        List<BannerResultBean.DataBean> data = bannerResultBean.getData();

        for (int i = 0; i < data.size(); i++) {
            BannerResultBean.DataBean dataBean = data.get(i);
            String imgUrl = dataBean.getImgUrl();
            String title = dataBean.getTitle();
        }
    }
}
