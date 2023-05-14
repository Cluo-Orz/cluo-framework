package org.cluo.framework.sdk.support;

/**
 * @author canfuu.cts
 * @class Report
 * @date 2023/5/13 11:02
 */
public class Report {
    private Integer status;
    private Object data;
    private Object cnNotice;
    private Object enNotice;
    private Object notice;
    private Object msg;


    public Report() {
    }

    public Report(int status, Object o) {
        this.status = status;
        if (status == 0) {
            data = o;
        } else {
            msg = o;
        }
    }

    public Report(int status, Object data, Object msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Report(int status, Object data, Object notice, Object msg) {
        this.status = status;
        this.data = data;
        this.notice = notice;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public Report setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Report setData(Object data) {
        this.data = data;
        return this;
    }

    public Object getCnNotice() {
        return cnNotice;
    }

    public Report setCnNotice(Object cnNotice) {
        this.cnNotice = cnNotice;
        return this;
    }

    public Object getEnNotice() {
        return enNotice;
    }

    public Report setEnNotice(Object enNotice) {
        this.enNotice = enNotice;
        return this;
    }

    public Object getNotice() {
        return notice;
    }

    public Report setNotice(Object notice) {
        this.notice = notice;
        return this;
    }

    public Object getMsg() {
        return msg;
    }

    public Report setMsg(Object msg) {
        this.msg = msg;
        return this;
    }
}
