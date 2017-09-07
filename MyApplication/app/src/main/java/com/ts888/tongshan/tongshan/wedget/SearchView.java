package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;

import java.lang.reflect.Field;

import static com.ts888.tongshan.tongshan.R.id.ed_search1;

/**
 * Created by Administrator on 2017/9/7.
 */

public class SearchView extends FrameLayout {

    private android.widget.SearchView searchView;
    private TextView textView;
    private Context context;

    public SearchView(Context context) {
        super(context);
        init(context);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.wedget_searchview, null);
        addView(view);
        searchView = (android.widget.SearchView) view.findViewById(R.id.search);
        textView = (TextView) view.findViewById(R.id.wedget_sousuo);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setVisibility(VISIBLE);
                textView.setVisibility(INVISIBLE);
                searchView.requestFocus();
            }
        });

        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                searchView.setVisibility(INVISIBLE);
//                textView.setVisibility(VISIBLE);
                if (searchView.getQuery().equals("")) {
                    searchView.setVisibility(INVISIBLE);
                    textView.setVisibility(VISIBLE);
                }
                callBack.onSearchCallBack(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        Class<? extends android.widget.SearchView> aClass = searchView.getClass();
        //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
        Field ownField = null;
        try {
            ownField = aClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(searchView);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




    }

    public void setCallBack(SearchCallBack callBack) {
        this.callBack = callBack;
    }

    private SearchCallBack callBack;

    public interface SearchCallBack {
        void onSearchCallBack(String s);
    }


}
