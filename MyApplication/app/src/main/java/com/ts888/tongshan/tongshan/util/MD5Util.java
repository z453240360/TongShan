package com.ts888.tongshan.tongshan.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/1.
 * 这个方法与这个App不匹配
 */

public class MD5Util {

        public static String getMD5(String val) throws NoSuchAlgorithmException {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(val.getBytes());
            byte[] m = md5.digest();//加密
            return getString(m);
        }

        private static String getString(byte[] b){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < b.length; i ++){
                sb.append(b[i]);
            }
            return sb.toString();
        }
}
