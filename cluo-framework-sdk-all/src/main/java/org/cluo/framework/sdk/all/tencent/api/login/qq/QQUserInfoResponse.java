package org.cluo.framework.sdk.all.tencent.api.login.qq;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.login.qq
 * Create in 00:57 2018/8/17
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class QQUserInfoResponse implements Serializable {
    private String ret;
    private String msg;
    private String nickname;
    private String figureurl;
    private String figureurl_1;
    private String figureurl_2;
    private String figureurl_qq_1;
    private String figureurl_qq_2;
    private String gender;
    private String is_yellow_vip;
    private String vip;
    private String yellow_vip_level;
    private String level;
    private String is_yellow_year_vip;

    public String getRet() {
        return ret;
    }

    public QQUserInfoResponse setRet(String ret) {
        this.ret = ret;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public QQUserInfoResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public QQUserInfoResponse setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public QQUserInfoResponse setFigureurl(String figureurl) {
        this.figureurl = figureurl;
        return this;
    }

    public String getFigureurl_1() {
        return figureurl_1;
    }

    public QQUserInfoResponse setFigureurl_1(String figureurl_1) {
        this.figureurl_1 = figureurl_1;
        return this;
    }

    public String getFigureurl_2() {
        return figureurl_2;
    }

    public QQUserInfoResponse setFigureurl_2(String figureurl_2) {
        this.figureurl_2 = figureurl_2;
        return this;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public QQUserInfoResponse setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
        return this;
    }

    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public QQUserInfoResponse setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public QQUserInfoResponse setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public QQUserInfoResponse setIs_yellow_vip(String is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
        return this;
    }

    public String getVip() {
        return vip;
    }

    public QQUserInfoResponse setVip(String vip) {
        this.vip = vip;
        return this;
    }

    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public QQUserInfoResponse setYellow_vip_level(String yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public QQUserInfoResponse setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }

    public QQUserInfoResponse setIs_yellow_year_vip(String is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
        return this;
    }
}
