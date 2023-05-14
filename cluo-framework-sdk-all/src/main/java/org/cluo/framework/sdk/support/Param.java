package org.cluo.framework.sdk.support;

import org.cluo.framework.json.JSONUtil;
import org.cluo.framework.sdk.exception.SdkAllException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In services-org.cluo.framework.http
 * Create in 18:30 2018/8/23
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
public class Param<S extends Param<S>>  implements Serializable {
	private final transient HttpRequest<S> request;

	public Param(HttpRequest<S> request){
		this.request=request;
	}

	public S send(){
		return request.send();
	}

	public HttpRequest<S> closeBody() {
		return request;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String s = null;
		HashMap map = null;
		try {
			s = JSONUtil.fromObjectAsString(this);
			map = JSONUtil.toObjectFromString(s, HashMap.class);
		} catch (Exception e) {
			throw new SdkAllException("json parse error.", e);
		}
		List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
		//升序排序
		list.sort(Map.Entry.comparingByKey());
		list.forEach(stringStringEntry -> {
			Object key = stringStringEntry.getKey();
			Object value = stringStringEntry.getValue();
			if (key != null && value != null) {
				builder.append(key).append("=").append(value).append("&");
			}
		});
		if (builder.length()>0) {
			return CharUtil.removeLastChar(builder);
		}
		return "";
	}
}
