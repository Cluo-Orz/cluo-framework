package org.cluo.framework.http;


import java.io.Serializable;

/**
 * In services-org.cluo.framework.http
 * Create in 18:31 2018/8/23
 *
 * author canfuu
 * @version v1.0
 * descriotion 描述
 */
public enum MediaType implements Serializable{
	JSON,XML,URL_ENCODE,STRING;
	@Override
	public String toString() {
		switch (this){
			case XML:
				return "application/xml";
			case URL_ENCODE:
				return "application/x-www-form-urlencoded";
			case STRING:
				return "html/text";
			default:
				return "application/json";
		}
	}
}
