package org.cluo.framework.sdk.all.ali.api.ic_orc;


import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.ic_orc
 * Create in 23:01 2018/8/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IcOrcResponse {
	private String code;
	private String msg;
	private ResultResponse result;
	public static class ResultResponse implements Serializable{
		private Node 法定代表人;
		private Node 营业期限;
		private Node 经营范围;
		private Node 住所;
		private Node 成立日期;
		private Node 名称;
		private Node 注册资本;
		private Node 统一社会信用代码;
		private Node 类型;

		public Node get法定代表人() {
			return 法定代表人;
		}

		public ResultResponse set法定代表人(Node 法定代表人) {
			this.法定代表人 = 法定代表人;
			return this;
		}

		public Node get营业期限() {
			return 营业期限;
		}

		public ResultResponse set营业期限(Node 营业期限) {
			this.营业期限 = 营业期限;
			return this;
		}

		public Node get经营范围() {
			return 经营范围;
		}

		public ResultResponse set经营范围(Node 经营范围) {
			this.经营范围 = 经营范围;
			return this;
		}

		public Node get住所() {
			return 住所;
		}

		public ResultResponse set住所(Node 住所) {
			this.住所 = 住所;
			return this;
		}

		public Node get成立日期() {
			return 成立日期;
		}

		public ResultResponse set成立日期(Node 成立日期) {
			this.成立日期 = 成立日期;
			return this;
		}

		public Node get名称() {
			return 名称;
		}

		public ResultResponse set名称(Node 名称) {
			this.名称 = 名称;
			return this;
		}

		public Node get注册资本() {
			return 注册资本;
		}

		public ResultResponse set注册资本(Node 注册资本) {
			this.注册资本 = 注册资本;
			return this;
		}

		public Node get统一社会信用代码() {
			return 统一社会信用代码;
		}

		public ResultResponse set统一社会信用代码(Node 统一社会信用代码) {
			this.统一社会信用代码 = 统一社会信用代码;
			return this;
		}

		public Node get类型() {
			return 类型;
		}

		public ResultResponse set类型(Node 类型) {
			this.类型 = 类型;
			return this;
		}
	}
	public static class Node implements Serializable{
		private String words;

		public String getWords() {
			return words;
		}

		public Node setWords(String words) {
			this.words = words;
			return this;
		}
	}

	public String getCode() {
		return code;
	}

	public IcOrcResponse setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public IcOrcResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public ResultResponse getResult() {
		return result;
	}

	public IcOrcResponse setResult(ResultResponse result) {
		this.result = result;
		return this;
	}
}
