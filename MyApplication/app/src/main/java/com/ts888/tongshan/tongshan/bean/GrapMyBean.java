package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by dongdong on 2017/9/23.
 */

public class GrapMyBean {

    /**
     * code : 1
     * data : [{"customerName":"zhangsan0","amount":1000,"phoneNo":"1332342342420","channel":null,"city":null,"msg":null,"grabResult":null,"grabTime":"2017-09-23 22:54:06"},{"customerName":"zhangsan1","amount":2000,"phoneNo":"1332342342421","channel":null,"city":null,"msg":null,"grabResult":null,"grabTime":"2017-09-23 22:54:06"},{"customerName":"zhangsan2","amount":3000,"phoneNo":"1332342342422","channel":null,"city":null,"msg":null,"grabResult":null,"grabTime":"2017-09-23 22:54:06"}]
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
         * customerName : zhangsan0
         * amount : 1000
         * phoneNo : 1332342342420
         * channel : null
         * city : null
         * msg : null
         * grabResult : null
         * grabTime : 2017-09-23 22:54:06
         */

        private String customerName;
        private long amount;
        private String phoneNo;
        private Object channel;
        private Object city;
        private Object msg;
        private Object grabResult;
        private String grabTime;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public Object getChannel() {
            return channel;
        }

        public void setChannel(Object channel) {
            this.channel = channel;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getMsg() {
            return msg;
        }

        public void setMsg(Object msg) {
            this.msg = msg;
        }

        public Object getGrabResult() {
            return grabResult;
        }

        public void setGrabResult(Object grabResult) {
            this.grabResult = grabResult;
        }

        public String getGrabTime() {
            return grabTime;
        }

        public void setGrabTime(String grabTime) {
            this.grabTime = grabTime;
        }
    }
}
