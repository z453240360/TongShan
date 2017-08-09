package com.ts888.tongshan.tongshan.model;

/**
 * Created by Administrator on 2017/8/3.
 * Activtiy实现接口，用于处理网络请求后的数据逻辑
 *
 */

public interface IMainView {
    void getCode(String s);
    void showLoading();
    void cancelLoading();
    void showFaliure(String s);
    void getLogin(String s);
    void getUpDate(String s);
}
