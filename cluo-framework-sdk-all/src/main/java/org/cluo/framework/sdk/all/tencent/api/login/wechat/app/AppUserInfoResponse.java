package org.cluo.framework.sdk.all.tencent.api.login.wechat.app;

import java.io.Serializable;
import java.util.List;

/**
 * In Yiming--org.cluo.framework.sdk.all.tencent.aggregation.login
 * Create in 19:47 2018/7/22
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class AppUserInfoResponse implements Serializable {
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public AppUserInfoResponse setErrcode(Integer errcode) {
        this.errcode = errcode;
        return this;
    }

    public AppUserInfoResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
