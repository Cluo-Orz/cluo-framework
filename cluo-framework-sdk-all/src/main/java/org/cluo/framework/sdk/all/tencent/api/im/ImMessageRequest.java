package org.cluo.framework.sdk.all.tencent.api.im;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;
import java.util.List;

public class ImMessageRequest extends Param<ImMessageRequest> implements Serializable {

    public ImMessageRequest(HttpRequest<ImMessageRequest> request) {
        super(request);
    }

    @JsonProperty("SyncOtherMachine")
    private Integer SyncOtherMachine;

    @JsonProperty("To_Account")
    private String To_Account;

    @JsonProperty("MsgLifeTime")
    private Integer MsgLifeTime;

    @JsonProperty("MsgRandom")
    private Integer MsgRandom;

    @JsonProperty("MsgTimeStamp")
    private Long MsgTimeStamp;

    @JsonProperty("MsgBody")
    private List<MsgBodyReq> MsgBody;

    public static class MsgBodyReq implements Serializable{
        @JsonProperty("MsgType")
        private String MsgType;

        @JsonProperty("MsgContent")
        private MsgContentReq MsgContent;

        public static class MsgContentReq implements Serializable{
            @JsonProperty("Text")
            private String Text;

            public String getText() {
                return Text;
            }

            public void setText(String text) {
                Text = text;
            }

            @Override
            public String toString() {
                return "MsgContentReq{" +
                        "Text='" + Text + '\'' +
                        '}';
            }
        }

        public String getMsgType() {
            return MsgType;
        }

        public void setMsgType(String msgType) {
            MsgType = msgType;
        }

        public MsgContentReq getMsgContent() {
            return MsgContent;
        }

        public void setMsgContent(MsgContentReq msgContent) {
            MsgContent = msgContent;
        }

        @Override
        public String toString() {
            return "MsgBodyReq{" +
                    "MsgType='" + MsgType + '\'' +
                    ", MsgContent=" + MsgContent +
                    '}';
        }
    }

    public Integer getSyncOtherMachine() {
        return SyncOtherMachine;
    }

    public ImMessageRequest setSyncOtherMachine(Integer syncOtherMachine) {
        SyncOtherMachine = syncOtherMachine;
        return this;
    }

    public String getTo_Account() {
        return To_Account;
    }

    public ImMessageRequest setTo_Account(String to_Account) {
        To_Account = to_Account;
        return this;
    }

    public Integer getMsgLifeTime() {
        return MsgLifeTime;
    }

    public ImMessageRequest setMsgLifeTime(Integer msgLifeTime) {
        MsgLifeTime = msgLifeTime;
        return this;
    }

    public Integer getMsgRandom() {
        return MsgRandom;
    }

    public ImMessageRequest setMsgRandom(Integer msgRandom) {
        MsgRandom = msgRandom;
        return this;
    }

    public Long getMsgTimeStamp() {
        return MsgTimeStamp;
    }

    public ImMessageRequest setMsgTimeStamp(Long msgTimeStamp) {
        MsgTimeStamp = msgTimeStamp;
        return this;
    }

    public List<MsgBodyReq> getMsgBody() {
        return MsgBody;
    }

    public ImMessageRequest setMsgBody(List<MsgBodyReq> msgBody) {
        MsgBody = msgBody;
        return this;
    }

    @Override
    public String toString() {
        return "ImMessageRequest{" +
                "SyncOtherMachine=" + SyncOtherMachine +
                ", To_Account='" + To_Account + '\'' +
                ", MsgLifeTime=" + MsgLifeTime +
                ", MsgRandom=" + MsgRandom +
                ", MsgTimeStamp=" + MsgTimeStamp +
                ", MsgBody=" + MsgBody +
                '}';
    }
}
