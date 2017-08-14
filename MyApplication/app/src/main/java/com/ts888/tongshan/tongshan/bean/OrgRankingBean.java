package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class OrgRankingBean {


    /**
     * code : 1
     * data : [{"orgName":"成都市天府国际营业部","orgCode":17,"managerName":"程瑶","orgRanking":1,"orgResults":1647000},{"orgName":"乌鲁木齐市第一营业部","orgCode":65,"managerName":"刘虎","orgRanking":2,"orgResults":719800},{"orgName":"呼和浩特市第一营业部","orgCode":60,"managerName":"乔海江","orgRanking":3,"orgResults":470400},{"orgName":"银川市第一营业部","orgCode":89,"managerName":"蔡振涛","orgRanking":4,"orgResults":433700},{"orgName":"广州市林和西路营业部","orgCode":16,"managerName":"鲁力","orgRanking":5,"orgResults":331400},{"orgName":"杭州市建国北路营业部","orgCode":57,"managerName":"叶莉","orgRanking":6,"orgResults":319000},{"orgName":"海口市第一营业部","orgCode":55,"managerName":"王鉴","orgRanking":7,"orgResults":247000},{"orgName":"郑州市第一营业部","orgCode":122,"managerName":"黄晓博","orgRanking":8,"orgResults":212500},{"orgName":"昆明市第一营业部","orgCode":72,"managerName":"陈明","orgRanking":9,"orgResults":196300},{"orgName":"合肥市芜湖路营业部","orgCode":14,"managerName":"刘双侠","orgRanking":10,"orgResults":184100}]
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
         * orgName : 成都市天府国际营业部
         * orgCode : 17
         * managerName : 程瑶
         * orgRanking : 1
         * orgResults : 1647000
         */

        private String orgName;
        private int orgCode;
        private String managerName;
        private int orgRanking;
        private int orgResults;

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(int orgCode) {
            this.orgCode = orgCode;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public int getOrgRanking() {
            return orgRanking;
        }

        public void setOrgRanking(int orgRanking) {
            this.orgRanking = orgRanking;
        }

        public int getOrgResults() {
            return orgResults;
        }

        public void setOrgResults(int orgResults) {
            this.orgResults = orgResults;
        }
    }
}
