package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class BannerResultBean {


    /**
     * code : 1
     * data : [{"title":"夏日","imgUrl":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/static/banner/banner1.jpg","type":1,"status":1,"priority":1,"redirectUrl":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/static/banner/banner1.jpg"},{"title":null,"imgUrl":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/static/banner/banner1.jpg","type":1,"status":1,"priority":2,"redirectUrl":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/notice/app-notice-98fc0d8561e74f929e0df8b06414a8e7.jpg"}]
     * message : null
     */

    private String code;
    private Object message;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 夏日
         * imgUrl : https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/static/banner/banner1.jpg
         * type : 1
         * status : 1
         * priority : 1
         * redirectUrl : https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/static/banner/banner1.jpg
         */

        private String title;
        private String imgUrl;
        private int type;
        private int status;
        private int priority;
        private String redirectUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }
    }
}
