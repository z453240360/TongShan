package com.ts888.tongshan.tongshan.model;

import com.google.gson.Gson;
import com.ts888.tongshan.tongshan.bean.ApkUpDateParamsBeam;
import com.ts888.tongshan.tongshan.bean.BannerTypeBean;
import com.ts888.tongshan.tongshan.bean.FindCalcParameterBean;
import com.ts888.tongshan.tongshan.bean.LongHuParmsBean;
import com.ts888.tongshan.tongshan.bean.ParmsBean;
import com.ts888.tongshan.tongshan.util.EncoderUtils;

import static com.ts888.tongshan.tongshan.constant.Constant.API_KEY;
import static com.ts888.tongshan.tongshan.constant.Constant.SECURITY_KEY;

/**
 * Created by Administrator on 2017/8/3.
 * 网络请求逻辑层
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

//        iMainView.showLoading();

        String timeStamp = String.valueOf(System.currentTimeMillis());

        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;

        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
            String md51 = EncoderUtils.encoder(md5);
            dateModel.getSendVerfy(timeStamp, md51, params, new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getCode(s);
//                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
//                    iMainView.cancelLoading();

                }
            });
    }

    //账号登陆
    public void login(ParmsBean parmsBean) {
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;


        Gson g = new Gson();
        final String params = g.toJson(parmsBean);

        String md51 = EncoderUtils.encoder(md5);
            dateModel.getCheckVerifyCode(timeStamp, md51, params, new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
    }

    //根据用户身份证号和姓名查询进件状态
    public void getUserInfo(ParmsBean parmsBean,String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);

            dateModel.getRegistApply(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });

    }

    //根据userCode查询用户基本信息
    public void getFindUserBaseInfoByCode(ParmsBean parmsBean,String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getFindUserBaseInfoByCode(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });


    }

    //根据userCode查询用户认证进度
    public void getFindScheduleByCode(ParmsBean parmsBean,String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getFindScheduleByCode(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });

    }

    //查询待进件客户信息
    public void getFindInApprovalApplyInfo(ParmsBean parmsBean,String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getFindInApprovalApplyInfo(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });

    }

    //查询待进件客户信息
    public void getFindCalcParameter (ParmsBean parmsBean,String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getFindCalcParameter(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getLogin(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });

    }

    //试算
    public void getCalcContractInfoData (FindCalcParameterBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getCalcContractInfoData(timeStamp, md51, params, token,new ICallBack() {
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

    }


    //更新APP
    public void getApkUpdate(ApkUpDateParamsBeam parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
            dateModel.getApkUpdate(timeStamp, md51, params, token,new ICallBack() {
                @Override
                public void succesed(String s) {
                    iMainView.getUpDate(s);
                    iMainView.cancelLoading();
                }

                @Override
                public void failed(String s) {
                    iMainView.showFaliure(s);
                    iMainView.cancelLoading();
                }
            });

    }


    //个人战绩查询
    public void getIndividualRanking (LongHuParmsBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getIndividualRanking(timeStamp, md51, params, token,new ICallBack() {
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

    }


    //团队战绩
    public void getGroupRanking (LongHuParmsBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getGroupRanking(timeStamp, md51, params, token,new ICallBack() {
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

    }

    //门店战绩
    public void getOrgRanking (LongHuParmsBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getOrgRanking(timeStamp, md51, params, token,new ICallBack() {
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

    }

    //查询个人排名
    public void getFindRankingByStaffId (LongHuParmsBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getFindRankingByStaffId(timeStamp, md51, params, token,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getUpDate(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }

    //个人业绩查询
    public void getUserStatistics (LongHuParmsBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getUserStatistics(timeStamp, md51, params, token,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getUpDate(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });

    }


    //获取bannner
    public void getBanner(BannerTypeBean parmsBean, String token){
        iMainView.showLoading();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String md5 = SECURITY_KEY + "|" + API_KEY + "|" + timeStamp + "|" + SECURITY_KEY;
        Gson g = new Gson();
        final String params = g.toJson(parmsBean);
        String md51 = EncoderUtils.encoder(md5);
        dateModel.getBanner(timeStamp, md51, params, token,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getUpDate(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });

    }

}
