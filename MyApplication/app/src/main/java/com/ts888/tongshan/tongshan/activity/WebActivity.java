package com.ts888.tongshan.tongshan.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.util.ColorState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.activity_web)
    RelativeLayout activityWeb;
    private String url;
    private Intent intent;
    private String title;
    private Toolbar toolbar;
    private TextView mTxt_xiangqing_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web);
        inittoolbar();
        ButterKnife.bind(this);
        intent = getIntent();

        //设置WebView的一些常用属性
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //支持Javascript代码
        webSettings.setDefaultTextEncodingName("utf-8"); //设置默认编码集 utf-8

        //自适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        url = intent.getStringExtra("producturl");  //网址
        title = intent.getStringExtra("title"); // 标题
        mTxt_xiangqing_web.setText(title);
        loadUrl(url);
    }

    private void inittoolbar() {
        mTxt_xiangqing_web = (TextView) findViewById(R.id.mTxt_xiangqing_web);
        toolbar = (Toolbar) findViewById(R.id.toolbars_web);
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

}
