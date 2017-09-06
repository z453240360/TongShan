package com.ts888.tongshan.tongshan.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class Jinjian3_bean {

    /**
     * code : 1
     * data : [{"ret":"","applyCode":"PL2017082415271953697365",
     * "applyDate":"2017-08-24",
     * "name":"杨林杰",
     * "idCardNo":"3101************0856",
     * "approvalAmount":"20000",
     * "productRate":"Ebaotong2.38",
     * "taskNode":"扣服务费中","status":"","remark":"","ver":"1.0","loanLife":"24"}]
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
         * ret :
         * applyCode : PL2017082415271953697365
         * applyDate : 2017-08-24
         * name : 杨林杰
         * idCardNo : 3101************0856
         * approvalAmount : 20000
         * productRate : Ebaotong2.38
         * taskNode : 扣服务费中
         * status :
         * remark :
         * ver : 1.0
         * loanLife : 24
         */

        private String ret;
        private String applyCode;
        private String applyDate;
        private String name;
        private String idCardNo;
        private String approvalAmount;
        private String productRate;
        private String taskNode;
        private String status;
        private String remark;
        private String ver;
        private String loanLife;

        public String getRet() {
            return ret;
        }

        public void setRet(String ret) {
            this.ret = ret;
        }

        public String getApplyCode() {
            return applyCode;
        }

        public void setApplyCode(String applyCode) {
            this.applyCode = applyCode;
        }

        public String getApplyDate() {
            return applyDate;
        }

        public void setApplyDate(String applyDate) {
            this.applyDate = applyDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public String getApprovalAmount() {
            return approvalAmount;
        }

        public void setApprovalAmount(String approvalAmount) {
            this.approvalAmount = approvalAmount;
        }

        public String getProductRate() {
            return productRate;
        }

        public void setProductRate(String productRate) {
            this.productRate = productRate;
        }

        public String getTaskNode() {
            return taskNode;
        }

        public void setTaskNode(String taskNode) {
            this.taskNode = taskNode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public String getLoanLife() {
            return loanLife;
        }

        public void setLoanLife(String loanLife) {
            this.loanLife = loanLife;
        }
    }
}
