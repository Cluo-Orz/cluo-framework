package org.cluo.framework.sdk.all.tencent.api.login.wechat.mini;


import java.io.Serializable;

/**
 * In yiming--org.cluo.framework.sdk.all.tencent.api.login
 * Create in 15:42 2018/8/8
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MiniUserInfoResponse implements Serializable {
    private String openId;
    private String nickName;
    private Integer gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    private Watermark watermark;

    public static class Watermark implements Serializable {
        private String addid;
        private Long timestamp;

        public String getAddid() {
            return addid;
        }

        public Watermark setAddid(String addid) {
            this.addid = addid;
            return this;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public Watermark setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
    }

    public String getOpenId() {
        return openId;
    }

    public MiniUserInfoResponse setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public MiniUserInfoResponse setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public MiniUserInfoResponse setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getCity() {
        return city;
    }

    public MiniUserInfoResponse setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MiniUserInfoResponse setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPurePhoneNumber() {
        return purePhoneNumber;
    }

    public MiniUserInfoResponse setPurePhoneNumber(String purePhoneNumber) {
        this.purePhoneNumber = purePhoneNumber;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public MiniUserInfoResponse setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public MiniUserInfoResponse setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MiniUserInfoResponse setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public MiniUserInfoResponse setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getUnionId() {
        return unionId;
    }

    public MiniUserInfoResponse setUnionId(String unionId) {
        this.unionId = unionId;
        return this;
    }

    public Watermark getWatermark() {
        return watermark;
    }

    public MiniUserInfoResponse setWatermark(Watermark watermark) {
        this.watermark = watermark;
        return this;
    }

    @Override
    public String toString() {
        return "MiniUserInfoResponse{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", unionId='" + unionId + '\'' +
                ", watermark=" + watermark +
                '}';
    }
}
