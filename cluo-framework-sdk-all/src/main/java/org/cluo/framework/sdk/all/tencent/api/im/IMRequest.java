package org.cluo.framework.sdk.all.tencent.api.im;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 12:52 2018/8/20
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IMRequest implements Serializable{
	@JsonProperty("CallbackCommand")
	private String CallbackCommand;
	@JsonProperty("GroupId")
	private String GroupId;
	@JsonProperty("Type")
	private String Type;
	@JsonProperty("From_Account")
	private String From_Account;
	@JsonProperty("To_Account")
	private String To_Account;
	@JsonProperty("MsgSeq")
	private Long MsgSeq;
	@JsonProperty("MsgTime")
	private Long MsgTime;
	@JsonProperty("JoinType")
	private String JoinType;
	@JsonProperty("Operator_Account")
	private String Operator_Account;
	@JsonProperty("NewMemberList")
	private List<Member> NewMemberList;
	@JsonProperty("ExitMemberList")
	private List<Member> ExitMemberList;
	@JsonProperty("MsgBody")
	private List<MsgBody> MsgBody;
	public static class MsgBody implements Serializable {
		@JsonProperty("MsgType")
		private String MsgType;
		@JsonProperty("MsgContent")
		private MsgContent MsgContent;

		public static class MsgContent implements Serializable {
			@JsonProperty("Text")
			private String Text;

			public String getText() {
				return Text;
			}

			public MsgContent setText(String text) {
				Text = text;
				return this;
			}
		}

		public String getMsgType() {
			return MsgType;
		}

		public MsgBody setMsgType(String msgType) {
			MsgType = msgType;
			return this;
		}

		public MsgBody.MsgContent getMsgContent() {
			return MsgContent;
		}

		public MsgBody setMsgContent(MsgBody.MsgContent msgContent) {
			MsgContent = msgContent;
			return this;
		}
	}

	public static class Member implements Serializable{
		@JsonProperty("Member_Account")
		private String Member_Account;

		public String getMember_Account() {
			return Member_Account;
		}

		public Member setMember_Account(String member_Account) {
			Member_Account = member_Account;
			return this;
		}
	}

	public String getCallbackCommand() {
		return CallbackCommand;
	}

	public IMRequest setCallbackCommand(String callbackCommand) {
		CallbackCommand = callbackCommand;
		return this;
	}

	public String getGroupId() {
		return GroupId;
	}

	public IMRequest setGroupId(String groupId) {
		GroupId = groupId;
		return this;
	}

	public String getType() {
		return Type;
	}

	public IMRequest setType(String type) {
		Type = type;
		return this;
	}

	public String getJoinType() {
		return JoinType;
	}

	public IMRequest setJoinType(String joinType) {
		JoinType = joinType;
		return this;
	}

	public String getOperator_Account() {
		return Operator_Account;
	}

	public IMRequest setOperator_Account(String operator_Account) {
		Operator_Account = operator_Account;
		return this;
	}

	public List<Member> getExitMemberList() {
		return ExitMemberList;
	}

	public IMRequest setExitMemberList(List<Member> exitMemberList) {
		ExitMemberList = exitMemberList;
		return this;
	}

	public List<Member> getNewMemberList() {
		return NewMemberList;
	}

	public IMRequest setNewMemberList(List<Member> newMemberList) {
		NewMemberList = newMemberList;
		return this;
	}
	public List<MsgBody> getMsgBody() {
		return MsgBody;
	}

	public IMRequest setMsgBody(List<MsgBody> msgBody) {
		MsgBody = msgBody;
		return this;
	}

	public String getFrom_Account() {
		return From_Account;
	}

	public IMRequest setFrom_Account(String from_Account) {
		From_Account = from_Account;
		return this;
	}

	public Long getMsgSeq() {
		return MsgSeq;
	}

	public IMRequest setMsgSeq(Long msgSeq) {
		MsgSeq = msgSeq;
		return this;
	}

	public Long getMsgTime() {
		return MsgTime;
	}

	public IMRequest setMsgTime(Long msgTime) {
		MsgTime = msgTime;
		return this;
	}

	public String getTo_Account() {
		return To_Account;
	}

	public IMRequest setTo_Account(String to_Account) {
		To_Account = to_Account;
		return this;
	}
}
