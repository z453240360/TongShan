package com.ts888.tongshan.tongshan.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class Jinjian2_Bean {

    /**
     * code : 1
     * data : [{"ret":"","applyCode":"PL150423248093605100000036","applyDate":"2017-09-01","name":"贷道二","idCardNo":"4101************2174","approvalAmount":"","productRate":"","taskNode":"01","status":"","remark":"","ver":"1.0","loanLife":null}]
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

    public static class DataBean implements Parcelable {
        /**
         * ret :
         * applyCode : PL150423248093605100000036
         * applyDate : 2017-09-01
         * name : 贷道二
         * idCardNo : 4101************2174
         * approvalAmount :
         * productRate :
         * taskNode : 01
         * status :
         * remark :
         * ver : 1.0
         * loanLife : null
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

        protected DataBean(Parcel in) {
            ret = in.readString();
            applyCode = in.readString();
            applyDate = in.readString();
            name = in.readString();
            idCardNo = in.readString();
            approvalAmount = in.readString();
            productRate = in.readString();
            taskNode = in.readString();
            status = in.readString();
            remark = in.readString();
            ver = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(ret);
            parcel.writeString(applyCode);
            parcel.writeString(applyDate);
            parcel.writeString(name);
            parcel.writeString(idCardNo);
            parcel.writeString(approvalAmount);
            parcel.writeString(productRate);
            parcel.writeString(taskNode);
            parcel.writeString(status);
            parcel.writeString(remark);
            parcel.writeString(ver);
        }
    }
}
