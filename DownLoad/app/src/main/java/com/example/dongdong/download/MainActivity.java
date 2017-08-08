package com.example.dongdong.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private UpdateVersionController controller = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.force_update).setOnClickListener(this);
        findViewById(R.id.normal_update).setOnClickListener(this);
        if (null == controller) {
            controller = UpdateVersionController.getInstance(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_update:
                controller.normalCheckUpdateInfo();
                break;
            case R.id.force_update:
                controller.forceCheckUpdateInfo();
                break;
            default:
                break;
        }
    }
}
