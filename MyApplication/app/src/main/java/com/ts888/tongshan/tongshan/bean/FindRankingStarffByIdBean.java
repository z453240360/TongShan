package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class FindRankingStarffByIdBean {


    /**
     * code : 1
     * data : {"individualRankingDto":{"staffId":259,"staffName":"刘颖","individualRanking":3,"individualResults":150000},"groupRankingDto":{"groupName":"直销一组","groupCode":16,"groupLeaderName":"王露","groupRanking":30,"groupResults":50300},"orgRankingDto":{"orgName":"成都市天府国际营业部","orgCode":17,"managerName":"程瑶","orgRanking":1,"orgResults":1647000}}
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
         * individualRankingDto : {"staffId":259,"staffName":"刘颖","individualRanking":3,"individualResults":150000}
         * groupRankingDto : {"groupName":"直销一组","groupCode":16,"groupLeaderName":"王露","groupRanking":30,"groupResults":50300}
         * orgRankingDto : {"orgName":"成都市天府国际营业部","orgCode":17,"managerName":"程瑶","orgRanking":1,"orgResults":1647000}
         */

        private IndividualRankingDtoBean individualRankingDto;
        private GroupRankingDtoBean groupRankingDto;
        private OrgRankingDtoBean orgRankingDto;

        public IndividualRankingDtoBean getIndividualRankingDto() {
            return individualRankingDto;
        }

        public void setIndividualRankingDto(IndividualRankingDtoBean individualRankingDto) {
            this.individualRankingDto = individualRankingDto;
        }

        public GroupRankingDtoBean getGroupRankingDto() {
            return groupRankingDto;
        }

        public void setGroupRankingDto(GroupRankingDtoBean groupRankingDto) {
            this.groupRankingDto = groupRankingDto;
        }

        public OrgRankingDtoBean getOrgRankingDto() {
            return orgRankingDto;
        }

        public void setOrgRankingDto(OrgRankingDtoBean orgRankingDto) {
            this.orgRankingDto = orgRankingDto;
        }

        public static class IndividualRankingDtoBean {
            /**
             * staffId : 259
             * staffName : 刘颖
             * individualRanking : 3
             * individualResults : 150000
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

        public static class GroupRankingDtoBean {
            /**
             * groupName : 直销一组
             * groupCode : 16
             * groupLeaderName : 王露
             * groupRanking : 30
             * groupResults : 50300
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

        public static class OrgRankingDtoBean {
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
}
