package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GroupRankingBean;
import com.ts888.tongshan.tongshan.bean.IndividualRanking;
import com.ts888.tongshan.tongshan.util.DataFormatFromInt;

import java.util.ArrayList;
import java.util.List;


public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {

    private List<GroupRankingBean.DataBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private Boolean isFirst;

    public GroupAdapter(Context context, List<GroupRankingBean.DataBean> datas) {
        this.mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. 初始化item的布局
        View view = mInflater.inflate(R.layout.adapter_grop, parent, false);
        //2. 创建出来ViewHolder对象
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        GroupRankingBean.DataBean dataBean = mDatas.get(position);
        String staffName = dataBean.getGroupName(); //团队名称
        int individualRanking = dataBean.getGroupRanking(); //团队排名
        int individualResults = dataBean.getGroupResults();  //团队业绩
        String groupLeaderName = dataBean.getGroupLeaderName();  //队长姓名
        String orgName = dataBean.getOrgName();



        String aFloat = DataFormatFromInt.getDoubleByDouble((double) individualResults/10000);

        //获取当前数据
        if (individualRanking==1){

            Drawable ss = mContext.getResources().getDrawable(R.mipmap.diyi);
            ss.setBounds(0,0,60,90);

            holder.mTxt_geren_number.setCompoundDrawables(ss,null,null,null);
            holder.mTxt_geren_number.setCompoundDrawablePadding(5);
            holder.mTxt_geren_number.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_componey.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_money.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_name.setTextColor(Color.rgb(18,108,176));
        }else if (individualRanking==2){
            Drawable ss = mContext.getResources().getDrawable(R.mipmap.dier);
            ss.setBounds(0,0,60,90);
            holder.mTxt_geren_number.setCompoundDrawables(ss,null,null,null);
            holder.mTxt_geren_number.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_componey.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_money.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_name.setTextColor(Color.rgb(18,108,176));
        }else if (individualRanking==3){
            Drawable ss = mContext.getResources().getDrawable(R.mipmap.disan);
            ss.setBounds(0,0,60,90);
            holder.mTxt_geren_number.setCompoundDrawables(ss,null,null,null);
            holder.mTxt_geren_number.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_componey.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_money.setTextColor(Color.rgb(18,108,176));
            holder.mTxt_geren_name.setTextColor(Color.rgb(18,108,176));
        }else {
            Drawable ss = mContext.getResources().getDrawable(R.mipmap.disan);
            holder.mTxt_geren_number.setCompoundDrawables(ss,null,null,null);

            holder.mTxt_geren_componey.setTextColor(Color.rgb(85,85,85));
            holder.mTxt_geren_money.setTextColor(Color.rgb(85,85,85));
            holder.mTxt_geren_name.setTextColor(Color.rgb(85,85,85));
            holder.mTxt_geren_number.setTextColor(Color.rgb(85,85,85));
        }

        holder.mTxt_geren_number.setText("第 "+individualRanking+" 名");
        holder.mTxt_geren_componey.setText(orgName+staffName);
        holder.mTxt_geren_money.setText(groupLeaderName);
        holder.mTxt_geren_name.setText(staffName);

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
        return mDatas == null ? 0 : mDatas.size();
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
    public void insertData(int pos, GroupRankingBean.DataBean data) {
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
