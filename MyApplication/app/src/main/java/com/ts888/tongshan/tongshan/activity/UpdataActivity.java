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
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ApkUpDateParamsBeam;
import com.ts888.tongshan.tongshan.bean.UpDateFromNetBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.updateapkutil.UpdateVersionController;
import com.ts888.tongshan.tongshan.util.ColorState;

public class UpdataActivity extends AppCompatActivity implements IMainView {

    private Toolbar toolbar;
    private ApkUpDateParamsBeam beam;
    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;

    private UpdateVersionController controller = null;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_updata);
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "888888");              //获取存储的token
        dialog = new ProgressDialog(this);

        initToolBar();

        initBean();

        if (null == controller) {
            controller = UpdateVersionController.getInstance(this);
        }

    }


    private void initBean() {

        beam = new ApkUpDateParamsBeam();
        present = new Present(this);
        beam.setVersion("1.0.0");//设置版本好
        beam.setChannel("xscxapp");//渠道

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
        Log.i("dd", "getCode: " + s);

        Gson gson = new Gson();
        UpDateFromNetBean upDateFromNetBean = gson.fromJson(s, UpDateFromNetBean.class);

        UpDateFromNetBean.DataBean data = upDateFromNetBean.getData();

        if (data == null) {
            return;
        }
        String md5 = data.getMd5();//md5
        String description = data.getDescription(); //备注test
        int forceUpdate = data.getForceUpdate();//不强制更新，1，强制更新
        int needUpdate = data.getNeedUpdate();//是否需要更新
        String url = data.getUrl();//测试地址
        String recentVersion = data.getRecentVersion();//当前版本号
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("url", url).commit();

        if (needUpdate == 1) {
            if (forceUpdate==0){
                controller.normalCheckUpdateInfo(url);

            }else if(forceUpdate==1){
                controller.forceCheckUpdateInfo(url);
            }

        } else {
            Toast.makeText(this, "当前版本：" + recentVersion + "不需要更新", Toast.LENGTH_SHORT).show();
        }

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

    }

    @Override
    public void getLogin(String s) {

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
