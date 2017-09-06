package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.MainActivity;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GongGaoAdapter;
import com.ts888.tongshan.tongshan.bean.GongGaoBean;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.x;
import static android.R.id.edit;
import static com.ts888.tongshan.tongshan.R.id.start;
import static com.ts888.tongshan.tongshan.R.id.webView;

public class GongGaoActivity extends AppCompatActivity implements IMainView{
    private Toolbar toolbar;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private SharedPreferences.Editor edit;
    private XRecyclerView xRecyclerView;
    private List<GongGaoBean.DataBean> mDatas=new ArrayList<>();
    private List<GongGaoBean.DataBean> mDatass=new ArrayList<>();
    private GongGaoAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gong_gao);
        initToolBar();

        init();
        xRlView();
    }

    private void xRlView() {

        manager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setAdapter(adapter);


        //=======================================================================
        // 更改刷新 加载 按钮的样式
        //=======================================================================
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);


        //下拉刷新，上拉加载
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mDatas.clear();
                adapter.notifyDataSetChanged();
                present.getIndividualRanking(new LongHuParmsBean(), token);
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRecyclerView.loadMoreComplete();

            }
        });


        adapter.setOnItemClickListener(new GongGaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                Intent intent = new Intent(GongGaoActivity.this,WebActivity.class);
                intent.putExtra("producturl",mDatass.get(pos).getH5Url());
                intent.putExtra("title","公告栏");
                startActivity(intent);
            }
        });

    }

    private void init() {
        present = new Present(this);

        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        edit = sharedPreferences.edit();
        xRecyclerView = (XRecyclerView) findViewById(R.id.rc_gonggao);

        //公告栏
        present.getNoticeInfoList(new LongHuParmsBean(),token);
        adapter=new GongGaoAdapter(this,mDatass);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbars_gonggao);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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
        GongGaoBean gongGaoBean = gson.fromJson(s, GongGaoBean.class);
        String code = gongGaoBean.getCode();
        if (!code.equals("1")){

            if (code.equals("19902")){
                edit.putString("token", "");
                edit.commit();
                Toast.makeText(this, ""+gongGaoBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }

            Toast.makeText(this, ""+gongGaoBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        mDatas = gongGaoBean.getData();
        if (mDatas.size()==0){
            return;
        }

        mDatass.addAll(mDatas);
        adapter.notifyDataSetChanged();


    }
}
