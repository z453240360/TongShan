package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by dongdong on 2017/8/4.
 */

public class ShisuanParmBean {


    /**
     * code : 1
     * data : {"periods":[12,18,24],"productInfos":[{"productCode":"Elite1.38","costMonthly":"1.38"},{"productCode":"Elite1.58","costMonthly":"1.58"},{"productCode":"Elite1.78","costMonthly":"1.78"},{"productCode":"Elite1.98","costMonthly":"1.98"},{"productCode":"Elite2.18","costMonthly":"2.18"},{"productCode":"Elite2.38","costMonthly":"2.38"}]}
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
        private List<Integer> periods;
        private List<ProductInfosBean> productInfos;

        public List<Integer> getPeriods() {
            return periods;
        }

        public void setPeriods(List<Integer> periods) {
            this.periods = periods;
        }

        public List<ProductInfosBean> getProductInfos() {
            return productInfos;
        }

        public void setProductInfos(List<ProductInfosBean> productInfos) {
            this.productInfos = productInfos;
        }

        public static class ProductInfosBean {
            /**
             * productCode : Elite1.38
             * costMonthly : 1.38
             */

            private String productCode;
            private String costMonthly;

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getCostMonthly() {
                return costMonthly;
            }

            public void setCostMonthly(String costMonthly) {
                this.costMonthly = costMonthly;
            }
        }
    }
}
