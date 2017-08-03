package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/3.
 */

public class UserBaseInfoBean {

    /**
     * code : 1
     * data : {"id":72,"userCode":"TS_20170614103419437225140","userName":"刘丽华","idCard":"360430198809271124","sex":0,"degree":"231","degreeName":"硕士及其以上","permanentAddress":null,"marriage":"177","marriageName":"未婚","residenceCondition":"224","residenceConditionName":"租用","residenceProvince":"310000","residenceProvinceName":"上海市","residenceCity":"310100","residenceCityName":"市辖区","residenceRegion":"310109","residenceRegionName":"虹口区","residenceAddress":"测试居住地址","jobCompanyName":"通善金融","jobCompanyCondition":"163","jobCompanyConditionName":"合资企业","jobCompanyProvince":"310000","jobCompanyProvinceName":"上海市","jobCompanyCity":"310100","jobCompanyCityName":"市辖区","jobCompanyRegion":"310107","jobCompanyRegionName":"普陀区","jobCompanyAddress":"测试单位地址","jobCompanyLatitude":null,"jobCompanyPhone":"021-12345678","entryDate":"2014-06-15","currJobSeniority":"294","currJobSeniorityName":"一般正式员工","monthSalary":"TSAppBet5sto8s","monthSalaryName":"5000～7999"}
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
         * id : 72
         * userCode : TS_20170614103419437225140
         * userName : 刘丽华
         * idCard : 360430198809271124
         * sex : 0
         * degree : 231
         * degreeName : 硕士及其以上
         * permanentAddress : null
         * marriage : 177
         * marriageName : 未婚
         * residenceCondition : 224
         * residenceConditionName : 租用
         * residenceProvince : 310000
         * residenceProvinceName : 上海市
         * residenceCity : 310100
         * residenceCityName : 市辖区
         * residenceRegion : 310109
         * residenceRegionName : 虹口区
         * residenceAddress : 测试居住地址
         * jobCompanyName : 通善金融
         * jobCompanyCondition : 163
         * jobCompanyConditionName : 合资企业
         * jobCompanyProvince : 310000
         * jobCompanyProvinceName : 上海市
         * jobCompanyCity : 310100
         * jobCompanyCityName : 市辖区
         * jobCompanyRegion : 310107
         * jobCompanyRegionName : 普陀区
         * jobCompanyAddress : 测试单位地址
         * jobCompanyLatitude : null
         * jobCompanyPhone : 021-12345678
         * entryDate : 2014-06-15
         * currJobSeniority : 294
         * currJobSeniorityName : 一般正式员工
         * monthSalary : TSAppBet5sto8s
         * monthSalaryName : 5000～7999
         */

        private int id;
        private String userCode;
        private String userName;
        private String idCard;
        private int sex;
        private String degree;
        private String degreeName;
        private Object permanentAddress;
        private String marriage;
        private String marriageName;
        private String residenceCondition;
        private String residenceConditionName;
        private String residenceProvince;
        private String residenceProvinceName;
        private String residenceCity;
        private String residenceCityName;
        private String residenceRegion;
        private String residenceRegionName;
        private String residenceAddress;
        private String jobCompanyName;
        private String jobCompanyCondition;
        private String jobCompanyConditionName;
        private String jobCompanyProvince;
        private String jobCompanyProvinceName;
        private String jobCompanyCity;
        private String jobCompanyCityName;
        private String jobCompanyRegion;
        private String jobCompanyRegionName;
        private String jobCompanyAddress;
        private Object jobCompanyLatitude;
        private String jobCompanyPhone;
        private String entryDate;
        private String currJobSeniority;
        private String currJobSeniorityName;
        private String monthSalary;
        private String monthSalaryName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getDegreeName() {
            return degreeName;
        }

        public void setDegreeName(String degreeName) {
            this.degreeName = degreeName;
        }

