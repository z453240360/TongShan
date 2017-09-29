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
import android.support.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ts888.tongshan.tongshan.MainActivity;
import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.adapter.GrapInfoAdapter;
import com.ts888.tongshan.tongshan.bean.GeRenXinXiBean;
import com.ts888.tongshan.tongshan.bean.GrabBean;
import com.ts888.tongshan.tongshan.bean.GranInfoBean;
import com.ts888.tongshan.tongshan.bean.JinJianBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.model.IMainView;
import com.ts888.tongshan.tongshan.model.Present;
import com.ts888.tongshan.tongshan.util.ShowTostUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.attr.data;
import static android.R.id.edit;


/**
 * Created by dongdong on 2017/7/30.
 */

public class Grabs_Fragment extends Fragment implements IMainView {

    @BindView(R.id.mTxt_title)
    TextView mTxtTitle;
    @BindView(R.id.mXRecylerView)
    XRecyclerView mXRecylerView;
    Unbinder unbinder;

    private String token;
    private ParmsBean bean;
    private Dialog dialog2;
    private Bundle dd_Bundle;
    private Present present;
    private GrapInfoAdapter adapter;
    private ProgressDialog progressDialog;
    private SharedPreferences sharedPreferences;
    private List<GrabBean.DataBean> mDatas = new ArrayList<>();
    private List<GrabBean.DataBean> mAllDatas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grabs, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取token
        sharedPreferences = getActivity().getSharedPreferences("ts", Context.MODE_APPEND);
        token = sharedPreferences.getString("token", "");


        dd_Bundle = new Bundle();
        dd_Bundle.putString("phone","");


        dialog2 = new Dialog(getActivity(), R.style.dialog);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);


        present = new Present(this);
        bean = new ParmsBean();
        present.getGrabInfoList(new JinJianBean(), token);//查询所有抢单信息
        present.getUserInfos(new JinJianBean(), token);//查询个人信息


        adapter = new GrapInfoAdapter(getActivity(), mAllDatas);
        mXRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mXRecylerView.setAdapter(adapter);
        mXRecylerView.setRefreshProgressStyle(ProgressStyle.BallBeat);
        mXRecylerView.setLoadingMoreProgressStyle(ProgressStyle.LineScalePulseOutRapid);
        mXRecylerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mAllDatas.clear();
                adapter.notifyDataSetChanged();
                present.getGrabInfoList(new JinJianBean(), token);
                mXRecylerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mXRecylerView.loadMoreComplete();
            }
        });


        //点击抢单
        adapter.setOnItemClickListener(new GrapInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                bean.setPhoneNo(mAllDatas.get(pos).getPhoneNo());
                present.grabInfo(bean, token);

            }
        });
    }


    //抢单，显示抢单结果信息
    @Override
    public void getCode(String s) {
        Log.i("dd", "抢单: " + s);

        Gson gson = new Gson();
        GranInfoBean granInfoBean = gson.fromJson(s, GranInfoBean.class);
        String code = granInfoBean.getCode();
        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + granInfoBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        final GranInfoBean.DataBean data = granInfoBean.getData();
        if (data == null) {
            return;
        }

        boolean grabResult = data.isGrabResult();

        if (grabResult) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_grapsuccesed, null);

            Button mBtn_dialog = (Button) view.findViewById(R.id.mBtn_dialog);//确认按钮
            TextView name = (TextView) view.findViewById(R.id.mTxt_mesg3);//客户姓名
            TextView money = (TextView) view.findViewById(R.id.mTxt_mesg1);//金额
            TextView city = (TextView) view.findViewById(R.id.mTxt_mesg2);//城市
            TextView call = (TextView) view.findViewById(R.id.mTXT_CALL);//立即联系

            name.setText("客户姓名：" + data.getCustomerName());
            money.setText("意向金额：" + data.getAmount() + " 元");
            city.setText("申请城市：" + data.getCity());


            dialog2.setContentView(view);
            dialog2.setCancelable(false);
            dialog2.show();


            if ("".equals(data.getPhoneNo())){
                dd_Bundle.putString("phone","");
            }else {
                dd_Bundle.putString("phone", data.getPhoneNo());
            }

            //点击确认按钮，取消弹框，我的案件按钮处于选中状态
            mBtn_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog2.cancel();
                    callBack.getText("succesed");

                }
            });

            //点击立即联系，拨打电话，跳转拨号界面
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // 判断环境兼容，检查自己的权限，是否被同意
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        //如果不同意，就去请求权限   参数1：上下文，2：权限，3：请求码
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                    } else {


                        String phone = dd_Bundle.getString("phone");

                        if ("".equals(phone)||phone==null){
                            ShowTostUtil.toast(getActivity(),"没有查到电话号码");
                            return;
                        }
                        //同意就拨打
                        dialcall(phone);
                    }
                }
            });


        } else {
            Dialog dialogFailed = new Dialog(getActivity(), R.style.dialog);
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_grapfailed, null);
            //TODO 弹出框
            dialogFailed.setContentView(view);
            dialogFailed.show();
        }


    }

    //拨打电话
    private void dialcall(String phone) {
        if (phone.equals("")||phone==null){
            ShowTostUtil.toast(getActivity(),"没有查到联系电话");
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phone));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        ShowTostUtil.toast(getActivity(), s);
    }

    @Override
    public void getLogin(String s) {
        Log.i("dd", "getUpDate: " + s);
        Gson gson = new Gson();
        GeRenXinXiBean geRenXinXiBean = gson.fromJson(s, GeRenXinXiBean.class);
        String code = geRenXinXiBean.getCode();
        if (!code.equals("1")) {

            Toast.makeText(getActivity(), "" + geRenXinXiBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        GeRenXinXiBean.DataBean data = geRenXinXiBean.getData();

        if (null == data) {
            Toast.makeText(getActivity(), "数据结果为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String orgName = data.getOrgName();
        mTxtTitle.setText(orgName);


    }

    //获取抢单数据
    @Override
    public void getUpDate(String s) {
        Log.i("dd", "抢单: " + s);
        Gson gson = new Gson();
        GrabBean grabBean = gson.fromJson(s, GrabBean.class);
        String code = grabBean.getCode();

        if (!code.equals("1")) {
            Toast.makeText(getActivity(), "" + grabBean.getMessage().toString(), Toast.LENGTH_SHORT).show();
            return;
        }

        mDatas = grabBean.getData();
        if (mDatas.size() == 0) {
            return;
        }

        mAllDatas.addAll(mDatas);
        adapter.notifyDataSetChanged();

    }


    /**
     * 接口回调
     */
    public interface TextCallBack {
        void getText(String str);
    }

    private Grabs_Fragment.TextCallBack callBack;

    public void setCallBack(Grabs_Fragment.TextCallBack callBack) {
        this.callBack = callBack;
    }

    //电话权限申请
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            //判断请求码
        switch (requestCode) {
            case 1:
                //如果同意，就拨打
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String phone = dd_Bundle.getString("phone");
                    dialcall(phone);
                } else {
                    Toast.makeText(getActivity(), "请开启权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void refresh(){
        mAllDatas.clear();
        adapter.notifyDataSetChanged();
        present.getGrabInfoList(new JinJianBean(), token);
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

