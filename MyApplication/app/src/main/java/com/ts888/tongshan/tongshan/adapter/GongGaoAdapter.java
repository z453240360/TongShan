package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GongGaoBean;

import java.util.ArrayList;
import java.util.List;

public class GongGaoAdapter extends RecyclerView.Adapter<GongGaoAdapter.MyViewHolder> {
    private List<GongGaoBean.DataBean> mDatas = new ArrayList();
    private Context mContext;
    private LayoutInflater mInflater;

    public GongGaoAdapter(Context context, List<GongGaoBean.DataBean> datas) {
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
        View view = mInflater.inflate(R.layout.adapter_gonggao, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        GongGaoBean.DataBean dataBean = mDatas.get(position);

        holder.gg_message.setText(dataBean.getNoticeTitle());
        holder.gg_title.setText(dataBean.getRemark());
        holder.gg_time.setText(dataBean.getNoticeDate());
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
        private TextView gg_time, gg_title, gg_message;

        public MyViewHolder(View itemView) {
            super(itemView);
            gg_time = (TextView) itemView.findViewById(R.id.gg_time);
            gg_title = (TextView) itemView.findViewById(R.id.gg_title);
            gg_message = (TextView) itemView.findViewById(R.id.gg_message);
        }
    }

    //增加一条数据
    public void insertData(int pos, GongGaoBean.DataBean data) {
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
