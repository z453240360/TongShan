package com.ts888.tongshan.tongshan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.activity.ShiSuanActivity;
import com.ts888.tongshan.tongshan.activity.YeWuActivity;
import com.ts888.tongshan.tongshan.bean.ApkUpDateParamsBeam;
import com.ts888.tongshan.tongshan.bean.CodeDataBean;
import com.ts888.tongshan.tongshan.bean.LoginBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.UpDateFromNetBean;
import com.ts888.tongshan.tongshan.constant.Constant;
import com.ts888.tongshan.tongshan.model.ICallBack;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.updateapkutil.UpdateVersionController;
import com.ts888.tongshan.tongshan.util.ColorState;

import static android.R.attr.data;
import static com.ts888.tongshan.tongshan.R.id.mEd_user_password;

/**
 * 主登陆页面
 *      1  发送网络请求，查看更新与否 ， 更新后重新安装------getUpDate();
 *      2  发送验证码，验证码初期是自动设置到输入框内 -------getCode（）
 *      3  登陆请求，登陆成功后跳转，不成功Toast提示 -------getLogin();
 */

public class MainActivity extends AppCompatActivity implements IMainView {

    private Present present;
    private String TAG = "dd";
    private String phoneNo;
    private ProgressDialog dialog;
    private ApkUpDateParamsBeam beam;
    private RelativeLayout activity_main;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private UpdateVersionController controller;
    private EditText mEd_phoneNumber, mEd_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏字体为黑色
        ColorState.StatusBarLightMode(this);
        //状态栏颜色为白色
        ColorState.setWindowStatusBarColor(this, Color.WHITE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //设置无标题栏
        setContentView(R.layout.activity_main);


        init();

        initUpdate();
    }

    private void initUpdate() {
            beam = new ApkUpDateParamsBeam();    //初始化App更新参数Bean对象
            beam.setVersion(Constant.APPVERSION);//设置版本好
            beam.setChannel(Constant.CHANNEL);//渠道
        if (null == controller) {
            controller = UpdateVersionController.getInstance(this);  //创建App更新管理类
        }
        present.getApkUpdate(beam,null);    //发送更新请求
    }

    private void init() {

        dialog = new ProgressDialog(this);//初始化加载框
        present = new Present(this);  //初始化请求逻辑管理类
        mEd_phoneNumber = (EditText) findViewById(R.id.mEd_user_phoneNumber);  //电话号码输入框
        mEd_code = (EditText) findViewById(mEd_user_password);                 //验证码输入框
        //mEd_phoneNumber.setText("18616850003");
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);  //数据存储初始化
        editor = sharedPreferences.edit();

        //设置点击空白处，自动隐藏键盘
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        activity_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                return manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {

            //获取验证码
            case R.id.mBtn_getPassword:
                //当键盘显示时，点击按钮会自动隐藏键盘
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        MainActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                //请求参数管理类
                ParmsBean parmsBean1 = new ParmsBean();
                //获取输入的电话号码
                phoneNo = mEd_phoneNumber.getText().toString().trim();
                if (null == phoneNo) {
                    Toast.makeText(this, "输入的号码有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                //获取验证码
                parmsBean1.setPhoneNo(phoneNo);
                //发送网络请求，请求验证码
                present.loadData(parmsBean1);

                break;

            //登陆点击时间
            case R.id.mBtn_logIn:
                ParmsBean parmsBean2 = new ParmsBean();

                String verifyCode = mEd_code.getText().toString().trim();
                if (null == phoneNo || null == verifyCode) {
                    Toast.makeText(this, "输入的号码有误", Toast.LENGTH_SHORT).show();
                }
                //登陆账号
                parmsBean2.setPhoneNo(phoneNo);
                parmsBean2.setVerifyCode(verifyCode);
                //发送登陆请求
                present.login(parmsBean2);

                break;
        }
    }

    //获取验证码
    @Override
    public void getCode(String s) {
        Gson g = new Gson();
        CodeDataBean codeDataBean = g.fromJson(s, CodeDataBean.class);
        //获得返回的验证码
        String data = codeDataBean.getData();
        if (data == null) {
            Toast.makeText(this, "" + codeDataBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        mEd_code.setText(data);
        Log.i(TAG, "getCode: ");

    }

    @Override
    public void showLoading() {
        dialog.show();

    }

    @Override
    public void cancelLoading() {
        //退出加载框
        dialog.dismiss();

    }

    //网络请求失败时候调用
    @Override
    public void showFaliure(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    //登陆请求
    @Override
    public void getLogin(String s) {
        Gson g = new Gson();
        LoginBean loginBean = g.fromJson(s, LoginBean.class);

        String code = loginBean.getCode();
        if (!code .equals("1")) {
            Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        String token = loginBean.getData().getToken();      //token
        String userCode = loginBean.getData().getUserCode();  //用户码
        //本地缓存
        editor.putString("userCode",userCode);
        editor.putString("token",token);
        editor.putString("phoneNo",loginBean.getData().getPhoneNo());
        editor.commit();
        dialog.dismiss();
        mEd_code.setText("");
        //成功跳转到业务界面
        startActivity(new Intent(MainActivity.this, YeWuActivity.class));

    }

    //APP更新与否判断
    @Override
    public void getUpDate(String s) {
        Log.i(TAG, "getUpDate: "+s);
        Gson gson = new Gson();
        UpDateFromNetBean upDateFromNetBean = gson.fromJson(s, UpDateFromNetBean.class);
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
                controller.normalCheckUpdateInfo(url);

            }else if(forceUpdate==1){
                controller.forceCheckUpdateInfo(url);
            }

        } else {
            Toast.makeText(this, "当前版本：" + recentVersion + "不需要更新", Toast.LENGTH_SHORT).show();
        }

    }
}
