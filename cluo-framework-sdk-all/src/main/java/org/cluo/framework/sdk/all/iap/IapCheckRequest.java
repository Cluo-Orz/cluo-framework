package org.cluo.framework.sdk.all.iap;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.all.tencent.api.pay.RsaPublicRequest;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * author: thone
 * time: 2019/6/19 下午9:03
 * desc: //TODO
 **/
public class IapCheckRequest extends Param<RsaPublicRequest> implements Serializable {
    public IapCheckRequest(HttpRequest<RsaPublicRequest> request) {
        super(request);
    }

    @JsonProperty("receipt-data")
    private String receiptData;

    public String getReceiptData() {
        return receiptData;
    }

    public IapCheckRequest setReceiptData(String receiptData) {
        this.receiptData = receiptData;
        return this;
    }

    @Override
    public String toString() {
        return "IapCheckRequest{" +
                "receiptData='" + receiptData + '\'' +
                '}';
    }
}
