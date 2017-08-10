package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ts888.tongshan.tongshan.R;

import java.util.ArrayList;
import java.util.List;


public class GeRenAdapter extends RecyclerView.Adapter<GeRenAdapter.MyViewHolder> {

    private List<String> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public GeRenAdapter(Context context, List<String> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. 初始化item的布局
        View view = mInflater.inflate(R.layout.adapter_geren, parent, false);
        //2. 创建出来ViewHolder对象
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        //获取当前数据
        if (position==0){
            holder.mTxt_geren_number.setCompoundDrawables(mContext.getResources().getDrawable(R.mipmap.diyi),null,null,null);
        }else if (position==1){
            holder.mTxt_geren_number.setCompoundDrawables(mContext.getResources().getDrawable(R.mipmap.dier),null,null,null);
        }else if (position==2){
            holder.mTxt_geren_number.setCompoundDrawables(mContext.getResources().getDrawable(R.mipmap.disan),null,null,null);
        }

        String str = mDatas.get(position);

        //设置不同条目的东西
        holder.mTxt_geren_number.setText("");
        //设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position, holder.itemView);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_geren_number,mTxt_geren_componey,mTxt_geren_name,mTxt_geren_money;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_geren_number = (TextView) itemView.findViewById(R.id.mTxt_geren_number);
            mTxt_geren_componey = (TextView) itemView.findViewById(R.id.mTxt_geren_componey);
            mTxt_geren_name = (TextView) itemView.findViewById(R.id.mTxt_geren_name);
            mTxt_geren_money = (TextView) itemView.findViewById(R.id.mTxt_geren_money);
        }
    }

    //增加一条数据
    public void insertData(int pos, String data) {
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
