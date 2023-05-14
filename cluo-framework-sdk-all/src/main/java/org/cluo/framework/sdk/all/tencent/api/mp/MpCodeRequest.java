package org.cluo.framework.sdk.all.tencent.api.mp;

import org.cluo.framework.sdk.support.HttpRequest;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.tencent.api.mp
 * Create in 21:43 2018/9/11
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class MpCodeRequest extends Param<MpCodeRequest> implements Serializable{
	public MpCodeRequest(HttpRequest<MpCodeRequest> request) {
		super(request);
	}
	private String scene;
	private String page;
	private Integer width;
	private Boolean auto_color;
	private Color line_color;
	private Boolean is_hyaline;
	public static class Color implements Serializable{
		private String r;
		private String g;
		private String b;

		public String getR() {
			return r;
		}

		public void setR(String r) {
			this.r = r;
		}

		public String getG() {
			return g;
		}

		public void setG(String g) {
			this.g = g;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}
	}

	public String getScene() {
		return scene;
	}

	public MpCodeRequest setScene(String scene) {
		this.scene = scene;
		return this;
	}

	public String getPage() {
		return page;
	}

	public MpCodeRequest setPage(String page) {
		this.page = page;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public MpCodeRequest setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Boolean getAuto_color() {
		return auto_color;
	}

	public MpCodeRequest setAuto_color(Boolean auto_color) {
		this.auto_color = auto_color;
		return this;
	}

	public Color getLine_color() {
		return line_color;
	}

	public MpCodeRequest setLine_color(Color line_color) {
		this.line_color = line_color;
		return this;
	}

	public Boolean getIs_hyaline() {
		return is_hyaline;
	}

	public MpCodeRequest setIs_hyaline(Boolean is_hyaline) {
		this.is_hyaline = is_hyaline;
		return this;
	}
}
