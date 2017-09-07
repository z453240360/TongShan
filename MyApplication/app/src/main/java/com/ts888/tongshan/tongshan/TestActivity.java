package com.ts888.tongshan.tongshan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.wedget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements IMainView {


    Present present;
    @BindView(R.id.test)
    TextView test;
    @BindView(R.id.search)
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        present = new Present(this);
        present.getNoticeInfoList(new LongHuParmsBean(), "");
        
        search.setCallBack(new SearchView.SearchCallBack() {
            @Override
            public void onSearchCallBack(String s) {
                Toast.makeText(TestActivity.this, ""+s, Toast.LENGTH_SHORT).show();
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

    @Override
    public void getUpDate(String s) {

    }
}
