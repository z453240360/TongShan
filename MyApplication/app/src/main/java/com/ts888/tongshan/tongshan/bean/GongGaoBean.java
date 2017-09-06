package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class GongGaoBean {


    /**
     * code : 1
     * data : [{"noticeTitle":"公告第三个标题哈！我会作废的","noticeContent":"西安铁一中附近某楼盘售楼处工作人员介绍：\u201c我们的楼盘是开发商和学校联合开发的，带铁一中滨湖校区的学位。不过，小学和初中分开算两个学位。买了房再买一个车位就可以额外送一个学位。\u201d目前该楼盘一期房子已经卖完。楼盘附近一家叫多乐居的房屋中介业务员说：\u201c学位房的\u2018学位\u2019一般只能用一次，有些还有年限，几年之内没用掉就作废了。","remark":"我是描述","h5Url":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/notice/app-notice-ffc35ab07d6a49ed9fe61f5e1482e6c4.jpg","noticeDate":"2017-08-30 00:00:00","noticeName":"张接"}]
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
         * noticeTitle : 公告第三个标题哈！我会作废的
         * noticeContent : 西安铁一中附近某楼盘售楼处工作人员介绍：“我们的楼盘是开发商和学校联合开发的，带铁一中滨湖校区的学位。不过，小学和初中分开算两个学位。买了房再买一个车位就可以额外送一个学位。”目前该楼盘一期房子已经卖完。楼盘附近一家叫多乐居的房屋中介业务员说：“学位房的‘学位’一般只能用一次，有些还有年限，几年之内没用掉就作废了。
         * remark : 我是描述
         * h5Url : https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/notice/app-notice-ffc35ab07d6a49ed9fe61f5e1482e6c4.jpg
         * noticeDate : 2017-08-30 00:00:00
         * noticeName : 张接
         */

        private String noticeTitle;
        private String noticeContent;
        private String remark;
        private String h5Url;
        private String noticeDate;
        private String noticeName;

        public String getNoticeTitle() {
            return noticeTitle;
        }

        public void setNoticeTitle(String noticeTitle) {
            this.noticeTitle = noticeTitle;
        }

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public String getNoticeDate() {
            return noticeDate;
        }

        public void setNoticeDate(String noticeDate) {
            this.noticeDate = noticeDate;
        }

        public String getNoticeName() {
            return noticeName;
        }

        public void setNoticeName(String noticeName) {
            this.noticeName = noticeName;
        }
    }
}
