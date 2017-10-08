package com.ts888.tongshan.tongshan.fragment;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

import static android.R.attr.data;


/**
 * Created by dongdong on 2017/7/30.
 */

public class Grabs_MineFragment extends Fragment implements IMainView {

    private View view;
    private Present present;
    private String token;
    private ParmsBean bean;
    private Dialog dialog;
    private Bundle bundle;
    private Button mBtn_cancle;
    private Button mBtn_conform;
    private XRecyclerView xRl;
    private ProgressDialog progressDialog;
    private LinearLayoutManager manager;
    private SharedPreferences sharedPreferences;
    private GrapMineAdapter grapMineAdapter;
    private List<GrapMyBean.DataBean> myDatas=new ArrayList<>();
    private List<GrapMyBean.DataBean> myAllDatas=new ArrayList<>();


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
        //获取token
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");


        //加载框
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");


        //弹出框以及对应的控件功能
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_give_up_grap, null);
        dialog = new Dialog(getActivity(),R.style.dialog);
        dialog.setContentView(view);
        dialog.setCancelable(false);

        mBtn_cancle = (Button)view.findViewById(R.id.mBtn_cancel);
        mBtn_conform = (Button)view.findViewById(R.id.mBtn_conform);

        //弹框取消
        mBtn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });



        //初始化数据层对象
        present = new Present(this);
        present.getMyGrabList(new JinJianBean(), token);//我的订单信息


        //存储点击位置信息，以备取消成功后删除
        bundle = new Bundle();
        bundle.putInt("postion",-1);


        //刷新列表显示内容
        grapMineAdapter = new GrapMineAdapter(getActivity(),myAllDatas);
        manager = new LinearLayoutManager(getActivity());
        manager.setStackFromEnd(false);
        manager.setReverseLayout(false);

        xRl.setLayoutManager(manager);
        xRl.setAdapter(grapMineAdapter);
        xRl.setRefreshProgressStyle(ProgressStyle.BallBeat);
        xRl.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        xRl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                myAllDatas.clear();
                grapMineAdapter.clearMap();
                grapMineAdapter.notifyDataSetChanged();
                present.getMyGrabList(new JinJianBean(), token);
                xRl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRl.loadMoreComplete();
            }
        });


        //列表的监听事件：拨打电话、发送信息、取消订单
        grapMineAdapter.setOnItemClickListener(new GrapMineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {

            }

            @Override
            public void onPhoneButtonClick(int pos, String s) {   //拨打电话

                String phoneNo = myAllDatas.get(pos).getPhoneNo();
                if (phoneNo.equals("")||null==phoneNo){
                    ShowTostUtil.toast(getActivity(),"没有查到对应的联系电话");
                    return;
                }

                // 判断环境兼容，检查自己的权限，是否被同意
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //如果不同意，就去请求权限   参数1：上下文，2：权限，3：请求码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    //同意就拨打
                    diaPhone(myAllDatas.get(pos).getPhoneNo());
                }

            }

            @Override
            public void onMsmClicked(int pos, String s) {     //发送信息
                String phoneNo = myAllDatas.get(pos).getPhoneNo();
                if (phoneNo.equals("")){
                    ShowTostUtil.toast(getActivity(),"没有查到对应的联系电话");
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
            public void onComfirmClicked(final int pos, String s) {  //确认取消


                if (s.equals("")){
                    ShowTostUtil.toast(getActivity(),"请说明理由");
                    return;
                }

                dialog.show();

                mBtn_conform.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bean = new ParmsBean();
                        bean.setPhoneNo(myAllDatas.get(pos).getPhoneNo());
                        present.cancelGrab(bean, token);//取消订单
                        myAllDatas.clear();
                        grapMineAdapter.clearMap();
                        bundle.putInt("postion",pos);
                        dialog.cancel();
                    }
                });

            }
        });
    }

    //取消订单
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

        refresh();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void cancelLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showFaliure(String s) {
        ShowTostUtil.toast(getActivity(),s);
    }

    @Override
    public void getLogin(String s) {

    }

    //我的订单查询
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
        if (phoneNum.equals("")||null==phoneNum){
            ShowTostUtil.toast(getActivity(),"没有查到联系电话");
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNum));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //判断请求码
        switch (requestCode) {
            case 1:
                //如果同意，就拨打
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String phone = bundle.getString("phone");
                    if (phone==null||"".equals(phone))
                    {
                        ShowTostUtil.toast(getActivity(),"没有查到联系电话");
                        return;
                    }
                    diaPhone(phone);
                } else {
                    Toast.makeText(getActivity(), "请开启权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public interface TextCallBack {
        void getText(String str);
    }

    private Grabs_MineFragment.TextCallBack callBack;

    public void setCallBack(Grabs_MineFragment.TextCallBack callBack) {
        this.callBack = callBack;
    }

    public void refresh(){
        myAllDatas.clear();
        grapMineAdapter.notifyDataSetChanged();
        present.getMyGrabList(new JinJianBean(), token);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){

        }else {
            refresh();
        }
    }
}
