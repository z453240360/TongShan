package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LikeListAdapter extends RecyclerView.Adapter<LikeListAdapter.MyViewHolder> {
    private List<FindScheduleBean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public LikeListAdapter(Context context, List<FindScheduleBean.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_kehu, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        FindScheduleBean.DataBean dataBean = mDatas.get(position);

        String userCode = dataBean.getUserCode();
        String userName = dataBean.getUserName();
        String applyDate = dataBean.getApplyDate();
        String currVerifyName = dataBean.getCurrVerifyName();
        int applyAmt = dataBean.getApplyAmt();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position, holder.itemView);
                }
            }
        });


        //格式化数据
        float v = (float)(applyAmt / 10000);
        DecimalFormat fnum = new DecimalFormat("##0.00");
        String dd=fnum.format(v);

        holder.mTxt_jianban.setText(currVerifyName);
        holder.mTxt_time.setText(applyDate);
        holder.mTxt_sunxiaobao.setText(userName);
        holder.mTxt_wuqian.setText(""+dd+" 万元");
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_dangqianjiedian,mTxt_jianban,
                mTxt_wuqian,mTxt_jine,mTxt_sunxiaobao,mTxt_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_dangqianjiedian = (TextView) itemView.findViewById(R.id.mTxt_dangqianjiedian);
            mTxt_jianban = (TextView) itemView.findViewById(R.id.mTxt_jianban);
            mTxt_wuqian = (TextView) itemView.findViewById(R.id.mTxt_wuqian);
            mTxt_jine = (TextView) itemView.findViewById(R.id.mTxt_jine);
            mTxt_sunxiaobao = (TextView) itemView.findViewById(R.id.mTxt_sunxiaobao);
            mTxt_time = (TextView) itemView.findViewById(R.id.mTxt_time);
        }
    }

    //增加一条数据
    public void insertData(int pos, FindScheduleBean.DataBean data) {
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
