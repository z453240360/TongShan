package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;
import com.ts888.tongshan.tongshan.bean.Jinjian3_bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mTxt_status;

public class LikeListAdapter3 extends RecyclerView.Adapter<LikeListAdapter3.MyViewHolder> {
    private List<Jinjian3_bean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public LikeListAdapter3(Context context, List<Jinjian3_bean.DataBean> datas) {
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
        View view = mInflater.inflate(R.layout.adapter_kehu3, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        Jinjian3_bean.DataBean dataBean = mDatas.get(position);
        String taskNode = dataBean.getTaskNode();


        if (taskNode.equals("放款中")){
            holder.mTxt_status3.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("放款成功")){
            holder.mTxt_status3.setTextColor(Color.rgb(72,170,74));
        }else if (taskNode.equals("放款失败")){
            holder.mTxt_status3.setTextColor(Color.RED);
        }else if (taskNode.equals("扣服务费中")){
            holder.mTxt_status3.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("扣服务费失败")){
            holder.mTxt_status3.setTextColor(Color.RED);
        }else if (taskNode.equals("扣服务费成功")){
            holder.mTxt_status3.setTextColor(Color.rgb(72,170,74));
        }else if (taskNode.equals("结束")){
            holder.mTxt_status3.setTextColor(Color.BLACK);
        }else {
            holder.mTxt_status3.setTextColor(Color.BLACK);
        }

        holder.gg_title3.setText(dataBean.getName());
        holder.mTxt_status3.setText(taskNode);
        holder.gg_time3.setText(dataBean.getApplyDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position, holder.itemView);
                }
            }
        });


    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView gg_title3,gg_time3,mTxt_status3;

        public MyViewHolder(View itemView) {
            super(itemView);
            gg_title3= (TextView) itemView.findViewById(R.id.mTxt_name3);
            gg_time3= (TextView) itemView.findViewById(R.id.mTxt_time32);
            mTxt_status3= (TextView) itemView.findViewById(R.id.mTxt_status3);

        }
    }

    //增加一条数据
    public void insertData(int pos, Jinjian3_bean.DataBean data) {
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
