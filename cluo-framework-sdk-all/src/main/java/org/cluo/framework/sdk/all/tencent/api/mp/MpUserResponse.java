package org.cluo.framework.sdk.all.tencent.api.mp;


import java.io.Serializable;
import java.util.Arrays;

public class MpUserResponse implements Serializable {
    private Integer errcode;

    private String errmsg;

    private String openid;

    private String nickname;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String[] privilege;

    private String unionid;

    public Integer getErrcode() {
        return errcode;
    }

    public MpUserResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public MpUserResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public MpUserResponse setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public MpUserResponse setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public MpUserResponse setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public MpUserResponse setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public MpUserResponse setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MpUserResponse setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public MpUserResponse setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
        return this;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public MpUserResponse setPrivilege(String[] privilege) {
        this.privilege = privilege;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public MpUserResponse setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }

    @Override
    public String toString() {
        return "MpUserResponse{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", privilege=" + Arrays.toString(privilege) +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
