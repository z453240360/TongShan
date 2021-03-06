package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class FindRankingStarffByIdBean {



    /**
     * code : 1
     * data : {"individualRankingDto":{"staffName":"吴茜","individualRanking":8,"individualResults":99999},"groupRankingDto":{"groupName":"直销五组","groupLeaderName":"刘小芳","groupRanking":19,"groupResults":73600},"orgRankingDto":{"orgName":"惠州市第一营业部","managerName":"姜丽军","orgRanking":14,"orgResults":73600}}
     * massage :
     */

    private String code;
    private DataBean data;
    private String message;

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

    public String getMassage() {
        return message;
    }

    public void setMassage(String message) {
        this.message = message;
    }

    public static class DataBean {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DataBean)) return false;

            DataBean dataBean = (DataBean) o;

            if (!getIndividualRankingDto().equals(dataBean.getIndividualRankingDto())) return false;
            if (!getGroupRankingDto().equals(dataBean.getGroupRankingDto())) return false;
            return getOrgRankingDto().equals(dataBean.getOrgRankingDto());

        }

        @Override
        public int hashCode() {
            int result = getIndividualRankingDto().hashCode();
            result = 31 * result + getGroupRankingDto().hashCode();
            result = 31 * result + getOrgRankingDto().hashCode();
            return result;
        }

        /**
         * individualRankingDto : {"staffName":"吴茜","individualRanking":8,"individualResults":99999}
         * groupRankingDto : {"groupName":"直销五组","groupLeaderName":"刘小芳","groupRanking":19,"groupResults":73600}
         * orgRankingDto : {"orgName":"惠州市第一营业部","managerName":"姜丽军","orgRanking":14,"orgResults":73600}
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
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof IndividualRankingDtoBean)) return false;

                IndividualRankingDtoBean that = (IndividualRankingDtoBean) o;

                if (getIndividualRanking() != that.getIndividualRanking()) return false;
                if (getIndividualResults() != that.getIndividualResults()) return false;
                return getStaffName().equals(that.getStaffName());

            }

            @Override
            public int hashCode() {
                int result = getStaffName().hashCode();
                result = 31 * result + getIndividualRanking();
                result = 31 * result + getIndividualResults();
                return result;
            }

            /**
             * staffName : 吴茜
             * individualRanking : 8
             * individualResults : 99999
             */

            private String staffName;
            private int individualRanking;
            private int individualResults;

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
             * groupName : 直销五组
             * groupLeaderName : 刘小芳
             * groupRanking : 19
             * groupResults : 73600
             */

            private String groupName;
            private String groupLeaderName;
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
             * orgName : 惠州市第一营业部
             * managerName : 姜丽军
             * orgRanking : 14
             * orgResults : 73600
             */

            private String orgName;
            private String managerName;
            private int orgRanking;
            private int orgResults;

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
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
