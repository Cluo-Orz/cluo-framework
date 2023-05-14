package org.cluo.framework.sdk.all.juhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.cluo.framework.sdk.all.Sdk;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali
 * Create in 17:31 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "third-service.juhe")  // 配置文件中的前缀
public class Juhe implements Serializable {
	@Autowired
	protected Sms sms;

	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.juhe.sms")
	public static class Sms extends Sdk.BaseThirdSdk implements Serializable {
		private Integer templateId;
		private String appKey;

		public Integer getTemplateId() {
			return templateId;
		}

		public Sms setTemplateId(Integer templateId) {
			this.templateId = templateId;
			return this;
		}

		public String getAppKey() {
			return appKey;
		}

		public Sms setAppKey(String appKey) {
			this.appKey = appKey;
			return this;
		}

		@Override
		public String toString() {
			return "Sms{" +
					"templateId='" + templateId + '\'' +
					", appKey='" + appKey + '\'' +
					'}';
		}
	}

	public Sms getSms() {
		return sms;
	}

	public Juhe setSms(Sms sms) {
		this.sms = sms;
		return this;
	}

	@Override
	public String toString() {
		return "Juhe{" +
				"sms=" + sms +
				'}';
	}
}

