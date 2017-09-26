package com.ts888.tongshan.tongshan.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/26.
 */

public class ShowTostUtil {
    public static void toast(Context c,String s){
        Toast.makeText(c, ""+s, Toast.LENGTH_SHORT).show();
    }
}
