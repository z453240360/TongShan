package com.ts888.tongshan.tongshan.constant;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface Constant {


    //APP版本号
    String APPVERSION="1.0.0";
    //app渠道
    String CHANNEL = "official";

    //测试环境
//    String BASEURL = "https://appsales-uat.tsjinrong.cn/";
    //生产环境
    String BASEURL = "https://appsales.tsjinrong.cn/";

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

    //个人战绩
    String getIndividualRanking = "appsales-entry/ranking/getIndividualRanking";

    //团队战绩
    String getGroupRanking = "appsales-entry/ranking/getGroupRanking";

    //门店战绩
    String getOrgRanking = "appsales-entry/ranking/getOrgRanking";

    //查询个人排名
    String getFindRankingByStaffId = "appsales-entry/ranking/findRankingByStaffId ";

    //查询个人排名
    String getUserStatistics = "appsales-entry/statistics/getUserStatistics";

    //上传apk
    String apkInfo = "appsales-entry/appcredit-admin/apk/apkInfo";

    String API_KEY = "pmjWn6kLz6mcQf2N";

    String SECURITY_KEY = "1cLLub8UOLvlT69ITSBFgHX50f9T4rOG";

    //轮播页面  参数：（0 ：首页bannner），（1,：启动页吧bannner）
    String Banner ="appsales-entry/banner/findBannerByType";

}
