package com.ts888.tongshan.tongshan.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.MainActivity;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GeRenXinXiBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.BitmapUtils;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by dongdong on 2017/7/30.
 * 业务页显示的第三个按钮对应的页面（更多页面）
 */

public class GengDuoFragment extends Fragment implements IMainView {

    @BindView(R.id.mBtn_updata)
    Button mBtnUpdata;
    @BindView(R.id.img_center)
    ImageView imgCenter;
    @BindView(R.id.mTxt_gerenname)
    TextView mTxtGerenname;
    @BindView(R.id.mTxt_bangding)
    TextView mTxtBangding;
    @BindView(R.id.mTxt_phoneNumber)
    TextView mTxtPhoneNumber;
    @BindView(R.id.mTxt_mendian)
    TextView mTxtMendian;
    @BindView(R.id.mTxt_address)
    TextView mTxtAddress;
    @BindView(R.id.mBtn_bangzhu)
    Button mBtnBangzhu;
    @BindView(R.id.mBtn_women)
    Button mBtnWomen;
    @BindView(R.id.mBtn_tuichu)
    Button mBtnTuichu;
    Unbinder unbinder;
    @BindView(R.id.mTxt_tuandui)
    TextView mTxtTuandui;
    @BindView(R.id.txt3)
    TextView txt3;
    @BindView(R.id.rl_3)
    RelativeLayout rl3;
    private Button mBtn_updata;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private Present present;
    private String token;
    private JinJianBean jinJian;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gengduo, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取缓存的token
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");
        edit = sharedPreferences.edit();

        present = new Present(this);
        jinJian = new JinJianBean();

        mBtn_updata = (Button) view.findViewById(R.id.mBtn_updata);
        mBtn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.getText("updata");
            }
        });

        present.getUserInfos(jinJian, token);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtn_updata, R.id.img_center, R.id.mBtn_bangzhu, R.id.mBtn_women, R.id.mBtn_tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_updata:


                break;
            case R.id.img_center:
//                startActivity(new Intent(getActivity(), GerenCenterActivity.class));
//                //调用相册
//                Intent intent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, 1);
                break;

            case R.id.mBtn_bangzhu:

                //公告管理
//                present.noticeInfo(new LongHuParmsBean(),token);

//                jinJian.setName("龙");

                //进件查询
//                present.findApplyInfo(jinJian,token);//返回数据为空

                //放款查询
//                present.findLoanInfo(jinJian,token);

                //个人信息
//                present.getUserInfos(jinJian,token);

                break;
            case R.id.mBtn_women:

                break;
            case R.id.mBtn_tuichu:
                edit.putString("token", "");
                edit.commit();
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;
        }
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
        Log.i("dd", "getUpDate: " + s);
        Gson gson = new Gson();
        GeRenXinXiBean geRenXinXiBean = gson.fromJson(s, GeRenXinXiBean.class);
        String code = geRenXinXiBean.getCode();
        if (!code.equals("1")) {
            if (code.equals("19902")){
                edit.putString("token", "");
                edit.commit();
                Toast.makeText(getActivity(), "" + geRenXinXiBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }

            Toast.makeText(getActivity(), "" + geRenXinXiBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        GeRenXinXiBean.DataBean data = geRenXinXiBean.getData();

        if (null == data) {
            Toast.makeText(getActivity(), "数据结果为空", Toast.LENGTH_SHORT).show();
            return;
        }

        mTxtGerenname.setText("您好，"+data.getStaffName());
        mTxtPhoneNumber.setText(""+data.getPhoneNo());

        mTxtAddress.setText(""+data.getGroupName());
        mTxtTuandui.setText(""+data.getOrgName());
    }


    public interface TextCallBack {
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack) {
        this.callBack = callBack;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getActivity().getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }

    //加载图片
    private void showImage(String imaePath) {
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
        byte[] bytes = out.toByteArray();
        String s = Base64.encodeToString(bytes, Base64.DEFAULT);
        Bitmap circleBitmap = BitmapUtils.getCircleBitmap(bm);
        imgCenter.setImageBitmap(circleBitmap);
    }
}
