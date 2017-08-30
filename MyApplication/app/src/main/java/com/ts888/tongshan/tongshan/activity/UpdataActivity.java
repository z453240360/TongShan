package com.ts888.tongshan.tongshan.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ApkUpDateParamsBeam;
import com.ts888.tongshan.tongshan.bean.UpDateFromNetBean;
import com.ts888.tongshan.tongshan.constant.Constant;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.updateapkutil.UpdateVersionController;
import com.ts888.tongshan.tongshan.util.ColorState;

import static android.R.attr.data;
import static com.ts888.tongshan.tongshan.R.id.mTxt_versionCode;


/**
 * 更新状态页
 *      点击查询，获取系统的需求更新信息，根据不同字段的信息判断是否需要更新或者强制更新
 */
public class UpdataActivity extends AppCompatActivity implements IMainView {

    private Toolbar toolbar;
    private ApkUpDateParamsBeam beam;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;

    private UpdateVersionController controller = null;
    private ProgressDialog dialog;

    private TextView mTxt_versionCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏颜色为蓝色
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_updata);

        //获取token
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "888888");  //获取存储的token
        dialog = new ProgressDialog(this);

        initToolBar();

        initBean();

        initView();
        //版本更新管理类
        if (null == controller) {
            controller = UpdateVersionController.getInstance(this);
        }

    }

    private void initView() {
        mTxt_versionCode = (TextView) findViewById(R.id.mTxt_versionCode);  //设置版本信息
        mTxt_versionCode.setText(Constant.APPVERSION);
    }


    private void initBean() {
        beam = new ApkUpDateParamsBeam();
        present = new Present(this);
        beam.setVersion(Constant.APPVERSION);//设置版本号
        beam.setChannel(Constant.CHANNEL);//渠道

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbars_guanyu_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
        dialog.dismiss();
    }

    @Override
    public void showFaliure(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getLogin(String s) {

    }

    //主页面登陆 提示更新
    @Override
    public void getUpDate(String s) {
        Gson gson = new Gson();
        UpDateFromNetBean upDateFromNetBean = gson.fromJson(s, UpDateFromNetBean.class);

        String code = upDateFromNetBean.getCode();
        if (!"1".equals(code)){
            Toast.makeText(this, ""+upDateFromNetBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        UpDateFromNetBean.DataBean data = upDateFromNetBean.getData();

        if (data == null) {
            return;
        }
        String md5 = data.getMd5();//md5
        String description = data.getDescription(); //备注test
        int forceUpdate = data.getForceUpdate();//0不强制更新，1，强制更新
        int needUpdate = data.getNeedUpdate();//是否需要更新
        String url = data.getUrl();//测试地址
        String recentVersion = data.getRecentVersion();//当前版本号
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("url", url).commit();

        if (needUpdate == 1) {
            if (forceUpdate==0){
                controller.normalCheckUpdateInfo(url,description);

            }else if(forceUpdate==1){
                controller.forceCheckUpdateInfo(url,description);
            }

        } else {
            Toast.makeText(this, "当前版本：" +"不需要更新", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mBtn_update:

                present.getApkUpdate(beam, token);
                break;
        }

    }




}
