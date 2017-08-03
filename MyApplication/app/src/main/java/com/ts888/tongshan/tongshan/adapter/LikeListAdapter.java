package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.FindScheduleBean;

import java.util.ArrayList;
import java.util.List;


/**
 * ***********************************************************
 * author: Randy
 * time: 上午9:31
 * name: RecyclerView的Adapter的写法
 * desc:
 * step:
 * 1. 继承RecyclerView.Adapter<VH extends ViewHolder>
 * 2. 在这个Adapter中写一个类继承RecyclerView.ViewHolder,并且传入Adapter的泛型
 * 3. 实现 三个抽象方法
 * getItemCount
 * onCreateViewHolder
 * onBindViewHolder
 * 4. 重写构造方法,参数传入 上下文Context 数据集
 * *************************************************************
 */
public class LikeListAdapter extends RecyclerView.Adapter<LikeListAdapter.MyViewHolder> {
    private List<FindScheduleBean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public LikeListAdapter(Context context, List<FindScheduleBean.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    //返回RecyclerView总共有多少条
    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    //初始化布局,创建ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. 初始化item的布局
        View view = mInflater.inflate(R.layout.adapter_kehu, parent, false);
        //2. 创建出来ViewHolder对象
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    //绑定ViewHolder中的控件的数据
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


        holder.mTxt_jianban.setText(currVerifyName);
        holder.mTxt_time.setText(applyDate);
        holder.mTxt_sunxiaobao.setText(userName);
        holder.mTxt_wuqian.setText(""+applyAmt+"元");

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
