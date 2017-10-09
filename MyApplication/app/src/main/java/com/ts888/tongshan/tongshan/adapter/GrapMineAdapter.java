package com.ts888.tongshan.tongshan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ts888.tongshan.tongshan.R;
import com.ts888.tongshan.tongshan.bean.GrapMyBean;
import com.ts888.tongshan.tongshan.bean.OrgRankingBean;
import com.ts888.tongshan.tongshan.util.DataFormatFromInt;
import com.ts888.tongshan.tongshan.util.DataUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GrapMineAdapter extends RecyclerView.Adapter<GrapMineAdapter.MyViewHolder> {

    private List<GrapMyBean.DataBean> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private Map<Integer,Boolean> map=new HashMap<>();
    private boolean isFirst=true;

    private String TAG ="dd";
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
    }//1

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.itemView.setTag(position);

        GrapMyBean.DataBean dataBean = mDatas.get(position);
        String phoneNo = dataBean.getPhoneNo();//电话
        long amount = dataBean.getAmount();//申请金额
        String grabTime = dataBean.getGrabTime();//申请时间
        String customerName = dataBean.getCustomerName();//客户姓名

        Date date = null;
        String justTime ="";
        try {
            date = DataUtils.stringToDate(grabTime, "yyyy-MM-dd kk:mm:ss");
            justTime = DataUtils.formatDateTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.mTxt_name.setText(customerName);
        holder.mTxt_moneyNum.setText(amount+"");
        holder.mTxt_sucessed.setText(justTime);
        holder.rl_dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFirst){
                    map.put((Integer) holder.itemView.getTag(),true);
                    isFirst=false;
                    holder.rl.setVisibility(View.VISIBLE);
                    holder.mImg_flag.setImageResource(R.mipmap.dd_shouqi);
                }else {
                    map.put((Integer) holder.itemView.getTag(),false);
                    isFirst=true;
                    holder.rl.setVisibility(View.GONE);
                    holder.mEd_send.setText("");
                    holder.mImg_flag.setImageResource(R.mipmap.dd_xiala);
                }
            }
        });

        holder.mImg_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onPhoneButtonClick((Integer) holder.itemView.getTag(), holder.mEd_send.getText().toString());
                }
            }
        });


        holder.mImg_msm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onMsmClicked((Integer) holder.itemView.getTag(), "我在哪里"+position);
                }
            }
        });

        holder.mBtn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onComfirmClicked((Integer) holder.itemView.getTag(), holder.mEd_send.getText().toString());
                }
            }
        });


        if (map.get((Integer) holder.itemView.getTag())==null){
            map.put((Integer) holder.itemView.getTag(),false);
        }

        if(map.get((Integer) holder.itemView.getTag())) {
            holder.rl.setVisibility(View.VISIBLE);
            holder.mImg_flag.setImageResource(R.mipmap.dd_shouqi);
        }else {
            holder.rl.setVisibility(View.GONE);
            holder.mImg_flag.setImageResource(R.mipmap.dd_xiala);
        }

    }//4

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }//3

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxt_name,mTxt_moneyNum,mTxt_sucessed;
        private ImageView mImg_flag,mImg_phone,mImg_msm;
        private EditText mEd_send;
        private RelativeLayout rl,rl_dd;
        private Button mBtn_send;

        public MyViewHolder(View itemView) {
            super(itemView);
            mBtn_send = (Button) itemView.findViewById(R.id.mBtn_send);
            mTxt_name = (TextView) itemView.findViewById(R.id.mTxt_name);
            mTxt_moneyNum = (TextView) itemView.findViewById(R.id.mTxt_moneyNum);
            mTxt_sucessed = (TextView) itemView.findViewById(R.id.mTxt_succesed);
            mImg_flag = (ImageView) itemView.findViewById(R.id.mImg_flag);
            mImg_phone = (ImageView) itemView.findViewById(R.id.mImg_phone);
            mImg_msm = (ImageView) itemView.findViewById(R.id.mImg_msm);
            mEd_send = (EditText) itemView.findViewById(R.id.mEd_cancle);
            rl = (RelativeLayout) itemView.findViewById(R.id.rl);
            rl_dd = (RelativeLayout) itemView.findViewById(R.id.rl_dd);
        }
    }//2

    //增加一条数据
    public void insertData(int pos,GrapMyBean.DataBean data) {
        mDatas.add(pos, data);
        notifyItemInserted(pos);
    }

    //删除一条数据
    public void removeData(int pos) {
        mDatas.remove(pos);
        map.clear();
        notifyItemRemoved(pos);
    }

    public void clearMap(){
        map.clear();
    }

    public interface OnItemClickListener {
        void onItemClick(int pos, View view);
        void onPhoneButtonClick(int pos,String s);
        void onMsmClicked(int pos,String s);
        void onComfirmClicked(int pos,String s);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

}
