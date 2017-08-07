package com.ts888.tongshan.tongshan.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/**
 * 限制输入框的小数点位数为2
 * Created by dongdong on 2017/8/7.
 */

public class EditTextUtil {


    public static void twoPoint(EditText editText){
        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if(source.equals(".") && dest.toString().length() == 0){
                    return "0.";
                }
                if(dest.toString().contains(".")){
                    int index = dest.toString().indexOf(".");
                    int mlength = dest.toString().substring(index).length();
                    if(mlength == 3){
                        return "";
                    }
                }
                return null;
            }
        }});
    }
}
