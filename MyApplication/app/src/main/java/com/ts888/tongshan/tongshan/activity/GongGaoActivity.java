package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

public class GongGaoActivity extends AppCompatActivity implements IMainView{
    private Toolbar toolbar;
    private WebView webView;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gong_gao);

        init();
        initView();
        initToolBar();
        loadUrl("");
    }

    private void init() {
        present = new Present(this);
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");

        //
        present.getNoticeInfoList(new LongHuParmsBean(),token);
    }

    private void initView() {
        webView= (WebView) findViewById(R.id.webView_gonggao);

        //设置WebView的一些常用属性
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //支持Javascript代码
        webSettings.setDefaultTextEncodingName("utf-8"); //设置默认编码集 utf-8
        //自适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbars_gonggao);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void loadUrl(String url) {
        webView.loadUrl(url);
        //辅助 WebView 处理各种通知、请求事件等
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            // 当前网页的所有内容,都在webview上去展示,并不会重新开启新的浏览器。
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true; //注意这里改为true
            }
        });


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
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}
