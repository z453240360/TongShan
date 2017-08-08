package com.ts888.tongshan.tongshan.model;

import android.util.Log;
import android.widget.Toast;

import com.ts888.tongshan.tongshan.constant.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/8/3.
 */

public class DateModel {


    public Retrofit getClict(final String timeStamp, final String md51) {
        //添加请求头信息
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Request build = builder1.addHeader("X-SignInfo", md51) //验签信息
                                .addHeader("X-Channel", "iwifi-offical")//  渠道名称
                                .addHeader("X-Timestamp", timeStamp)// 时间戳
                                .addHeader("Content-Type", "application/json")
                                .build();
                        return chain.proceed(build);
                    }
                }).retryOnConnectionFailure(true)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.BASEURL)
                .build();

        return retrofit;
    }


    //获取验证码
    public void getSendVerfy(final String timeStamp, final String md51, String params,final ICallBack callBack) {

        Retrofit retrofit = getClict(timeStamp, md51);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getSendVerifyCode(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {


                try {

                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                callBack.failed("网络请求失败");
            }
        });
    }

    //登陆账号
    public void getCheckVerifyCode(final String timeStamp, final String md51, String params,final ICallBack callBack) {

        Retrofit retrofit = getClict(timeStamp, md51);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getCheckVerifyCode(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败" );
            }
        });
    }


    public Retrofit getUserClict(final String timeStamp, final String md51, final String token) {
        //添加请求头信息
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        Request build = builder1.addHeader("X-SignInfo", md51) //验签信息
                                .addHeader("X-Channel", "iwifi-offical")//  渠道名称
                                .addHeader("X-Timestamp", timeStamp)// 时间戳
                                .addHeader("Content-Type", "application/json")
                                .addHeader("X-Token",token)
                                .build();
                        return chain.proceed(build);
                    }
                }).retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.BASEURL)
                .build();

        return retrofit;
    }


    //根据用户身份证号和姓名查询进件状态
    public void getRegistApply(final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getRegistApply(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败");
            }
        });

    }

    //根据userCode查询用户基本信息
    public void getFindUserBaseInfoByCode(final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getFindUserBaseInfoByCode(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败" );
            }
        });

    }

    //根据userCode查询用户认证进度

    public void getFindScheduleByCode(final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getFindScheduleByCode(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败");
            }
        });

    }

    //查询待进件客户信息
    public void getFindInApprovalApplyInfo(final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getFindInApprovalApplyInfo(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败");
            }
        });

    }


    //获取试算参数
    public void getFindCalcParameter (final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getFindCalcParameter(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    if (null==response.body()){
                        callBack.failed("请求的数据为空，或参数异常");
                        return;
                    }
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败");
            }
        });

    }

    //试算
    public void getCalcContractInfoData  (final String timeStamp, final String md51, String params,String token,final ICallBack callBack){

        Retrofit retrofit = getUserClict(timeStamp,md51,token);
        IService iService = retrofit.create(IService.class);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params);

        Call<ResponseBody> calls = iService.getCalcContractInfoData(body);

        calls.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String responseBodyMsg = response.body().string();
                    if (("").equals(responseBodyMsg) || null == responseBodyMsg){
                        return;
                    }
                    callBack.succesed(responseBodyMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败,请检查网络");
            }
        });

    }














}
