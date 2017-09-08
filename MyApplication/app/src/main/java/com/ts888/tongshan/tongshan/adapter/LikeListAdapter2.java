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
import com.ts888.tongshan.tongshan.bean.Jinjian2_Bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.ts888.tongshan.tongshan.R.id.mTxt_name2;
import static com.ts888.tongshan.tongshan.R.id.mTxt_status;
import static com.ts888.tongshan.tongshan.R.id.mTxt_status3;
import static com.ts888.tongshan.tongshan.R.id.mTxt_time22;

public class LikeListAdapter2 extends RecyclerView.Adapter<LikeListAdapter2.MyViewHolder> {
    private List<Jinjian2_Bean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public LikeListAdapter2(Context context, List<Jinjian2_Bean.DataBean> datas) {
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
        View view = mInflater.inflate(R.layout.adapter_kehu2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Jinjian2_Bean.DataBean dataBean = mDatas.get(position);

        String taskNode = dataBean.getTaskNode();

        if (taskNode.equals("录入复核")){
            holder.mTxt_status.setText("录入复核");
            holder.mTxt_status.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("回退门店")){
            holder.mTxt_status.setText("回退门店");
            holder.mTxt_status.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("审批中")){
            holder.mTxt_status.setText("审批中");
            holder.mTxt_status.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("资金渠道确认")){
            holder.mTxt_status.setText("资金渠道确认");
            holder.mTxt_status.setTextColor(Color.rgb(72,170,74));
        } else if (taskNode.equals("面签")){
            holder.mTxt_status.setText("面签");
            holder.mTxt_status.setTextColor(Color.rgb(18,108,176));
        } else if (taskNode.equals("合同复核")){
            holder.mTxt_status.setText("合同复核");
            holder.mTxt_status.setTextColor(Color.rgb(18,108,176));
        }else if (taskNode.equals("取消")){
            holder.mTxt_status.setText("取消");
            holder.mTxt_status.setTextColor(Color.BLACK);
        }else if (taskNode.equals("拒绝")){
            holder.mTxt_status.setText("拒绝");
            holder.mTxt_status.setTextColor(Color.RED);
        }else {
            holder.mTxt_status.setText(taskNode);
            holder.mTxt_status.setTextColor(Color.BLACK);
        }
//        holder.mTxt_status.setText(taskNode);
        holder.mTxt_name2.setText(dataBean.getName());
        holder.mTxt_time22.setText(dataBean.getApplyDate());


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
        private TextView mTxt_name2,mTxt_time22,mTxt_status;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_name2= (TextView) itemView.findViewById(R.id.mTxt_name2);
            mTxt_time22= (TextView) itemView.findViewById(R.id.mTxt_time22);
            mTxt_status= (TextView) itemView.findViewById(R.id.mTxt_status);

        }
    }

    //增加一条数据
    public void insertData(int pos, Jinjian2_Bean.DataBean data) {
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
