package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class GroupRankingBean {


    /**
     * code : 1
     * data : [{"groupName":"直销三组","groupLeaderName":"陈柳任","orgName":"海口市第一营业部","groupRanking":1,"groupResults":1031100},{"groupName":"销售1组","groupLeaderName":"黄丽君","orgName":"上海市福州路营业部","groupRanking":2,"groupResults":751700},{"groupName":"直销四组","groupLeaderName":"马海艳","orgName":"乌鲁木齐市第一营业部","groupRanking":3,"groupResults":458900},{"groupName":"直销三组","groupLeaderName":"张楠","orgName":"乌鲁木齐市第一营业部","groupRanking":4,"groupResults":421100},{"groupName":"直销2组","groupLeaderName":"樊真真","orgName":"郑州市第一营业部","groupRanking":5,"groupResults":379700},{"groupName":"直销三组","groupLeaderName":"张哲","orgName":"合肥市芜湖路营业部","groupRanking":6,"groupResults":371900},{"groupName":"直销二组","groupLeaderName":"竺益鹏","orgName":"杭州市建国北路营业部","groupRanking":7,"groupResults":368200},{"groupName":"直销二组","groupLeaderName":"李梅","orgName":"乌鲁木齐市第一营业部","groupRanking":8,"groupResults":365600},{"groupName":"销售5组","groupLeaderName":"王艺菲","orgName":"上海市福州路营业部","groupRanking":9,"groupResults":346400},{"groupName":"直销一组","groupLeaderName":"郭阳","orgName":"广州市林和西路营业部","groupRanking":10,"groupResults":302300}]
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
         * groupName : 直销三组
         * groupLeaderName : 陈柳任
         * orgName : 海口市第一营业部
         * groupRanking : 1
         * groupResults : 1031100
         */

        private String groupName;
        private String groupLeaderName;
        private String orgName;
        private int groupRanking;
        private int groupResults;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupLeaderName() {
            return groupLeaderName;
        }

        public void setGroupLeaderName(String groupLeaderName) {
            this.groupLeaderName = groupLeaderName;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getGroupRanking() {
            return groupRanking;
        }

        public void setGroupRanking(int groupRanking) {
            this.groupRanking = groupRanking;
        }

        public int getGroupResults() {
            return groupResults;
        }

        public void setGroupResults(int groupResults) {
            this.groupResults = groupResults;
        }
    }
}
