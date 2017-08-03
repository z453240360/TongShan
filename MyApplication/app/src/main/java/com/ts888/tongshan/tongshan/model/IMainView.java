package com.ts888.tongshan.tongshan.model;

/**
 * Created by Administrator on 2017/8/3.
 */

public interface IMainView {
    void getCode(String s);
    void showLoading();
    void cancelLoading();
    void showFaliure(String s);
    void getLogin(String s);
}
