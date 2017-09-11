package com.ts888.tongshan.tongshan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.MainActivity;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.BannerResultBean;
import com.ts888.tongshan.tongshan.bean.BannerTypeBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ColorState;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvActivity extends AppCompatActivity {


    private ViewPager pager;
    private ArrayList<ImageView> list = new ArrayList<ImageView>();
    private int [] imgs={R.mipmap.no1,R.mipmap.no2,R.mipmap.no3};
    private Button but;
    private SharedPreferences pref;
    private RadioGroup group;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //状态栏颜色为白色
//        ColorState.setWindowStatusBarColor(this, Color.WHITE);
        //设置状态栏字体为黑色
        ColorState.StatusBarLightMode(this);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        pref = getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean flag = pref.getBoolean("flag", false);

        if (!flag) {
            setContentView(R.layout.activity_adv);

            initView();

            initData();

            initAdapter();

            //设置ViewPager的选中监听
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                //当item被选中后运行此方法
                //参数：被选中的item对应的position位置
                @Override
                public void onPageSelected(int position) {
//     				Log.i("oye", "======= onPageSelected   "+position);
                    if(position == list.size()-1) {
                        but.setVisibility(View.VISIBLE);
                        pref.edit().putBoolean("flag", true).commit();
                        startActivity(new Intent(AdvActivity.this,StartActivity.class));
                        finish();
                    } else {
                        but.setVisibility(View.GONE);
                    }

                    //根据position位置选中对应的radiobutton

                    //用于获取radiogroup中位于position位置子控件对象
                    RadioButton rb = (RadioButton) group.getChildAt(position);
                    //通过getId方法获取应该被选中的rb的id值
                    group.check(rb.getId());

                    if (position==list.size()){
                        pref.edit().putBoolean("flag", true).commit();
                        startActivity(new Intent(AdvActivity.this,StartActivity.class));
                        finish();
                    }
                }
                //当页面滚动过程中不断调用的方法
                /**
                 * 1. 当前屏幕上主要显示的item的位置
                 * 2. 滑动的偏移的百分比
                 * 3. 滑动的偏移像素值
                 */
                @Override
                public void onPageScrolled(int position, float positionOffset,
                                           int positionOffsetPixels) {
                    // TODO Auto-generated method stub
                    Log.i("oye", "onPageScrolled   "+position+"  "+positionOffset+"  "+positionOffsetPixels);
                }
                //当滚动状态发生改变时调用的方法
                //参数：改变后的滚动状态
                @Override
                public void onPageScrollStateChanged(int state) {
                    // TODO Auto-generated method stub
                    switch (state) {
                        case ViewPager.SCROLL_STATE_DRAGGING:
                            Log.i("oye", "手指开始滑动状态");
                            break;

                        case ViewPager.SCROLL_STATE_IDLE:
                            Log.i("oye", "空闲状态，滑动结束状态");
                            break;
                        case ViewPager.SCROLL_STATE_SETTLING:
                            Log.i("oye", "结束前过渡状态");
                            break;
                    }
                }
            });
        } else {
            startActivity(new Intent(AdvActivity.this,StartActivity.class));
            finish();
        }
    }

    private void initAdapter() {
        // TODO Auto-generated method stub
        adapter = new MyAdapter();
        pager.setAdapter(adapter);
    }

    private void initData() {
        // TODO Auto-generated method stub
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(iv);
        }
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.viewpager);
        but = (Button)findViewById(R.id.button1);
        group = (RadioGroup)findViewById(R.id.radioGroup1);
    }

    public void click (View v) {
        pref.edit().putBoolean("flag", true).commit();
        startActivity(new Intent(AdvActivity.this,StartActivity.class));
        finish();
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            ImageView iv = list.get(position);
            //设置控件上的显示内容
            iv.setImageResource(imgs[position]);

            container.addView(iv);


            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            //当需要将位于position位置的item移除显示时
            //方式一
//			container.removeView(list.get(position));
            //方式二
            container.removeView((View) object);
        }

    }
}
