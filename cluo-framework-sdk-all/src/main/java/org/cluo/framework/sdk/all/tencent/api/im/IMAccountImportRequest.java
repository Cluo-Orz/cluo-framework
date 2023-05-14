package org.cluo.framework.sdk.all.tencent.api.im;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.im
 * Create in 16:15 2018/11/4
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class IMAccountImportRequest extends Param<IMAccountImportRequest> implements Serializable{

	public IMAccountImportRequest(HttpRequest<IMAccountImportRequest> request) {
		super(request);
	}
	@JsonProperty("Identifier")
	private String Identifier;
	@JsonProperty("Nick")
	private String Nick;
	@JsonProperty("FaceUrl")
	private String FaceUrl;

	public String getIdentifier() {
		return Identifier;
	}

	public IMAccountImportRequest setIdentifier(String identifier) {
		Identifier = identifier;
		return this;
	}

	public String getNick() {
		return Nick;
	}

	public IMAccountImportRequest setNick(String nick) {
		Nick = nick;
		return this;
	}

	public String getFaceUrl() {
		return FaceUrl;
	}

	public IMAccountImportRequest setFaceUrl(String faceUrl) {
		FaceUrl = faceUrl;
		return this;
	}
}
