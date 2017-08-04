package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/4.
 */

public class ShiSuanDataBean {


    /**
     * code : 1
     * data : {"productCode":"Elite1.38","period":12,"applyAmt":1000,"contractAmt":1100,"netAmt":822.14,"perRepayAmt":99.28,"costMonthly":1.38}
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
         * productCode : Elite1.38
         * period : 12
         * applyAmt : 1000
         * contractAmt : 1100.0
         * netAmt : 822.14
         * perRepayAmt : 99.28
         * costMonthly : 1.38
         */

        private String productCode;
        private int period;
        private int applyAmt;
        private double contractAmt;
        private double netAmt;
        private double perRepayAmt;
        private double costMonthly;

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getApplyAmt() {
            return applyAmt;
        }

        public void setApplyAmt(int applyAmt) {
            this.applyAmt = applyAmt;
        }

        public double getContractAmt() {
            return contractAmt;
        }

        public void setContractAmt(double contractAmt) {
            this.contractAmt = contractAmt;
        }

        public double getNetAmt() {
            return netAmt;
        }

        public void setNetAmt(double netAmt) {
            this.netAmt = netAmt;
        }

        public double getPerRepayAmt() {
            return perRepayAmt;
        }

        public void setPerRepayAmt(double perRepayAmt) {
            this.perRepayAmt = perRepayAmt;
        }

        public double getCostMonthly() {
            return costMonthly;
        }

        public void setCostMonthly(double costMonthly) {
            this.costMonthly = costMonthly;
        }
    }
}
