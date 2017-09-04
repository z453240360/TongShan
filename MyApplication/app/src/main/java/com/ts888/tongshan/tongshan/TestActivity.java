package com.ts888.tongshan.tongshan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.wedget.ShouyeWedget;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.wed1)
    ShouyeWedget wed1;
    @BindView(R.id.wed2)
    ShouyeWedget wed2;
    @BindView(R.id.wed3)
    ShouyeWedget wed3;
    @BindView(R.id.wed4)
    ShouyeWedget wed4;
    @BindView(R.id.wed5)
    ShouyeWedget wed5;
    @BindView(R.id.wed6)
    ShouyeWedget wed6;
    @BindView(R.id.wed7)
    ShouyeWedget wed7;
    @BindView(R.id.wed8)
    ShouyeWedget wed8;
    @BindView(R.id.wed9)
    ShouyeWedget wed9;

    Present present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        present = new Present(this);


        present.getNoticeInfoList(new LongHuParmsBean(),"");
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

    }
}
