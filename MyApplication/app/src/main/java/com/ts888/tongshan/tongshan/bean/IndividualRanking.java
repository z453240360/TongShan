package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class IndividualRanking {

    /**
     * code : 1
     * data : [{"userName":"销售名称1","groupName":"团队名称11","groupCode":"group11","groupLeaderName":"团队长名称11","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩10 万","groupResults":"团队业绩业绩50万","orgResults":"营业部业绩500万"},{"userName":"销售名称2","groupName":"团队名称12","groupCode":"group12","groupLeaderName":"团队长名称12","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩20 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩500万"},{"userName":"销售名称3","groupName":"团队名称11","groupCode":"group11","groupLeaderName":"团队长名称11","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩30 万","groupResults":"团队业绩业绩50万","orgResults":"营业部业绩500万"},{"userName":"销售名称4","groupName":"团队名称12","groupCode":"group12","groupLeaderName":"团队长名称12","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩40 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩500万"},{"userName":"销售名称5","groupName":"团队名称11","groupCode":"group11","groupLeaderName":"团队长名称11","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩50 万","groupResults":"团队业绩业绩50万","orgResults":"营业部业绩500万"},{"userName":"销售名称6","groupName":"团队名称12","groupCode":"group12","groupLeaderName":"团队长名称12","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩60 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩500万"},{"userName":"销售名称7","groupName":"团队名称11","groupCode":"group11","groupLeaderName":"团队长名称11","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩70 万","groupResults":"团队业绩业绩50万","orgResults":"营业部业绩500万"},{"userName":"销售名称8","groupName":"团队名称12","groupCode":"group12","groupLeaderName":"团队长名称12","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩80 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩500万"},{"userName":"销售名称9","groupName":"团队名称11","groupCode":"group11","groupLeaderName":"团队长名称11","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩90 万","groupResults":"团队业绩业绩50万","orgResults":"营业部业绩500万"},{"userName":"销售名称10","groupName":"团队名称12","groupCode":"group12","groupLeaderName":"团队长名称12","orgName":"部门名称11","orgCode":"org11","managerName":"营业部经理名称11","individualResults":"个人业绩100 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩500万"},{"userName":"销售名称11","groupName":null,"groupCode":null,"groupLeaderName":null,"orgName":null,"orgCode":null,"managerName":null,"individualResults":"个人业绩110 万","groupResults":null,"orgResults":null},{"userName":"销售名称12","groupName":"团队名称22","groupCode":"group22","groupLeaderName":"团队长名称22","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩120 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩600万"},{"userName":"销售名称13","groupName":"团队名称21","groupCode":"group21","groupLeaderName":"团队长名称21","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩130 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩600万"},{"userName":"销售名称14","groupName":"团队名称22","groupCode":"group22","groupLeaderName":"团队长名称22","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩140 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩600万"},{"userName":"销售名称15","groupName":"团队名称21","groupCode":"group21","groupLeaderName":"团队长名称21","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩150 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩600万"},{"userName":"销售名称16","groupName":"团队名称22","groupCode":"group22","groupLeaderName":"团队长名称22","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩160 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩600万"},{"userName":"销售名称17","groupName":"团队名称21","groupCode":"group21","groupLeaderName":"团队长名称21","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩170 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩600万"},{"userName":"销售名称18","groupName":"团队名称22","groupCode":"group22","groupLeaderName":"团队长名称22","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩180 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩600万"},{"userName":"销售名称19","groupName":"团队名称21","groupCode":"group21","groupLeaderName":"团队长名称21","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩190 万","groupResults":"团队业绩业绩60万","orgResults":"营业部业绩600万"},{"userName":"销售名称20","groupName":"团队名称22","groupCode":"group22","groupLeaderName":"团队长名称22","orgName":"部门名称21","orgCode":"org21","managerName":"营业部经理名称21","individualResults":"个人业绩200 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩600万"},{"userName":"销售名称21","groupName":null,"groupCode":null,"groupLeaderName":null,"orgName":null,"orgCode":null,"managerName":null,"individualResults":"个人业绩210 万","groupResults":null,"orgResults":null},{"userName":"销售名称22","groupName":"团队名称32","groupCode":"group32","groupLeaderName":"团队长名称32","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩220 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩700万"},{"userName":"销售名称23","groupName":"团队名称31","groupCode":"group31","groupLeaderName":"团队长名称31","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩230 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩700万"},{"userName":"销售名称24","groupName":"团队名称32","groupCode":"group32","groupLeaderName":"团队长名称32","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩240 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩700万"},{"userName":"销售名称25","groupName":"团队名称31","groupCode":"group31","groupLeaderName":"团队长名称31","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩250 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩700万"},{"userName":"销售名称26","groupName":"团队名称32","groupCode":"group32","groupLeaderName":"团队长名称32","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩260 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩700万"},{"userName":"销售名称27","groupName":"团队名称31","groupCode":"group31","groupLeaderName":"团队长名称31","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩270 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩700万"},{"userName":"销售名称28","groupName":"团队名称32","groupCode":"group32","groupLeaderName":"团队长名称32","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩280 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩700万"},{"userName":"销售名称29","groupName":"团队名称31","groupCode":"group31","groupLeaderName":"团队长名称31","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩290 万","groupResults":"团队业绩业绩70万","orgResults":"营业部业绩700万"},{"userName":"销售名称30","groupName":"团队名称32","groupCode":"group32","groupLeaderName":"团队长名称32","orgName":"部门名称31","orgCode":"org31","managerName":"营业部经理名称31","individualResults":"个人业绩300 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩700万"},{"userName":"销售名称31","groupName":null,"groupCode":null,"groupLeaderName":null,"orgName":null,"orgCode":null,"managerName":null,"individualResults":"个人业绩310 万","groupResults":null,"orgResults":null},{"userName":"销售名称32","groupName":"团队名称42","groupCode":"group42","groupLeaderName":"团队长名称42","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩320 万","groupResults":"团队业绩业绩90万","orgResults":"营业部业绩800万"},{"userName":"销售名称33","groupName":"团队名称41","groupCode":"group41","groupLeaderName":"团队长名称41","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩330 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩800万"},{"userName":"销售名称34","groupName":"团队名称42","groupCode":"group42","groupLeaderName":"团队长名称42","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩340 万","groupResults":"团队业绩业绩90万","orgResults":"营业部业绩800万"},{"userName":"销售名称35","groupName":"团队名称41","groupCode":"group41","groupLeaderName":"团队长名称41","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩350 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩800万"},{"userName":"销售名称36","groupName":"团队名称42","groupCode":"group42","groupLeaderName":"团队长名称42","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩360 万","groupResults":"团队业绩业绩90万","orgResults":"营业部业绩800万"},{"userName":"销售名称37","groupName":"团队名称41","groupCode":"group41","groupLeaderName":"团队长名称41","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩370 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩800万"},{"userName":"销售名称38","groupName":"团队名称42","groupCode":"group42","groupLeaderName":"团队长名称42","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩380 万","groupResults":"团队业绩业绩90万","orgResults":"营业部业绩800万"},{"userName":"销售名称39","groupName":"团队名称41","groupCode":"group41","groupLeaderName":"团队长名称41","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩390 万","groupResults":"团队业绩业绩80万","orgResults":"营业部业绩800万"},{"userName":"销售名称40","groupName":"团队名称42","groupCode":"group42","groupLeaderName":"团队长名称42","orgName":"部门名称41","orgCode":"org41","managerName":"营业部经理名称41","individualResults":"个人业绩400 万","groupResults":"团队业绩业绩90万","orgResults":"营业部业绩800万"}]
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
         * userName : 销售名称1
         * groupName : 团队名称11
         * groupCode : group11
         * groupLeaderName : 团队长名称11
         * orgName : 部门名称11
         * orgCode : org11
         * managerName : 营业部经理名称11
         * individualResults : 个人业绩10 万
         * groupResults : 团队业绩业绩50万
         * orgResults : 营业部业绩500万
         */

        private String userName;
        private String groupName;
        private String groupCode;
        private String groupLeaderName;
        private String orgName;
        private String orgCode;
        private String managerName;
        private String individualResults;
        private String groupResults;
        private String orgResults;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupCode() {
            return groupCode;
        }

        public void setGroupCode(String groupCode) {
            this.groupCode = groupCode;
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

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public String getIndividualResults() {
            return individualResults;
        }

        public void setIndividualResults(String individualResults) {
            this.individualResults = individualResults;
        }

        public String getGroupResults() {
            return groupResults;
        }

        public void setGroupResults(String groupResults) {
            this.groupResults = groupResults;
        }

        public String getOrgResults() {
            return orgResults;
        }

        public void setOrgResults(String orgResults) {
            this.orgResults = orgResults;
        }
    }
}
