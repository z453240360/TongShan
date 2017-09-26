package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GrapMyBean;
import com.ts888.tongshan.tongshan.bean.OrgRankingBean;
import com.ts888.tongshan.tongshan.util.DataFormatFromInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GrapMineAdapter extends RecyclerView.Adapter<GrapMineAdapter.MyViewHolder> {

    private List<GrapMyBean.DataBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private Map<Integer,Boolean> map=new HashMap<>();

    public GrapMineAdapter(Context context, List<GrapMyBean.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
        initMap();
    }

    private void initMap() {
        if (mDatas!= null) {
            for (int i = 0; i < mDatas.size(); i++) {
                map.put(i, false);
            }
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_mygrap, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        GrapMyBean.DataBean dataBean = mDatas.get(position);
        String phoneNo = dataBean.getPhoneNo();
        long amount = dataBean.getAmount();
        String grabTime = dataBean.getGrabTime();
        String customerName = dataBean.getCustomerName();






    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_name,mTxt_moneyNum,mTxt_sucessed;
        private ImageView mImg_flag,mImg_phone,mImg_msm;
        private EditText mEd_send;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_name = (TextView) itemView.findViewById(R.id.mTxt_name);
            mTxt_moneyNum = (TextView) itemView.findViewById(R.id.mTxt_moneyNum);
            mTxt_sucessed = (TextView) itemView.findViewById(R.id.mTxt_succesed);
            mImg_flag = (ImageView) itemView.findViewById(R.id.mImg_flag);
            mImg_phone = (ImageView) itemView.findViewById(R.id.mImg_phone);
            mImg_msm = (ImageView) itemView.findViewById(R.id.mImg_msm);
            mEd_send = (EditText) itemView.findViewById(R.id.mEd_cancle);
        }
    }

    //增加一条数据
    public void insertData(int pos,GrapMyBean.DataBean data) {
        mDatas.add(pos, data);

        notifyItemInserted(pos);
    }

    //删除一条数据
    public void removeData(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }


    public interface OnItemClickListener {
        void onItemClick(int pos, View view);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

}
