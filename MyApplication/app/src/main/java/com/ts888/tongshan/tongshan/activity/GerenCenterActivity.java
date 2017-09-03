package com.ts888.tongshan.tongshan.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.util.ColorState;

public class GerenCenterActivity extends AppCompatActivity implements IMainView{

    private Toolbar toolbar;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏和标题栏
        ColorState.setWindowStatusBarColorBlue(this, Color.BLUE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_geren_center);

        initView();
        initToolBar();
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

    }

    @Override
    public void getUpDate(String s) {

    }


    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbars_gerencenter_activity);
        imageView = (ImageView) findViewById(R.id.img_center);
    }

    private void initToolBar() {
        //设置标题栏
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.zuojiantou);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }




    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.mBtn_touxiang:
                //调用相册
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }

    }
    //加载图片
    private void showImage(String imaePath){
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        imageView.setImageBitmap(bm);
    }
}
