package com.ts888.tongshan.tongshan.wedget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.model.IMainView;

import static com.ts888.tongshan.tongshan.R.id.img;
import static com.ts888.tongshan.tongshan.R.id.mTxt_danwei_wedget;

/**
 * Created by Administrator on 2017/8/15.
 */

public class ShouyeWedget extends FrameLayout {


    private View inflate;
    private TextView mTxt_number_wedget;
    private ImageView imageView;
    private Button button;

    public ShouyeWedget(Context context) {
        super(context);
        init(context);
    }

    public ShouyeWedget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        inflate = LayoutInflater.from(context).inflate(R.layout.wedget_shouye, null);
        addView(inflate);
        mTxt_number_wedget = (TextView) inflate.findViewById(R.id.txt_wedget);
        imageView = (ImageView) inflate.findViewById(R.id.img);
        button = (Button) inflate.findViewById(R.id.btn_wedget);
    }


    //图片
    public void setBackground(int id){
        imageView.setBackgroundResource(id);
    }

    //设置单位
    public void setTextDanwei(String s){
        mTxt_number_wedget.setText(s);
    }

    public void setOnClick(final Context click, final String s){
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(click, ""+s, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
