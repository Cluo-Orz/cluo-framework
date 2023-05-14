package org.cluo.framework.sdk.all.tencent.api.live;


import java.io.Serializable;
import java.util.List;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.live
 * Create in 22:06 2018/8/15
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class CommonAccessResponse implements Serializable {
    private Integer ret;
    private String message;
    private List<Output> output;

    public static class Output implements Serializable {
        private Integer rate_type;
        private Integer recv_type;
        private Integer status;

        public Integer getRate_type() {
            return rate_type;
        }

        public Output setRate_type(Integer rate_type) {
            this.rate_type = rate_type;
            return this;
        }

        public Integer getRecv_type() {
            return recv_type;
        }

        public Output setRecv_type(Integer recv_type) {
            this.recv_type = recv_type;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Output setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }

    public Integer getRet() {
        return ret;
    }

    public CommonAccessResponse setRet(Integer ret) {
        this.ret = ret;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonAccessResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Output> getOutput() {
        return output;
    }

    public CommonAccessResponse setOutput(List<Output> output) {
        this.output = output;
        return this;
    }
}
