package org.cluo.framework.sdk.all.tencent.api.im;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author: thone
 * time: 2019/4/7 下午4:42
 * desc: //TODO
 **/
public class ImGroupRequest extends Param<ImGroupRequest> implements Serializable {

    public ImGroupRequest(HttpRequest<ImGroupRequest> request) {
        super(request);
    }

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("MemberList")
    private List<Member> MemberList;

    public static class Member implements Serializable{
        @JsonProperty("Member_Account")
        private String MemberAccount;

        @JsonProperty("Member_Account")
        public String getMemberAccount() {
            return MemberAccount;
        }

        @JsonProperty("Member_Account")
        public void setMemberAccount(String memberAccount) {
            MemberAccount = memberAccount;
        }
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public ImGroupRequest setName(String name) {
        Name = name;
        return this;
    }

    @JsonProperty("Type")
    public String getType() {
        return Type;
    }

    @JsonProperty("Type")
    public ImGroupRequest setType(String type) {
        Type = type;
        return this;
    }
    @JsonProperty("MemberList")
    public List<Member> getMemberList() {
        return MemberList;
    }

    @JsonProperty("MemberList")
    public ImGroupRequest setMemberList(List<Member> memberList) {
        MemberList = memberList;
        return this;
    }
}
