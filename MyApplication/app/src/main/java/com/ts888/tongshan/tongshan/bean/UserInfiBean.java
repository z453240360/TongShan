package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/3.
 */

public class UserInfiBean {

    /**
     * code : 1
     * data : {"detail":"允许进件！","success":true}
     * message : null
     */

    private String code;
    private DataBean data;
    private Object message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * detail : 允许进件！
         * success : true
         */

        private String detail;
        private boolean success;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}
