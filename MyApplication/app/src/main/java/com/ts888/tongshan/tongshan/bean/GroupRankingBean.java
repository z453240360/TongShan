package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class GroupRankingBean {


    /**
     * code : 1
     * data : [{"groupName":"直销三组","groupCode":86,"groupLeaderName":"白茹雪2","groupRanking":1,"groupResults":470400},{"groupName":"直销四组","groupCode":127,"groupLeaderName":"马海艳","groupRanking":2,"groupResults":470400},{"groupName":"直销三组","groupCode":138,"groupLeaderName":"杨岚","groupRanking":3,"groupResults":234800},{"groupName":"直销4组","groupCode":139,"groupLeaderName":"杨嘉轩","groupRanking":4,"groupResults":198900},{"groupName":"直销二组","groupCode":51,"groupLeaderName":"竺益鹏","groupRanking":5,"groupResults":196300},{"groupName":"直销一组","groupCode":88,"groupLeaderName":"赵亚军","groupRanking":6,"groupResults":196300},{"groupName":"直销四组","groupCode":44,"groupLeaderName":"王佳佳","groupRanking":7,"groupResults":184100},{"groupName":"直销三组","groupCode":87,"groupLeaderName":"张楠","groupRanking":8,"groupResults":135000},{"groupName":"销售4组","groupCode":4,"groupLeaderName":"张贺","groupRanking":9,"groupResults":122700},{"groupName":"直销三组","groupCode":36,"groupLeaderName":"王蔚","groupRanking":10,"groupResults":114700}]
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
         * groupCode : 86
         * groupLeaderName : 白茹雪2
         * groupRanking : 1
         * groupResults : 470400
         */

        private String groupName;
        private int groupCode;
        private String groupLeaderName;
        private int groupRanking;
        private int groupResults;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getGroupCode() {
            return groupCode;
        }

        public void setGroupCode(int groupCode) {
            this.groupCode = groupCode;
        }

        public String getGroupLeaderName() {
            return groupLeaderName;
        }

        public void setGroupLeaderName(String groupLeaderName) {
            this.groupLeaderName = groupLeaderName;
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
