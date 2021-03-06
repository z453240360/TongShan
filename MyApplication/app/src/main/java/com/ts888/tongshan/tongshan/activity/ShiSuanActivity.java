package com.ts888.tongshan.tongshan.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.bean.ShiSuanDataBean;
import com.ts888.tongshan.tongshan.bean.ShisuanParmBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;
import com.ts888.tongshan.tongshan.util.DataFormatFromInt;
import com.ts888.tongshan.tongshan.util.EditTextUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;
import static android.R.id.edit;
import static android.R.id.list;
import static com.ts888.tongshan.tongshan.R.id.mTxt_qixian2;

/**
 * 试算页面
 *      初始发送试算信息参数请求，请求结果设置到Spinner内，留待查询时候选择使用
 *      点击按钮获取下拉框中的参数，作为请求参数，发送网络请求，结果分别设置到对应的位置
 *
 */
public class ShiSuanActivity extends AppCompatActivity implements IMainView {

    private int period;
    private int applyAmt;
    private String token;
    private Toolbar toolbar;
    private Present present;
    private EditText mEd_jine;
    private String productCode;
    private ParmsBean parmsBean;
    private List<Integer> periods;
    private ProgressDialog dialog;
    private Map<String, String> map;
    private ScrollView activity_shi_suan;
    private Spinner mSpinner1, mSpeener2;
    private ArrayAdapter<Integer> adapter;
    private ArrayAdapter<String> adapter2;
    private SharedPreferences sharedPreferences;
    private FindCalcParameterBean calcParameterBean;
    private TextView mTxt_feilv2, mTxt_qixian2, mTxt_daoshou2, mTxt_hetong2, mTxt_meiyue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏和标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shi_suan);

        //设置软键盘适应输入框位置
        activity_shi_suan = (ScrollView)findViewById(R.id.activity_shi_suan);
        activity_shi_suan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                return manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
            }
        });

        initToolBar();
        initView();
        initBean();
        initCode();
    }

    //点击查询后返回数据
    @Override
    public void getCode(String s) {
        Gson g = new Gson();
        ShiSuanDataBean shiSuanDataBean = g.fromJson(s, ShiSuanDataBean.class);

        String code = shiSuanDataBean.getCode();
        if (!code.equals("1"))
        {
            Toast.makeText(this, ""+shiSuanDataBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        ShiSuanDataBean.DataBean data = shiSuanDataBean.getData();

        if (data==null){
            Toast.makeText(this, shiSuanDataBean.getMessage()+"", Toast.LENGTH_SHORT).show();
            return;
        }

        double contractAmt = data.getContractAmt();//1100.0
        double netAmt = data.getNetAmt();//822.14
        double perRepayAmt = data.getPerRepayAmt();//99.28
        double costMonthly = data.getCostMonthly();//1.38
        int period = data.getPeriod();//12

        mTxt_feilv2.setText("" + costMonthly); //费率
        mTxt_qixian2.setText("" + period);    //期限
        mTxt_daoshou2.setText("" + DataFormatFromInt.getDoubleByDouble(netAmt)); //到手金额
        mTxt_hetong2.setText("" + DataFormatFromInt.getDoubleByDouble(contractAmt));//合同金额
        mTxt_meiyue2.setText("" + DataFormatFromInt.getDoubleByDouble(perRepayAmt)); //每月应还

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

    //获取试算中费率，期限等参数信息，并添加到Spinner上显示
    @Override
    public void getLogin(String s) {

        final ArrayList<String> elite = new ArrayList<>();
        Gson gson = new Gson();
        ShisuanParmBean shiSuanBean = gson.fromJson(s, ShisuanParmBean.class);
        String code = shiSuanBean.getCode();
        if (!"1".equals(code)){
            Toast.makeText(this, ""+shiSuanBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        ShisuanParmBean.DataBean shisuan = shiSuanBean.getData();
        periods = shisuan.getPeriods();

        List<ShisuanParmBean.DataBean.ProductInfosBean> productInfos = shisuan.getProductInfos();

        for (int i = 0; i < productInfos.size(); i++) {
            ShisuanParmBean.DataBean.ProductInfosBean productInfosBean = productInfos.get(i);
            String productCode = productInfosBean.getProductCode();
            String costMonthly = productInfosBean.getCostMonthly();
            map.put(costMonthly, productCode);
            elite.add(costMonthly);
        }

        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, periods);
        mSpinner1.setAdapter(adapter);
        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                period = periods.get(i);
                Log.i("dd", "onItemSelected: " + period);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, elite);
        mSpeener2.setAdapter(adapter2);
        mSpeener2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                productCode = map.get(elite.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void getUpDate(String s) {

    }


    public void onClick(View view) {
        switch (view.getId()) {

            //点击查询
            case R.id.mBtn_check:
                //隐藏软键盘
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        ShiSuanActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                Present present1 = new Present(this);
                String money = mEd_jine.getText().toString().trim();
                if (money.equals("")) {
                    Toast.makeText(this, "请输入金额", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    applyAmt = (int) (Double.parseDouble(money) * 10000);
                }

                if (null == productCode) {
                    Toast.makeText(this, "请选择费率", Toast.LENGTH_SHORT).show();
                    return;
                }

                //设置请求参数
                calcParameterBean.setProductCode(productCode);
                calcParameterBean.setApplyAmt(applyAmt);
                calcParameterBean.setPeriod(period);
                present1.getCalcContractInfoData(calcParameterBean, token); //发送网路请求
                break;
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

    private void initView() {
        map = new HashMap<>();

        mSpinner1 = (Spinner) findViewById(R.id.mSpinner);
        mSpeener2 = (Spinner) findViewById(R.id.mSpinner2);
        mEd_jine = (EditText) findViewById(R.id.mEd_jine);
        mTxt_feilv2 = (TextView) findViewById(R.id.mTxt_feilv2);
        mTxt_qixian2 = (TextView) findViewById(R.id.mTxt_qixian2);
        mTxt_daoshou2 = (TextView) findViewById(R.id.mTxt_daoshou2);
        mTxt_hetong2 = (TextView) findViewById(R.id.mTxt_hetong2);
        mTxt_meiyue2 = (TextView) findViewById(R.id.mTxt_meiyue2);

        EditTextUtil.twoPoint(mEd_jine); //小数点后保留两位

    }



    //设置标题栏
    private void initToolBar() {
        dialog = new ProgressDialog(this);
        toolbar = (Toolbar) findViewById(R.id.toolbars_shisuan_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    //获取token和用户码
    private void initCode() {
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        String userCode = sharedPreferences.getString("userCode", "88888");
        token = sharedPreferences.getString("token", "888888");
        present.getFindCalcParameter(parmsBean, token);
    }

    //出事化参数对象及其他类对象
    private void initBean() {
        present = new Present(this);
        parmsBean = new ParmsBean();
        calcParameterBean = new FindCalcParameterBean();
    }

}
