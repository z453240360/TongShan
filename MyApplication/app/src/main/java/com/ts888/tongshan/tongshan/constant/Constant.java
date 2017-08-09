package com.ts888.tongshan.tongshan.constant;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface Constant {


    //APP版本号
    String APPVERSION="1.0.0";
    //app渠道
    String CHANNEL = "xscxapp";

    String BASEURL = "https://appsales-uat.tsjinrong.cn/";

    //发送验证码
    String sendVerifyCode = "appsales-entry/login/sendVerifyCode";

    //登陆
    String checkVerifyCode = "appsales-entry/login/checkVerifyCode";

    //根据身份证和姓名查询进件状态
    String registApply = "appsales-entry/applyInfo/registApply";

    //根据userCode查询用户基本信息
    String findUserBaseInfoByCode = "appsales-entry/applyInfo/findUserBaseInfoByCode";

    //根据userCode查询用户认证进度
    String findScheduleByCode = "appsales-entry/applyInfo/findScheduleByCode";

    // 根据用户状态查询客户
    String findApplyInfoByStatus = "appsales-entry/applyInfo/findApplyInfoByStatus";

    //查询待进件客户信息
    String findInApprovalApplyInfo = "appsales-entry/applyInfo/findInApprovalApplyInfo";

    //获取试算参数
    String findCalcParameter = "appsales-entry/calcContractInfo/findCalcParameter";

    //获取试算参数
    String calcContractInfoData = "appsales-entry/calcContractInfo/calcContractInfoData ";

    //APK更新
    String apkUpdate = "appsales-entry/apk/apkUpdate";

    //上传apk
    String apkInfo = "appsales-entry/appcredit-admin/apk/apkInfo";

    String API_KEY = "pmjWn6kLz6mcQf2N";

    String SECURITY_KEY = "1cLLub8UOLvlT69ITSBFgHX50f9T4rOG";

}
