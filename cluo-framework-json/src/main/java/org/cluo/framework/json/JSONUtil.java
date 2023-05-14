package org.cluo.framework.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cluo.framework.json.exception.CluoJsonException;

import java.io.IOException;
import java.util.List;

public class JSONUtil {
	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	static {
		OBJECT_MAPPER.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
		OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		OBJECT_MAPPER.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.NONE);
		OBJECT_MAPPER.setVisibility(PropertyAccessor.GETTER,JsonAutoDetect.Visibility.ANY);
		OBJECT_MAPPER.setVisibility(PropertyAccessor.SETTER,JsonAutoDetect.Visibility.ANY);
		OBJECT_MAPPER.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		OBJECT_MAPPER.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
	}
	public static <T> T toObjectFromString(String json,Class<T> t) {
		try {
			return OBJECT_MAPPER.readValue(json, t);
		} catch (JsonProcessingException e) {
			throw new CluoJsonException("toObjectFromString" + t.toString() + " error.", e);
		}
	}
	public static <T> T toObjectFromBytes(byte[] json,Class<T> t) {
		try {
			return OBJECT_MAPPER.readValue(json,t);
		} catch (IOException e) {
			throw new CluoJsonException("toObjectFromBytes" + t.toString() + " error.", e);
		}
	}
	public static <T> List<T> toListFromString(String json,Class<T> t) {
		JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{t});
		List<T> send = null;
		try {
			send = OBJECT_MAPPER.readValue(json, javaType);
		} catch (JsonProcessingException e) {
			throw new CluoJsonException("toListFromString" + t.toString() + " error.", e);
		}
		return send;
	}
	public static <T> T toObjectFromString(String json, TypeReference<T> typeReference) {
		T send = null;
		try {
			send = OBJECT_MAPPER.readValue(json, typeReference);
		} catch (JsonProcessingException e) {
			throw new CluoJsonException("toObjectFromString" + typeReference.toString() + " error.", e);
		}
		return send;
	}
	public static <T> List<T> toListFromBytes(byte[] json,Class<T> t)  {
		JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{t});
		List<T> send = null;
		try {
			send = OBJECT_MAPPER.readValue(json, javaType);
		} catch (IOException e) {
			throw new CluoJsonException("toListFromBytes" + t.toString() + " error.", e);
		}
		return send;
	}
	public static String fromObjectAsString(Object json) {
		try {
			return OBJECT_MAPPER.writeValueAsString(json);
		} catch (JsonProcessingException e) {
			throw new CluoJsonException("fromObjectAsString" + json.toString() + " error.", e);
		}
	}
	public static byte[] fromObjectAsBytes(Object json) {
		try {
			return OBJECT_MAPPER.writeValueAsBytes(json);
		} catch (JsonProcessingException e) {
			throw new CluoJsonException("fromObjectAsBytes" + json.toString() + " error.", e);
		}
	}
	public static ObjectMapper getObjectMapper(){
		return OBJECT_MAPPER;
	}
	public static boolean isJson(String json){
		try{

			OBJECT_MAPPER.readTree(json);
		 	return !isInteger(json);
		} catch(Exception e){
		    return false;
		}
	}
	public static boolean isInteger(String str){
		try{

			return  Integer.valueOf(str)!=null;
		} catch(Exception e){
			return false;
		}
	}

}
