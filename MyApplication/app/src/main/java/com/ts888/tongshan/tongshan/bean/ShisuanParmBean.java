package com.ts888.tongshan.tongshan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dongdong on 2017/8/4.
 */

public class ShisuanParmBean {


    /**
     * code : 1
     * data : {"periods":[12,18,24],"productInfos":{"Elite1.38":"1.38","Elite1.58":"1.58","Elite1.78":"1.78","Elite1.98":"1.98","Elite2.38":"2.38","Elite2.18":"2.18"}}
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
         * periods : [12,18,24]
         * productInfos : {"Elite1.38":"1.38","Elite1.58":"1.58","Elite1.78":"1.78","Elite1.98":"1.98","Elite2.38":"2.38","Elite2.18":"2.18"}
         */

        private ProductInfosBean productInfos;
        private List<Integer> periods;

        public ProductInfosBean getProductInfos() {
            return productInfos;
        }

        public void setProductInfos(ProductInfosBean productInfos) {
            this.productInfos = productInfos;
        }

        public List<Integer> getPeriods() {
            return periods;
        }

        public void setPeriods(List<Integer> periods) {
            this.periods = periods;
        }

        public static class ProductInfosBean {
            @SerializedName("Elite1.38")
            private String _$Elite13813; // FIXME check this code
            @SerializedName("Elite1.58")
            private String _$Elite158296; // FIXME check this code
            @SerializedName("Elite1.78")
            private String _$Elite17861; // FIXME check this code
            @SerializedName("Elite1.98")
            private String _$Elite198202; // FIXME check this code
            @SerializedName("Elite2.38")
            private String _$Elite238115; // FIXME check this code
            @SerializedName("Elite2.18")
            private String _$Elite218278; // FIXME check this code

            public String get_$Elite13813() {
                return _$Elite13813;
            }

            public void set_$Elite13813(String _$Elite13813) {
                this._$Elite13813 = _$Elite13813;
            }

            public String get_$Elite158296() {
                return _$Elite158296;
            }

            public void set_$Elite158296(String _$Elite158296) {
                this._$Elite158296 = _$Elite158296;
            }

            public String get_$Elite17861() {
                return _$Elite17861;
            }

            public void set_$Elite17861(String _$Elite17861) {
                this._$Elite17861 = _$Elite17861;
            }

            public String get_$Elite198202() {
                return _$Elite198202;
            }

            public void set_$Elite198202(String _$Elite198202) {
                this._$Elite198202 = _$Elite198202;
            }

            public String get_$Elite238115() {
                return _$Elite238115;
            }

            public void set_$Elite238115(String _$Elite238115) {
                this._$Elite238115 = _$Elite238115;
            }

            public String get_$Elite218278() {
                return _$Elite218278;
            }

            public void set_$Elite218278(String _$Elite218278) {
                this._$Elite218278 = _$Elite218278;
            }
        }
    }
}
