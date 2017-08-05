package com.ts888.tongshan.tongshan.model;

import android.content.Context;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.util.MD5Util;

import java.security.NoSuchAlgorithmException;

import static com.ts888.tongshan.tongshan.constant.Constant.API_KEY;
import static com.ts888.tongshan.tongshan.constant.Constant.SECURITY_KEY;

/**
 * Created by Administrator on 2017/8/3.
 */

public class Present {

    private DateModel dateModel;
    private IMainView iMainView;

    public Present(IMainView mIMainView) {
        dateModel = new DateModel();
        this.iMainView = mIMainView;
    }

    //获取验证码
    public void loadData(ParmsBean parmsBean) {

        iMainView.showLoading();

        String timeStamp = String.valueOf(System.currentTimeMillis());

        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;

        Gson g = new Gson();
        final String params = g.toJson(parmsBean);

        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getSendVerfy(timeStamp, md51, params, new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getCode(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();

                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

    //账号登陆
    public void login(ParmsBean parmsBean) {
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);

        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getCheckVerifyCode(timeStamp, md51, params, new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //根据用户身份证号和姓名查询进件状态
    public void getUserInfo(ParmsBean parmsBean,String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getRegistApply(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    //根据userCode查询用户基本信息
    public void getFindUserBaseInfoByCode(ParmsBean parmsBean,String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getFindUserBaseInfoByCode(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    //根据userCode查询用户认证进度
    public void getFindScheduleByCode(ParmsBean parmsBean,String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getFindScheduleByCode(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    //查询待进件客户信息
    public void getFindInApprovalApplyInfo(ParmsBean parmsBean,String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getFindInApprovalApplyInfo(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    //查询待进件客户信息
    public void getFindCalcParameter (ParmsBean parmsBean,String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getFindCalcParameter(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    //试算
    public void getCalcContractInfoData (FindCalcParameterBean parmsBean, String token){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        try {
            String md51 = MD5Util.getMD5(md5);

            dateModel.getCalcContractInfoData(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getCode(s);
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }




}
