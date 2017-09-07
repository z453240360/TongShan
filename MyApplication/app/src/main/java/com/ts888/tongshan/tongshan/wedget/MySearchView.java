package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ts888.tongshan.tongshan.R;

/**
 * Created by Administrator on 2017/9/7.
 */

public class MySearchView extends FrameLayout {

    private EditText editText;
    private Button button;
    private ImageView imageView;

    public MySearchView(Context context) {
        super(context);
        init(context);
    }

    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.wedget_mysearchview, null);
        addView(view);

    }
}
