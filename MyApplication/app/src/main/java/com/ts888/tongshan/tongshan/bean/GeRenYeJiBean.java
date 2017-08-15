package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class GeRenYeJiBean {

    /**
     * code : 1
     * data : {"piecesSum":"85","piecesOk":"50","signCount":"45","loanCount":"28","cancelCount":"5","refuseCount":"35","loanAmount":"180000","overdueCount":"6"}
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
         * piecesSum : 85
         * piecesOk : 50
         * signCount : 45
         * loanCount : 28
         * cancelCount : 5
         * refuseCount : 35
         * loanAmount : 180000
         * overdueCount : 6
         */

        private String piecesSum;
        private String piecesOk;
        private String signCount;
        private String loanCount;
        private String cancelCount;
        private String refuseCount;
        private String loanAmount;
        private String overdueCount;

        public String getPiecesSum() {
            return piecesSum;
        }

        public void setPiecesSum(String piecesSum) {
            this.piecesSum = piecesSum;
        }

        public String getPiecesOk() {
            return piecesOk;
        }

        public void setPiecesOk(String piecesOk) {
            this.piecesOk = piecesOk;
        }

        public String getSignCount() {
            return signCount;
        }

        public void setSignCount(String signCount) {
            this.signCount = signCount;
        }

        public String getLoanCount() {
            return loanCount;
        }

        public void setLoanCount(String loanCount) {
            this.loanCount = loanCount;
        }

        public String getCancelCount() {
            return cancelCount;
        }

        public void setCancelCount(String cancelCount) {
            this.cancelCount = cancelCount;
        }

        public String getRefuseCount() {
            return refuseCount;
        }

        public void setRefuseCount(String refuseCount) {
            this.refuseCount = refuseCount;
        }

        public String getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(String loanAmount) {
            this.loanAmount = loanAmount;
        }

        public String getOverdueCount() {
            return overdueCount;
        }

        public void setOverdueCount(String overdueCount) {
            this.overdueCount = overdueCount;
        }
    }
}
