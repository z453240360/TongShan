package com.ts888.tongshan.tongshan.bean;

/**
 * Created by Administrator on 2017/8/8.
 */

public class UpDateFromNetBean {

    /**
     * code : 1
     * data : {"needUpdate":1,"recentVersion":"1.1.1","forceUpdate":0,"description":"备注test","md5":"d41d8cd98f00b204e9800998ecf8427e","url":"https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/apk/app-333-release.apk"}
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
         * needUpdate : 1
         * recentVersion : 1.1.1
         * forceUpdate : 0
         * description : 备注test
         * md5 : d41d8cd98f00b204e9800998ecf8427e
         * url : https://s3.cn-north-1.amazonaws.com.cn/appsales-dev.tsjinrong.cn/apk/app-333-release.apk
         */

        private int needUpdate;
        private String recentVersion;
        private int forceUpdate;
        private String description;
        private String md5;
        private String url;

        public int getNeedUpdate() {
            return needUpdate;
        }

        public void setNeedUpdate(int needUpdate) {
            this.needUpdate = needUpdate;
        }

        public String getRecentVersion() {
            return recentVersion;
        }

        public void setRecentVersion(String recentVersion) {
            this.recentVersion = recentVersion;
        }

        public int getForceUpdate() {
            return forceUpdate;
        }

        public void setForceUpdate(int forceUpdate) {
            this.forceUpdate = forceUpdate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