        public Object getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(Object permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        public String getMarriage() {
            return marriage;
        }

        public void setMarriage(String marriage) {
            this.marriage = marriage;
        }

        public String getMarriageName() {
            return marriageName;
        }

        public void setMarriageName(String marriageName) {
            this.marriageName = marriageName;
        }

        public String getResidenceCondition() {
            return residenceCondition;
        }

        public void setResidenceCondition(String residenceCondition) {
            this.residenceCondition = residenceCondition;
        }

        public String getResidenceConditionName() {
            return residenceConditionName;
        }

        public void setResidenceConditionName(String residenceConditionName) {
            this.residenceConditionName = residenceConditionName;
        }

        public String getResidenceProvince() {
            return residenceProvince;
        }

        public void setResidenceProvince(String residenceProvince) {
            this.residenceProvince = residenceProvince;
        }

        public String getResidenceProvinceName() {
            return residenceProvinceName;
        }

        public void setResidenceProvinceName(String residenceProvinceName) {
            this.residenceProvinceName = residenceProvinceName;
        }

        public String getResidenceCity() {
            return residenceCity;
        }

        public void setResidenceCity(String residenceCity) {
            this.residenceCity = residenceCity;
        }

        public String getResidenceCityName() {
            return residenceCityName;
        }

        public void setResidenceCityName(String residenceCityName) {
            this.residenceCityName = residenceCityName;
        }

        public String getResidenceRegion() {
            return residenceRegion;
        }

        public void setResidenceRegion(String residenceRegion) {
            this.residenceRegion = residenceRegion;
        }

        public String getResidenceRegionName() {
            return residenceRegionName;
        }

        public void setResidenceRegionName(String residenceRegionName) {
            this.residenceRegionName = residenceRegionName;
        }

        public String getResidenceAddress() {
            return residenceAddress;
        }

        public void setResidenceAddress(String residenceAddress) {
            this.residenceAddress = residenceAddress;
        }

        public String getJobCompanyName() {
            return jobCompanyName;
        }

        public void setJobCompanyName(String jobCompanyName) {
            this.jobCompanyName = jobCompanyName;
        }

        public String getJobCompanyCondition() {
            return jobCompanyCondition;
        }

        public void setJobCompanyCondition(String jobCompanyCondition) {
            this.jobCompanyCondition = jobCompanyCondition;
        }

        public String getJobCompanyConditionName() {
            return jobCompanyConditionName;
        }

        public void setJobCompanyConditionName(String jobCompanyConditionName) {
            this.jobCompanyConditionName = jobCompanyConditionName;
        }

        public String getJobCompanyProvince() {
            return jobCompanyProvince;
        }

        public void setJobCompanyProvince(String jobCompanyProvince) {
            this.jobCompanyProvince = jobCompanyProvince;
        }

        public String getJobCompanyProvinceName() {
            return jobCompanyProvinceName;
        }

        public void setJobCompanyProvinceName(String jobCompanyProvinceName) {
            this.jobCompanyProvinceName = jobCompanyProvinceName;
        }

        public String getJobCompanyCity() {
            return jobCompanyCity;
        }

        public void setJobCompanyCity(String jobCompanyCity) {
            this.jobCompanyCity = jobCompanyCity;
        }

        public String getJobCompanyCityName() {
            return jobCompanyCityName;
        }

        public void setJobCompanyCityName(String jobCompanyCityName) {
            this.jobCompanyCityName = jobCompanyCityName;
        }

        public String getJobCompanyRegion() {
            return jobCompanyRegion;
        }

        public void setJobCompanyRegion(String jobCompanyRegion) {
            this.jobCompanyRegion = jobCompanyRegion;
        }

        public String getJobCompanyRegionName() {
            return jobCompanyRegionName;
        }

        public void setJobCompanyRegionName(String jobCompanyRegionName) {
            this.jobCompanyRegionName = jobCompanyRegionName;
        }

        public String getJobCompanyAddress() {
            return jobCompanyAddress;
        }

        public void setJobCompanyAddress(String jobCompanyAddress) {
            this.jobCompanyAddress = jobCompanyAddress;
        }

        public Object getJobCompanyLatitude() {
            return jobCompanyLatitude;
        }

        public void setJobCompanyLatitude(Object jobCompanyLatitude) {
            this.jobCompanyLatitude = jobCompanyLatitude;
        }

        public String getJobCompanyPhone() {
            return jobCompanyPhone;
        }

        public void setJobCompanyPhone(String jobCompanyPhone) {
            this.jobCompanyPhone = jobCompanyPhone;
        }

        public String getEntryDate() {
            return entryDate;
        }

        public void setEntryDate(String entryDate) {
            this.entryDate = entryDate;
        }

        public String getCurrJobSeniority() {
            return currJobSeniority;
        }

        public void setCurrJobSeniority(String currJobSeniority) {
            this.currJobSeniority = currJobSeniority;
        }

        public String getCurrJobSeniorityName() {
            return currJobSeniorityName;
        }

        public void setCurrJobSeniorityName(String currJobSeniorityName) {
            this.currJobSeniorityName = currJobSeniorityName;
        }

        public String getMonthSalary() {
            return monthSalary;
        }

        public void setMonthSalary(String monthSalary) {
            this.monthSalary = monthSalary;
        }

        public String getMonthSalaryName() {
            return monthSalaryName;
        }

        public void setMonthSalaryName(String monthSalaryName) {
            this.monthSalaryName = monthSalaryName;
        }
    }
}
