package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/3.
 */

public class LoginBean {

    /**
     * code : 1
     * data : {"token":"430f364695937d68a333290f3842670b","userCode":"SA_20170801102850095696304","phoneNo":"18616850001"}
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
         * token : 430f364695937d68a333290f3842670b
         * userCode : SA_20170801102850095696304
         * phoneNo : 18616850001
         */

        private String token;
        private String userCode;
        private String phoneNo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }
    }
}
