package com.ts888.tongshan.tongshan.activity;

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

public class ShiSuanActivity extends AppCompatActivity implements IMainView {

    private Present present;
    private ParmsBean parmsBean;
    private SharedPreferences sharedPreferences;
    private String token;
    private Spinner mSpinner1, mSpeener2;
    private ArrayAdapter<Integer> adapter;
    private ArrayAdapter<String> adapter2;
    private EditText mEd_jine;
    private Map<String, String> map;
    private String productCode;
    private int applyAmt;
    private int period;
    private TextView mTxt_feilv2, mTxt_qixian2, mTxt_daoshou2, mTxt_hetong2, mTxt_meiyue2;
    private List<Integer> periods;
    private Toolbar toolbar;
    private FindCalcParameterBean calcParameterBean;
    private ScrollView activity_shi_suan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shi_suan);

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

    @Override
    public void getCode(String s) {
        Log.i("dd", "getCode: "+s);
        Gson g = new Gson();
        ShiSuanDataBean shiSuanDataBean = g.fromJson(s, ShiSuanDataBean.class);
        ShiSuanDataBean.DataBean data = shiSuanDataBean.getData();

        int applyAmt = data.getApplyAmt();  //1000
        double contractAmt = data.getContractAmt();//1100.0
        double netAmt = data.getNetAmt();//822.14
        double perRepayAmt = data.getPerRepayAmt();//99.28
        double costMonthly = data.getCostMonthly();//1.38
        int period = data.getPeriod();//12

        mTxt_feilv2.setText("" + costMonthly);
        mTxt_qixian2.setText("" + period);
        mTxt_daoshou2.setText("" + netAmt);
        mTxt_hetong2.setText("" + contractAmt);
        mTxt_meiyue2.setText("" + perRepayAmt);






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

        final ArrayList<String> elite = new ArrayList<>();
        Gson gson = new Gson();
        Log.i("dd", "getLogin:++++++++++++++++++++ " + s);
        ShisuanParmBean shiSuanBean = gson.fromJson(s, ShisuanParmBean.class);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mBtn_check:
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        ShiSuanActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                Present present1 = new Present(this);
                String money = mEd_jine.getText().toString().trim();
                if (money.equals("")) {
                    Toast.makeText(this, "请输入金额", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    applyAmt = (int) (Float.parseFloat(money) * 10000);
                }

                if (null == productCode) {
                    Toast.makeText(this, "请选择费率", Toast.LENGTH_SHORT).show();
                    return;
                }

                calcParameterBean.setProductCode(productCode);
                calcParameterBean.setApplyAmt(applyAmt);
                calcParameterBean.setPeriod(period);
                present1.getCalcContractInfoData(calcParameterBean, token);
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

        mEd_jine.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                DecimalFormat df=(DecimalFormat) NumberFormat.getInstance();
                df.setMaximumFractionDigits(2);
                String format = df.format(Float.parseFloat(s.toString()));
                mEd_jine.setText(format);
                Log.i("dd", "onTextChanged: "+format);

                //TODO 保留小数点后两位
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }




    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbars_shisuan_activity);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void initCode() {
        sharedPreferences = getSharedPreferences("ts", Context.MODE_PRIVATE);
        String userCode = sharedPreferences.getString("userCode", "88888");
        token = sharedPreferences.getString("token", "888888");
        present.getFindCalcParameter(parmsBean, token);
    }

    private void initBean() {
        present = new Present(this);
        parmsBean = new ParmsBean();
        calcParameterBean = new FindCalcParameterBean();
    }

}
