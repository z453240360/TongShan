package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ts888.tongshan.tongshan.R;

/**
 * Created by Administrator on 2017/9/4.
 */

public class MyEditText extends FrameLayout {

    public EditText getEd_wedget() {
        return ed_wedget;
    }

    public void setEd_wedget(EditText ed_wedget) {
        this.ed_wedget = ed_wedget;
    }

    private EditText ed_wedget;
    private ImageView imageView;

    public MyEditText(Context context) {
        super(context);
        init(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.edittext, null);
        addView(view);
        ed_wedget = (EditText) findViewById(R.id.ed_wedget);
        imageView = (ImageView) findViewById(R.id.img_wedget);
        ed_wedget.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")){
                    imageView.setVisibility(VISIBLE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_wedget.setText("");
            }
        });
    }




}
