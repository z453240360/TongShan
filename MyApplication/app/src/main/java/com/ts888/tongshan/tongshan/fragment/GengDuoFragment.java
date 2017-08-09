package com.ts888.tongshan.tongshan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ts888.tongshan.tongshan.R;


/**
 * Created by dongdong on 2017/7/30.
 * 业务页显示的第三个按钮对应的页面（更多页面）
 */

public class GengDuoFragment extends Fragment {

    private Button mBtn_updata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gengduo,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtn_updata = (Button) view.findViewById(R.id.mBtn_updata);

        mBtn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.getText("updata");
            }
        });
    }


    public interface TextCallBack{
        void getText(String str);
    }

    private ShouyeFragment.TextCallBack callBack;

    public void setCallBack(ShouyeFragment.TextCallBack callBack){
        this.callBack = callBack;
    }
}
