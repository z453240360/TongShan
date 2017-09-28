package com.ts888.tongshan.tongshan.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GrapMineAdapter;
import com.ts888.tongshan.tongshan.bean.GrabCancleBean;
import com.ts888.tongshan.tongshan.bean.GrapMyBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ShowTostUtil;

import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mBtn_conform;
import static com.ts888.tongshan.tongshan.R.id.view;


/**
 * Created by dongdong on 2017/7/30.
 */

public class Grabs_MineFragment extends Fragment implements IMainView {

    private Present present;
    private SharedPreferences sharedPreferences;
    private String token;
    private ParmsBean bean;
    private List<GrapMyBean.DataBean> myDatas=new ArrayList<>();
    private List<GrapMyBean.DataBean> myAllDatas=new ArrayList<>();
    private GrapMineAdapter grapMineAdapter;
    private XRecyclerView xRl;
    private int removePos=-1;
    private Dialog dialog;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grabs_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xRl = (XRecyclerView) view.findViewById(R.id.myGrapRl);
        init();
    }

    private void init() {
        dialog = new Dialog(getActivity());
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");
        present = new Present(this);
        present.getMyGrabList(new JinJianBean(), token);//我的订单信息

        grapMineAdapter = new GrapMineAdapter(getActivity(),myAllDatas);
        manager = new LinearLayoutManager(getActivity());
        manager.setStackFromEnd(false);
        manager.setReverseLayout(true);

        xRl.setLayoutManager(manager);
        xRl.setAdapter(grapMineAdapter);
        xRl.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xRl.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        xRl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                myAllDatas.clear();
                grapMineAdapter.notifyDataSetChanged();
                present.getMyGrabList(new JinJianBean(), token);
                xRl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRl.loadMoreComplete();
            }
        });

        grapMineAdapter.setOnItemClickListener(new GrapMineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {

            }

            @Override
            public void onPhoneButtonClick(int pos, String s) {

                String phoneNo = myAllDatas.get(pos).getPhoneNo();
                if (phoneNo.equals("")){
                    ShowTostUtil.toast(getActivity(),"电话号码为空");
                    return;
                }

                diaPhone(phoneNo);

            }

            @Override
            public void onMsmClicked(int pos, String s) {
                ShowTostUtil.toast(getActivity(),"xinxi"+pos);
                String phoneNo = myAllDatas.get(pos).getPhoneNo();
                if (phoneNo.equals("")){
                    ShowTostUtil.toast(getActivity(),"电话号码为空");
                    return;
                }

                Uri uri = Uri.parse("smsto:"+phoneNo);
                Intent  intent  = new Intent();
                intent.setAction(Intent.  ACTION_SENDTO );
                intent.setData(uri);
                intent.putExtra("sms_body", "");
                startActivity( intent );

            }

            @Override
            public void onComfirmClicked(final int pos, String s) {


                if (s.equals("")){
                    ShowTostUtil.toast(getActivity(),"请说明理由");
                    return;
                }
//                View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_give_up_grap, null);
//                dialog.setContentView(view);
//                dialog.setCancelable(false);
//                dialog.show();

//                Button mBtn_cancle = (Button)view.findViewById(R.id.mBtn_cancel);
//                Button mBtn_conform = (Button)view.findViewById(R.id.mBtn_conform);

//                mBtn_cancle.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.cancel();
//                        callBack.getText("抢单成功");
//                    }
//                });
//
//                mBtn_conform.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
                        bean = new ParmsBean();
                        bean.setPhoneNo(myAllDatas.get(pos).getPhoneNo());
                        present.cancelGrab(bean, token);//取消订单
                        removePos=pos;
//                        dialog.cancel();
//                    }
//                });



            }
        });

    }

    @Override
    public void getCode(String s) {
        Log.i("dd", "取消订单: " + s);
        Gson gson = new Gson();
        GrabCancleBean grabCancleBean = gson.fromJson(s, GrabCancleBean.class);
        String code = grabCancleBean.getCode();
        if (!code.equals("1")){
            ShowTostUtil.toast(getActivity(),grabCancleBean.getMessage().toString());
            return;
        }
        ShowTostUtil.toast(getActivity(),grabCancleBean.getData());
        if (removePos!=-1) {
            grapMineAdapter.removeData(removePos);
            removePos = -1;
        }
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
        Log.i("dd", "我的订单查询: " + s);
        Gson gson = new Gson();
        GrapMyBean grapMyBean = gson.fromJson(s, GrapMyBean.class);
        String code = grapMyBean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + grapMyBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        myDatas = grapMyBean.getData();
        myAllDatas.addAll(myDatas);
        grapMineAdapter.notifyDataSetChanged();
    }


    public void diaPhone(String phoneNum){
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 0x11);

        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNum));
        startActivity(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0x11) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                ShowTostUtil.toast(getActivity(),"请开启手机拨号权限");
            }
        }
    }

    public interface TextCallBack {
        void getText(String str);
    }

    private Grabs_MineFragment.TextCallBack callBack;

    public void setCallBack(Grabs_MineFragment.TextCallBack callBack) {
        this.callBack = callBack;
    }
}
