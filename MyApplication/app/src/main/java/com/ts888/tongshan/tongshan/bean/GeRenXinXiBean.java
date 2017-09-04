package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/9/4.
 */

public class GeRenXinXiBean {

    /**
     * code : 1
     * data : {"userCode":"SA_20170829142042038289425","phoneNo":"18616851636","staffName":"刘丽华","groupName":null,"orgName":"上海市福州路营业部"}
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
         * userCode : SA_20170829142042038289425
         * phoneNo : 18616851636
         * staffName : 刘丽华
         * groupName : null
         * orgName : 上海市福州路营业部
         */

        private String userCode;
        private String phoneNo;
        private String staffName;
        private Object groupName;
        private String orgName;

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
        }

        public Object getGroupName() {
            return groupName;
        }

        public void setGroupName(Object groupName) {
            this.groupName = groupName;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }
    }
}
