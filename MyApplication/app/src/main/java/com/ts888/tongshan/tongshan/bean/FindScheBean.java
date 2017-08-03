package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/3.
 */

public class FindScheBean {

    /**
     * code : 1
     * data : {"verifySchedule":127,"userName":"刘丽华","applyAmt":10000,"applyDate":"2017-06-14 10:54:19","period":12,"idVerifyFinish":true}
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
         * verifySchedule : 127
         * userName : 刘丽华
         * applyAmt : 10000
         * applyDate : 2017-06-14 10:54:19
         * period : 12
         * idVerifyFinish : true
         */

        private int verifySchedule;
        private String userName;
        private int applyAmt;
        private String applyDate;
        private int period;
        private boolean idVerifyFinish;

        public int getVerifySchedule() {
            return verifySchedule;
        }

        public void setVerifySchedule(int verifySchedule) {
            this.verifySchedule = verifySchedule;
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

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public boolean isIdVerifyFinish() {
            return idVerifyFinish;
        }

        public void setIdVerifyFinish(boolean idVerifyFinish) {
            this.idVerifyFinish = idVerifyFinish;
        }
    }
}
