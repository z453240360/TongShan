package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.IndividualRanking;
import com.ts888.tongshan.tongshan.util.DataFormatFromInt;

import java.util.ArrayList;
import java.util.List;


public class QiangdanAdapter extends RecyclerView.Adapter<QiangdanAdapter.MyViewHolder> {

    private List<IndividualRanking.DataBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private Boolean isFirst;

    public QiangdanAdapter(Context context, List<IndividualRanking.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. 初始化item的布局
        View view = mInflater.inflate(R.layout.adapter_qiangdan, parent, false);
        //2. 创建出来ViewHolder对象
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        IndividualRanking.DataBean dataBean = mDatas.get(position);


//        holder.mTxt_geren_number.setText("第 "+individualRanking+" 名");
//        holder.mTxt_geren_componey.setText(orgName);
//        holder.mTxt_geren_money.setText(aFloat+" 万元");
//        holder.mTxt_geren_name.setText(staffName);
//
//        //设置点击事件
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.onItemClick(position, holder.itemView);
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_qiandan_number,mTxt_geren_componey,mTxt_geren_name,mTxt_geren_money;
        private Button mBtn_qiandan;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTxt_qiandan_number = (TextView) itemView.findViewById(R.id.mTxt_qiandan_number);
            mTxt_geren_componey = (TextView) itemView.findViewById(R.id.mTxt_geren_componey);


            mTxt_geren_componey.setMovementMethod(ScrollingMovementMethod.getInstance());
            mTxt_geren_componey.setHorizontallyScrolling(true);


            mBtn_qiandan = (Button) itemView.findViewById(R.id.mTxt_geren_name);
            mTxt_geren_money = (TextView) itemView.findViewById(R.id.mTxt_geren_money);
        }
    }

//    //增加一条数据
//    public void insertData(int pos, IndividualRanking.DataBean data) {
//        mDatas.add(pos, data);
//
//        notifyItemInserted(pos);
//    }
//
//    //删除一条数据
//    public void removeData(int pos) {
//        mDatas.remove(pos);
//        notifyItemRemoved(pos);
//    }
//
//
//    public interface OnItemClickListener {
//        void onItemClick(int pos, View view);
//    }
//
//    private OnItemClickListener mListener;
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mListener = listener;
//    }

}
