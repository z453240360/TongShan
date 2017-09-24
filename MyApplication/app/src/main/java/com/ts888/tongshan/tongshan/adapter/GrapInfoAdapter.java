package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;
import com.ts888.tongshan.tongshan.bean.GrabBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GrapInfoAdapter extends RecyclerView.Adapter<GrapInfoAdapter.MyViewHolder> {
    private List<GrabBean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public GrapInfoAdapter(Context context, List<GrabBean.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_grapinfo, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        GrabBean.DataBean dataBean = mDatas.get(position);
        String customerName = dataBean.getCustomerName();
        long amount = dataBean.getAmount();

        holder.mTxt_name.setText(customerName);
        holder.mTxt_moneyNum.setText(amount+"");
        holder.mBtn_qiangdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position, holder.itemView);
                }
            }
        });
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_name,mTxt_moneyNum,mTxt_moneyUnit,mTxt_money;
        private Button mBtn_qiangdan;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_moneyNum = (TextView) itemView.findViewById(R.id.mTxt_moneyNum);
            mTxt_name = (TextView) itemView.findViewById(R.id.mTxt_name);
            mBtn_qiangdan = (Button) itemView.findViewById(R.id.mBtn_grap);
            mTxt_moneyUnit = (TextView) itemView.findViewById(R.id.mTxt_moneyUnit);
            mTxt_money = (TextView) itemView.findViewById(R.id.mTxt_money);
        }
    }

    //增加一条数据
    public void insertData(int pos, GrabBean.DataBean data) {
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
