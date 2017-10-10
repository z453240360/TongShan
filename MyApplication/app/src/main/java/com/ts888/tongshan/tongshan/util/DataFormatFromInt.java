package com.ts888.tongshan.tongshan.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 格式化数据 保留两位小数
 * Created by dongdong on 2017/8/7.
 */

public class DataFormatFromInt {


    public static String getFloat(int data){

        //格式化数据
        float v = (float)(data);
        DecimalFormat fnum = new DecimalFormat("##0.00");
        fnum.setRoundingMode(RoundingMode.HALF_UP);
        String dd=fnum.format(v);
        return dd;
    }

    public static String getFloatByFloat(float data){

        DecimalFormat fnum = new DecimalFormat("##0.00");
        fnum.setRoundingMode(RoundingMode.HALF_UP);
        String dd=fnum.format(data);
        return dd;
    }


    //double类型保留两位小数
    public static String getDoubleByDouble(double data){

        DecimalFormat fnum = new DecimalFormat("##0.00");
        fnum.setRoundingMode(RoundingMode.HALF_UP);
        String dd=fnum.format(data);
        return dd;
    }
}
