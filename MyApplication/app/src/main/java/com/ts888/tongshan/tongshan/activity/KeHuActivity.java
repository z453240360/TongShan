package com.ts888.tongshan.tongshan.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.fragment.KeHuFragment;
import com.ts888.tongshan.tongshan.fragment.ShouyeFragment;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

/**
 * 客户界面
 *      通过radiobutton 加载三个对应的Fragment，在Fragment中处理主要的逻辑及显示信息问题
 *
 *
 */

public class KeHuActivity extends AppCompatActivity implements IMainView{

    private String TAG ="dd";
    private RadioGroup mRg_KeHu;
    private FragmentManager manager;
    private Present present;
    private ParmsBean parmsBean;
    private SharedPreferences sharedPreferences;
    private String token;
    private Toolbar toolbar;
    private SearchView searchView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏及标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ke_hu);
        //加载框
        dialog = new ProgressDialog(this);
        //初始化控件searchView
        searchView = (SearchView) findViewById(R.id.searchView);
        mRg_KeHu = (RadioGroup) findViewById(R.id.mRg_kehu);
        ImageView searchButton = (ImageView)searchView.findViewById(R.id.search_button);
        toolbar = (Toolbar) findViewById(R.id.toolbars_kehu_activity);

        searchButton.setImageResource(R.mipmap.sousuo);
        //设置toolbar
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //获取用户码和token
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        String userCode = sharedPreferences.getString("userCode","88888");
        token = sharedPreferences.getString("token", "888888");
        //初始化参数以及网络逻辑类
        present = new Present(this);
        parmsBean = new ParmsBean();
        parmsBean.setUserCode(userCode);
        //发送网络请求，获取客户基本信息
        present.getFindUserBaseInfoByCode(parmsBean,token);//用户基本信息
        //Fragent管理类
        manager = getSupportFragmentManager();
        //初始化客户基本信息碎片，传入用户码和token
        KeHuFragment keHuFragment = new KeHuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",userCode);
        bundle.putString("towKey",token);
        keHuFragment.setArguments(bundle);

        manager.beginTransaction().replace(R.id.mFl_kehu, keHuFragment).commit();
        //设置点击回调监听，跳转到详情界面，获取客户详情列表
        keHuFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                Log.i(TAG, "getText获取usecode: "+str);

                Intent intent = new Intent(KeHuActivity.this,XiangQingActivity.class);
//                parmsBean.setUserCode("TS_20170614103419437225140");

                intent.putExtra("useC",str);  //这里获取的useCode不能查询到相关信息
                intent.putExtra("token",token);
                startActivity(intent);
            }
        });

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
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {
    }

    @Override
    public void getUpDate(String s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



    //点击标题栏的返回按钮
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
