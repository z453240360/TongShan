package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.RadioGroup;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.fragment.KeHuFragment;
import com.ts888.tongshan.tongshan.fragment.ShouyeFragment;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;

public class KeHuActivity extends AppCompatActivity implements IMainView{

    private String TAG ="dd";
    private RadioGroup mRg_KeHu;
    private FragmentManager manager;
    private Present present;
    private ParmsBean parmsBean;
    private SharedPreferences sharedPreferences;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ke_hu);

        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        String userCode = sharedPreferences.getString("userCode","88888");
        token = sharedPreferences.getString("token", "888888");
        present = new Present(this);
        parmsBean = new ParmsBean();
//
        parmsBean.setUserCode("TS_20170614103419437225140");

//        parmsBean.setUserCode(userCode);
        present.getFindUserBaseInfoByCode(parmsBean,token);//用户基本信息

//        present.getFindScheduleByCode(parmsBean,token); //用户认证进度
//
//        parmsBean.setPage(1);
//        parmsBean.setRows(1);
//        present.getFindInApprovalApplyInfo(parmsBean,token);

        mRg_KeHu = (RadioGroup) findViewById(R.id.mRg_kehu);

        manager = getSupportFragmentManager();
//        manager.beginTransaction().add(R.id.mFl_kehu, new KeHuFragment()).commit();

        KeHuFragment keHuFragment = new KeHuFragment();
        Bundle bundle = new Bundle();


        bundle.putString("key",userCode);
        bundle.putString("towKey",token);
        keHuFragment.setArguments(bundle);

        manager.beginTransaction().add(R.id.mFl_kehu, keHuFragment).commit();

        keHuFragment.setCallBack(new ShouyeFragment.TextCallBack() {
            @Override
            public void getText(String str) {
                Log.i(TAG, "getText获取usecode: "+str);

                Intent intent = new Intent(KeHuActivity.this,XiangQingActivity.class);
                intent.putExtra("useC",str);
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

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {
        Log.i(TAG, "getLogin55555: "+s);
    }
}
