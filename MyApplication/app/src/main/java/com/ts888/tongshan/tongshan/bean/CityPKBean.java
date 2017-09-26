package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/9/25.
 */

public class CityPKBean {

    /**
     * code : 1
     * data : {"challengeCityName":"14","acceptCityName":"芝加哥市","startTime":"2017-08-26","endTime":"2017-09-25","surplusTime":"12","challengeAmount":6780,"acceptAmount":5679,"distanceAmount":1101,"challengeDisplayNumber":67,"acceptDisplayNumber":56}
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
         * challengeCityName : 14
         * acceptCityName : 芝加哥市
         * startTime : 2017-08-26
         * endTime : 2017-09-25
         * surplusTime : 12
         * challengeAmount : 6780
         * acceptAmount : 5679
         * distanceAmount : 1101
         * challengeDisplayNumber : 67.0
         * acceptDisplayNumber : 56.0
         */

        private String challengeCityName;
        private String acceptCityName;
        private String startTime;
        private String endTime;
        private String surplusTime;
        private double challengeAmount;
        private double acceptAmount;
        private double distanceAmount;
        private double challengeDisplayNumber;
        private double acceptDisplayNumber;

        public String getChallengeCityName() {
            return challengeCityName;
        }

        public void setChallengeCityName(String challengeCityName) {
            this.challengeCityName = challengeCityName;
        }

        public String getAcceptCityName() {
            return acceptCityName;
        }

        public void setAcceptCityName(String acceptCityName) {
            this.acceptCityName = acceptCityName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getSurplusTime() {
            return surplusTime;
        }

        public void setSurplusTime(String surplusTime) {
            this.surplusTime = surplusTime;
        }

        public double getChallengeAmount() {
            return challengeAmount;
        }

        public void setChallengeAmount(double challengeAmount) {
            this.challengeAmount = challengeAmount;
        }

        public double getAcceptAmount() {
            return acceptAmount;
        }

        public void setAcceptAmount(double acceptAmount) {
            this.acceptAmount = acceptAmount;
        }

        public double getDistanceAmount() {
            return distanceAmount;
        }

        public void setDistanceAmount(double distanceAmount) {
            this.distanceAmount = distanceAmount;
        }

        public double getChallengeDisplayNumber() {
            return challengeDisplayNumber;
        }

        public void setChallengeDisplayNumber(double challengeDisplayNumber) {
            this.challengeDisplayNumber = challengeDisplayNumber;
        }

        public double getAcceptDisplayNumber() {
            return acceptDisplayNumber;
        }

        public void setAcceptDisplayNumber(double acceptDisplayNumber) {
            this.acceptDisplayNumber = acceptDisplayNumber;
        }
    }
}
