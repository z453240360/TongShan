package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class GroupPKBean {

    /**
     * code : 1
     * data : [{"belongCity":"14","belongOrgName":"14第1营业部","teamName":"001组","leaderName":"张1花","startTime":"2017-08-26","endTime":"2017-09-25","surplusTime":"12","results":100,"displayNumber":10},{"belongCity":"14","belongOrgName":"14第2营业部","teamName":"002组","leaderName":"张2花","startTime":"2017-08-26","endTime":"2017-09-25","surplusTime":"12","results":200,"displayNumber":20},{"belongCity":"14","belongOrgName":"14第3营业部","teamName":"003组","leaderName":"张3花","startTime":"2017-08-26","endTime":"2017-09-25","surplusTime":"12","results":300,"displayNumber":30},{"belongCity":"14","belongOrgName":"14第4营业部","teamName":"004组","leaderName":"张4花","startTime":"2017-08-26","endTime":"2017-09-25","surplusTime":"12","results":400,"displayNumber":40}]
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
         * belongCity : 14
         * belongOrgName : 14第1营业部
         * teamName : 001组
         * leaderName : 张1花
         * startTime : 2017-08-26
         * endTime : 2017-09-25
         * surplusTime : 12
         * results : 100
         * displayNumber : 10.0
         */

        private String belongCity;
        private String belongOrgName;
        private String teamName;
        private String leaderName;
        private String startTime;
        private String endTime;
        private String surplusTime;
        private int results;
        private double displayNumber;

        public String getBelongCity() {
            return belongCity;
        }

        public void setBelongCity(String belongCity) {
            this.belongCity = belongCity;
        }

        public String getBelongOrgName() {
            return belongOrgName;
        }

        public void setBelongOrgName(String belongOrgName) {
            this.belongOrgName = belongOrgName;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
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

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public double getDisplayNumber() {
            return displayNumber;
        }

        public void setDisplayNumber(double displayNumber) {
            this.displayNumber = displayNumber;
        }
    }
}
