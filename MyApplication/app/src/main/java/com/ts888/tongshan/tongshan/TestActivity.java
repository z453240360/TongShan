package com.ts888.tongshan.tongshan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.wedget.ShouyeWedget;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.wed1)
    ShouyeWedget wed1;
    @BindView(R.id.wed2)
    ShouyeWedget wed2;
    @BindView(R.id.wed3)
    ShouyeWedget wed3;
    @BindView(R.id.wed4)
    ShouyeWedget wed4;
    @BindView(R.id.wed5)
    ShouyeWedget wed5;
    @BindView(R.id.wed6)
    ShouyeWedget wed6;
    @BindView(R.id.wed7)
    ShouyeWedget wed7;
    @BindView(R.id.wed8)
    ShouyeWedget wed8;
    @BindView(R.id.wed9)
    ShouyeWedget wed9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        Toast.makeText(this, "??", Toast.LENGTH_SHORT).show();
        wed1.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "??", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
