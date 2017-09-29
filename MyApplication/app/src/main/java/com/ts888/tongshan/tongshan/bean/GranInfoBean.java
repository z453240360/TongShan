package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/9/28.
 */

public class GranInfoBean {

    /**
     * code : 1
     * data : {"customerName":"test_9","amount":23456,"phoneNo":null,"channel":null,"city":"上海","msg":null,"grabResult":true,"grabTime":null}
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
         * customerName : test_9
         * amount : 23456
         * phoneNo : null
         * channel : null
         * city : 上海
         * msg : null
         * grabResult : true
         * grabTime : null
         */

        private String customerName;
        private int amount;
        private String phoneNo;
        private Object channel;
        private String city;
        private Object msg;
        private boolean grabResult;
        private Object grabTime;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getMsg() {
            return msg;
        }

        public void setMsg(Object msg) {
            this.msg = msg;
        }

        public boolean isGrabResult() {
            return grabResult;
        }

        public void setGrabResult(boolean grabResult) {
            this.grabResult = grabResult;
        }

        public Object getGrabTime() {
            return grabTime;
        }

        public void setGrabTime(Object grabTime) {
            this.grabTime = grabTime;
        }
    }
}
