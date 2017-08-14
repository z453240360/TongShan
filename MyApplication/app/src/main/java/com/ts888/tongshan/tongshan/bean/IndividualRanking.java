package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class IndividualRanking {


    /**
     * code : 1
     * data : [{"staffId":4116,"staffName":"摆海军","individualRanking":1,"individualResults":470400},{"staffId":3853,"staffName":"昝玉龙","individualRanking":2,"individualResults":470400},{"staffId":259,"staffName":"刘颖","individualRanking":3,"individualResults":150000},{"staffId":4078,"staffName":"王海芸","individualRanking":4,"individualResults":144800},{"staffId":4137,"staffName":"房选达","individualRanking":5,"individualResults":122700},{"staffId":3124,"staffName":"鲁大清","individualRanking":6,"individualResults":122700},{"staffId":3769,"staffName":"汪国扬","individualRanking":7,"individualResults":122700},{"staffId":3653,"staffName":"何荣","individualRanking":8,"individualResults":114700},{"staffId":3969,"staffName":"何虹兵","individualRanking":9,"individualResults":98100},{"staffId":3194,"staffName":"周莉萍","individualRanking":10,"individualResults":87500}]
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
         * staffId : 4116
         * staffName : 摆海军
         * individualRanking : 1
         * individualResults : 470400
         */

        private int staffId;
        private String staffName;
        private int individualRanking;
        private int individualResults;

        public int getStaffId() {
            return staffId;
        }

        public void setStaffId(int staffId) {
            this.staffId = staffId;
        }

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
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
