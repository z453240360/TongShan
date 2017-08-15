package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class IndividualRanking {


    /**
     * code : 1
     * data : [{"staffName":"黄晓艳","orgName":"海口市第一营业部","individualRanking":1,"individualResults":332800},{"staffName":"陈雅竹","orgName":"海口市第一营业部","individualRanking":2,"individualResults":319000},{"staffName":"林燕妮","orgName":"厦门市第一营业部","individualRanking":3,"individualResults":269200},{"staffName":"汪修文","orgName":"上海市福州路营业部","individualRanking":4,"individualResults":245400},{"staffName":"朱永芳","orgName":"合肥市芜湖路营业部","individualRanking":5,"individualResults":240000},{"staffName":"陈哲望","orgName":"杭州市建国北路营业部","individualRanking":6,"individualResults":239800},{"staffName":"马梓航","orgName":"乌鲁木齐市第一营业部","individualRanking":7,"individualResults":235200},{"staffName":"赵健","orgName":"上海市福州路营业部","individualRanking":8,"individualResults":228000},{"staffName":"陈元龙","orgName":"海口市第一营业部","individualRanking":9,"individualResults":220900},{"staffName":"吴勤雪","orgName":"合肥市芜湖路营业部","individualRanking":10,"individualResults":209700}]
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
         * staffName : 黄晓艳
         * orgName : 海口市第一营业部
         * individualRanking : 1
         * individualResults : 332800
         */

        private String staffName;
        private String orgName;
        private int individualRanking;
        private int individualResults;

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getIndividualRanking() {
            return individualRanking;
        }

        public void setIndividualRanking(int individualRanking) {
            this.individualRanking = individualRanking;
        }

        public int getIndividualResults() {
            return individualResults;
        }

        public void setIndividualResults(int individualResults) {
            this.individualResults = individualResults;
        }
    }
}
