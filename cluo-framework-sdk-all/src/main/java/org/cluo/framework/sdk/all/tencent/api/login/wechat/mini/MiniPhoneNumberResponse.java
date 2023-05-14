package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;

import java.io.Serializable;

/**
 * @author canfuu.cts
 * @class MiniPhoneNumberRequest
 * @date 2023/5/13 17:04
 */
public class MiniPhoneNumberResponse implements Serializable {
    private Integer errcode;
    private String errmsg;
    private PhoneInfo phone_info;

    public static class PhoneInfo  implements Serializable{

        private String phoneNumber;
        private String purePhoneNumber;
        private String countryCode;
        private Watermark watermark;

        public static class Watermark implements Serializable{
            private Double timestamp;
            private String appid;

            public Double getTimestamp() {
                return timestamp;
            }

            public Watermark setTimestamp(Double timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public String getAppid() {
                return appid;
            }

            public Watermark setAppid(String appid) {
                this.appid = appid;
                return this;
            }
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public PhoneInfo setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public String getPurePhoneNumber() {
            return purePhoneNumber;
        }

        public PhoneInfo setPurePhoneNumber(String purePhoneNumber) {
            this.purePhoneNumber = purePhoneNumber;
            return this;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public PhoneInfo setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Watermark getWatermark() {
            return watermark;
        }

        public PhoneInfo setWatermark(Watermark watermark) {
            this.watermark = watermark;
            return this;
        }
    }

    public Integer getErrcode() {
        return errcode;
    }

    public MiniPhoneNumberResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public MiniPhoneNumberResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    public PhoneInfo getPhone_info() {
        return phone_info;
    }

    public MiniPhoneNumberResponse setPhone_info(PhoneInfo phone_info) {
        this.phone_info = phone_info;
        return this;
    }
}
