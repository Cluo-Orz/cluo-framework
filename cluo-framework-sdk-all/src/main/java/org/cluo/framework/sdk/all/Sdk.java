package org.cluo.framework.sdk.all;

import org.cluo.framework.http.MediaType;
import org.cluo.framework.sdk.support.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.cluo.framework.sdk.all.ali.Ali;
import org.cluo.framework.sdk.all.tencent.Tencent;
import org.cluo.framework.http.Method;
import org.cluo.framework.sdk.support.Param;

import java.io.Serializable;
import java.util.HashMap;

/**
 * In services--org.cluo.framework.sdk.all
 * Create in 17:27 2018/8/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "third-service")  // 配置文件中的前缀
public class Sdk implements Serializable{
	@Autowired
	private Ali ali;
	@Autowired
	private Tencent tencent;

	public Ali getAli() {
		return ali;
	}

	public Sdk setAli(Ali ali) {
		this.ali = ali;
		return this;
	}

	public Tencent getTencent() {
		return tencent;
	}

	public Sdk setTencent(Tencent tencent) {
		this.tencent = tencent;
		return this;
	}

	public static class BaseThirdSdk<T extends Param<T>> implements Serializable{
		protected String url;
		protected Method method;
		protected MediaType mediaType;
		protected HashMap<String,String> header;
		protected Class<T> body;
		protected Boolean isByte;
		public HttpRequest<T> request(){

			if(isByte==null){
				isByte=false;
			}
			HttpRequest<T> request = new HttpRequest<>(body, url, method, mediaType, isByte);
			request.addHeader(header);
			return request;
		}
		public String getUrl() {
			return url;
		}

		public BaseThirdSdk setUrl(String url) {
			this.url = url;
			return this;
		}

		public HashMap<String, String> getHeader() {
			return header;
		}

		public Boolean getIsByte() {
			return isByte;
		}

		public BaseThirdSdk setIsByte(Boolean aByte) {
			isByte = aByte;
			return this;
		}

		public BaseThirdSdk setHeader(HashMap<String, String> header) {
			this.header = header;
			return this;
		}

		public Method getMethod() {
			return method;
		}

		public BaseThirdSdk setMethod(Method method) {
			this.method = method;
			return this;
		}

		public MediaType getMediaType() {
			return mediaType;
		}

		public BaseThirdSdk setMediaType(MediaType mediaType) {
			this.mediaType = mediaType;
			return this;
		}

		public Class<T> getBody() {
			return body;
		}
		public BaseThirdSdk setBody(String body) {
			try {
				this.body = (Class<T>) Class.forName(body);
			} catch (ClassNotFoundException e) {
				this.body=null;
			}
			return this;
		}
		public BaseThirdSdk setBody(Class<T> body) {
			this.body = body;
			return this;
		}

	}
}
