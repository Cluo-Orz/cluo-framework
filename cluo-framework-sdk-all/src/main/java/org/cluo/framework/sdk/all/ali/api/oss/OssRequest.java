package org.cluo.framework.sdk.all.ali.api.oss;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * In services--org.cluo.framework.sdk.all.ali.api.oss
 * Create in 22:32 2019/1/17
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
public class OssRequest  implements Serializable {
	@JsonProperty("VERB")
	private String VERB;
	@JsonProperty("ContentType")
	private String ContentType;
	@JsonProperty("ContentMD5")
	private String ContentMD5;
	@JsonProperty("Date")
	private String Date;
	@JsonProperty("CanonicalizedOSSHeaders")
	private Map<String,String> CanonicalizedOSSHeaders;
	@JsonProperty("CanonicalizedResource")
	private String CanonicalizedResource;

	public String getVERB() {
		return VERB;
	}

	public void setVERB(String VERB) {
		this.VERB = VERB;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getContentMD5() {
		return ContentMD5;
	}

	public void setContentMD5(String contentMD5) {
		ContentMD5 = contentMD5;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Map<String, String> getCanonicalizedOSSHeaders() {
		return CanonicalizedOSSHeaders;
	}

	public void setCanonicalizedOSSHeaders(Map<String, String> canonicalizedOSSHeaders) {
		CanonicalizedOSSHeaders = canonicalizedOSSHeaders;
	}

	public String getCanonicalizedResource() {
		return CanonicalizedResource;
	}

	public void setCanonicalizedResource(String canonicalizedResource) {
		CanonicalizedResource = canonicalizedResource;
	}
}
