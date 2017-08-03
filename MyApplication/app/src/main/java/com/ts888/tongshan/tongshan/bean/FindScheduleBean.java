package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class FindScheduleBean {

    /**
     * code : 1
     * data : [{"userCode":"TS_20170612195357324986921","userName":"喻永富","applyAmt":10000,"applyDate":"2017-06-12 19:57:28","currVerifyName":"未认证"}]
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
         * userCode : TS_20170612195357324986921
         * userName : 喻永富
         * applyAmt : 10000
         * applyDate : 2017-06-12 19:57:28
         * currVerifyName : 未认证
         */

        private String userCode;
        private String userName;
        private int applyAmt;
        private String applyDate;
        private String currVerifyName;

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getApplyAmt() {
            return applyAmt;
        }

        public void setApplyAmt(int applyAmt) {
            this.applyAmt = applyAmt;
        }

        public String getApplyDate() {
            return applyDate;
        }

        public void setApplyDate(String applyDate) {
            this.applyDate = applyDate;
        }

        public String getCurrVerifyName() {
            return currVerifyName;
        }

        public void setCurrVerifyName(String currVerifyName) {
            this.currVerifyName = currVerifyName;
        }
    }
}
