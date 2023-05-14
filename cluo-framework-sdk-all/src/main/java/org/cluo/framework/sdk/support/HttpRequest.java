package org.cluo.framework.sdk.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.cluo.framework.http.HttpClient;
import org.cluo.framework.http.HttpResponse;
import org.cluo.framework.http.MediaType;
import org.cluo.framework.http.Method;
import org.cluo.framework.json.JSONUtil;
import org.cluo.framework.sdk.exception.SdkAllException;
import org.cluo.framework.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In services-xin.dayukeji.common.util.http
 * Create in 14:32 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
public class HttpRequest<T extends Param> implements Serializable {
	private final Logger logger = LoggerFactory.getLogger("HTTP_CLIENT_LOG");
	protected String url;
	protected HashMap<String, Object> urlParam;
	protected Method method;
	protected MediaType mediaType;
	protected T body;
	protected HashMap<String, String> header;

	protected Class<?> response;

	protected Boolean isList = false;
	protected Boolean isByte;
	protected MediaType responseMediaType;

	public HttpRequest(String url, Method method, Boolean isByte){
		init(null);
		this.url = url;
		this.method = method;
		this.isByte=isByte;
	}
	public HttpRequest(Class<T> clazz, String url, Method method) {
		init(clazz);
		this.url = url;
		this.method = method;
	}
	public HttpRequest(String url, Method method) {
		init(null);
		this.url = url;
		this.method = method;
	}

	public HttpRequest(Class<T> clazz, String url, Method method, MediaType mediaType) {
		this(clazz, url, method,mediaType,false);
	}
	public HttpRequest(Class<T> clazz, String url, Method method, MediaType mediaType, Boolean isByte) {
		init(clazz);
		this.url = url;
		this.method = method;
		if (mediaType != null) {
			this.mediaType = mediaType;
			this.header.put("Content-Type", mediaType.toString());
		}
		if(isByte==null){
			this.isByte=false;
		}else {
			this.isByte = isByte;
		}
	}

	private void init(Class<T> clazz) {
		mediaType = MediaType.JSON;
		if(header==null) {
			header = new HashMap<>();
		}
		header.put("Content-Type", mediaType.toString());
		urlParam = new HashMap<>();
		try {
			if(clazz!=null) {
				Constructor constructor = clazz.getDeclaredConstructor(HttpRequest.class);

				body = (T) constructor.newInstance(this);
			}
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
			body = null;
		}
	}

	public <M> M send() {
		if(Method.GET.equals(method)){
			if(body!=null) {
				addUrlParam(body);
			}
		}
		if(urlParam!=null) {
			urlParam.forEach((k, v) -> {
				System.out.println(v.getClass());
				if (v instanceof List){
					String valueString = JSONUtil.fromObjectAsString(v);
					List<Map> hashMaps = JSONUtil.toListFromString(valueString, Map.class);
					for (int i = 0; i < hashMaps.size(); i++) {
						List<Map.Entry<String, String>> valueList = new ArrayList<Map.Entry<String, String>>(hashMaps.get(i).entrySet());
						for (int j = 0; j < valueList.size(); j++) {
							Object subKey = valueList.get(j).getKey();
							Object subValue = valueList.get(j).getValue();
							if (url.contains("?")){
								url = url + "&" +  (k+ "." + i + "." + subKey) + "=" + subValue;
							}else {
								url = url + "?" +  (k+ "." + i + "." + subKey) + "=" + subValue;
							}
						}
					}
				}else {
					if (url.contains("?")) {
						url = url + "&" + k + "=" + v;
					} else {
						url = url + "?" + k + "=" + v;
					}
				}
			});
		}
		String content = null;
		if (body != null && mediaType!=null) {
			switch (mediaType) {
				case XML:
					content = XmlUtil.toXml(body);
					break;
				case STRING:
					content = String.valueOf(body);
					break;
				case URL_ENCODE:
					content = HttpUtil.toUrlString(body);
					break;

				default:
					content = JSONUtil.fromObjectAsString(body);
			}
		}
		try {
			HttpResponse httpResponse = HttpClient.send(
					url,
					method.name(),
					method.equals(Method.GET) ? null : content,
					header,
					url.contains("https"),
					3000L,
					true,
					""
			);
			byte[] responseContentByte = httpResponse.getContent();
			if (isByte == null)
				isByte = false;
			if(isByte || byte[].class.equals(response)){
				return (M) responseContentByte;
			}
			String responseContent = new String(responseContentByte);
			logger.info("[第三方请求]{}",responseContent.replace("\n",""));
			Object response;
			if (responseMediaType == null) {
				responseMediaType = MediaType.JSON;
			}
			switch (responseMediaType) {
				case XML:
					response = XmlUtil.newBean(responseContent, this.response);
					return (M) response;
				case STRING:
					return (M)responseContent;
				default:
					if (this.response != null) {
						if(String.class.equals(this.response)) {
							response = responseContent;
						}else if(isList){
							response = JSONUtil.toListFromString(responseContent, this.response);
						}else {
							response = JSONUtil.toObjectFromString(responseContent, this.response);
						}
					} else {
						response = JSONUtil.toObjectFromString(responseContent, this.response);
					}
					return (M) response;
			}
		} catch (Exception e) {
			throw new SdkAllException("execute error.", e);
		}
	}

	public HttpRequest<T> setResponse(Class responseClass, MediaType responseMediaType) {
		this.response = responseClass;
		this.responseMediaType = responseMediaType;
		return this;
	}

	public HttpRequest<T> addUrlParam(String key, Object value) {
		this.urlParam.put(key, String.valueOf(value));
		return this;
	}

	public HttpRequest<T> addUrlParam(Param param) {
		JSONUtil.toObjectFromString(JSONUtil.fromObjectAsString(param), Map.class).forEach((k,v) ->{
			if (v!=null)
				this.urlParam.put(k.toString(),v);
		});
		return this;
	}

	public HttpRequest<T> addHeader(String key, String value) {
		this.header.put(key, value);
		return this;
	}

	public HttpRequest setHeader(HashMap<String, String> header) {
		this.header = header;
		return this;
	}

	public HttpRequest<T> addHeader(Map<String, String> header) {
		if (header != null) {
			this.header.putAll(header);
		}
		return this;
	}

	public T getBody() {
		return body;
	}


	public String getUrl() {
		return url;
	}

	public HashMap<String, Object> getUrlParam() {
		return urlParam;
	}

	public Method getMethod() {
		return method;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public HashMap<String, String> getHeader() {
		return header;
	}

	public Class getResponse() {
		return response;
	}

	public Boolean getByte() {
		return isByte;
	}

	public MediaType getResponseMediaType() {
		return responseMediaType;
	}

	public HttpRequest<T> isList() {
		isList = true;
		return this;
	}
}
