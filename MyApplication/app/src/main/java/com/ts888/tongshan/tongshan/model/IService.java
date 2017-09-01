package com.ts888.tongshan.tongshan.model;

import com.ts888.tongshan.tongshan.constant.Constant;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/8/3.
 * 地址请求接口类
 */

public interface IService {



    //发送验证码
    @POST(Constant.sendVerifyCode)
    Call<ResponseBody> getSendVerifyCode(@Body RequestBody verifyCode);

    // 登陆
    @POST(Constant.checkVerifyCode)
    Call<ResponseBody> getCheckVerifyCode(@Body RequestBody user);

    //查询进件状态
    @POST(Constant.registApply)
    Call<ResponseBody> getRegistApply(@Body RequestBody jinjian);

    //根据userCode查询用户基本信息
    @POST(Constant.findUserBaseInfoByCode)
    Call<ResponseBody> getFindUserBaseInfoByCode(@Body RequestBody userCode);


    //根据userCode查询用户认证进度
    @POST(Constant.findScheduleByCode)
    Call<ResponseBody> getFindScheduleByCode(@Body RequestBody userCode);


    //根据用户状态查询客户
    @POST(Constant.findApplyInfoByStatus)
    Call<ResponseBody> getFindApplyInfoByStatus(@Body RequestBody status);

    //查询待进件客户信息
    @POST(Constant.findInApprovalApplyInfo)
    Call<ResponseBody> getFindInApprovalApplyInfo(@Body RequestBody status);

    //获取试算参数
    @POST(Constant.findCalcParameter )
    Call<ResponseBody> getFindCalcParameter(@Body RequestBody status);

    //试算
    @POST(Constant.calcContractInfoData  )
    Call<ResponseBody> getCalcContractInfoData (@Body RequestBody status);

    //APK更新
    @POST(Constant.apkUpdate  )
    Call<ResponseBody> getApkUpdate (@Body RequestBody status);


    //个人战绩
    @POST(Constant.getIndividualRanking)
    Call<ResponseBody> getIndividualRanking(@Body RequestBody status);
    //团队战绩
    @POST(Constant.getGroupRanking)
    Call<ResponseBody> getGroupRanking (@Body RequestBody status);
    //门店战绩
    @POST(Constant.getOrgRanking)
    Call<ResponseBody> getOrgRanking (@Body RequestBody status);

    //查询个人排名
    @POST(Constant.getFindRankingByStaffId)
    Call<ResponseBody> getFindRankingByStaffId (@Body RequestBody status);

    //查询个人排名
    @POST(Constant.getUserStatistics)
    Call<ResponseBody> getUserStatistics (@Body RequestBody status);

    //获取banner
    @POST(Constant.Banner)
    Call<ResponseBody> getBanner(@Body RequestBody status);


}
