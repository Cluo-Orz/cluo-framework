package org.cluo.framework.sdk.all.ali;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.cluo.framework.sdk.all.Sdk;
import org.cluo.framework.sdk.all.ali.api.bank_check.BankCheckRequest;
import org.cluo.framework.sdk.all.ali.api.ic_check.IcCheckRequest;
import org.cluo.framework.sdk.all.ali.api.ic_orc.IcOrcRequest;
import org.cluo.framework.sdk.all.ali.api.id_check.IdCheckRequest;

import java.io.Serializable;

/**
 * In services--org.cluo.framework.sdk.all.ali
 * Create in 17:31 2018/8/23
 *
 * author canfuu
 * version v1.0
 * descriotion 描述
 */
@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "third-service.ali")  // 配置文件中的前缀
public class Ali implements Serializable {
    @Autowired
    protected Phone phone;
    @Autowired
    protected Pay pay;
    @Autowired
    protected IcCheck icCheck;
    @Autowired
    protected IcOrc icOrc;
    @Autowired
    protected IdCheck idCheck;
    @Autowired
    protected BankCheck bankCheck;
    @Autowired
    protected Oss oss;
    @Autowired
    protected Vod vod;

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.live")
    public static class Live implements Serializable {
        private String accessKeyId;
        private String accessKeySecret;
        private String domainName;
        private String key;
        private Long invalidTime;

        public Long getInvalidTime() {
            return invalidTime;
        }

        public void setInvalidTime(Long invalidTime) {
            this.invalidTime = invalidTime;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.vod")
    public static class Vod implements Serializable {
        private String accessKeyId;
        private String accessKeySecret;
        private String region;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    @Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
    @ConfigurationProperties(prefix = "third-service.ali.oss")
    public static class Oss extends Sdk.BaseThirdSdk implements Serializable {
        private String accessKeyId;
        private String accessKeySecret;
        private String bucket;
        private String region;
        private String endpoint;
        private String visitPrefix;

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getVisitPrefix() {
            return visitPrefix;
        }

        public void setVisitPrefix(String visitPrefix) {
            this.visitPrefix = visitPrefix;
        }
    }

    @Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
    @ConfigurationProperties(prefix = "third-service.ali.phone")
    public static class Phone extends Sdk.BaseThirdSdk implements Serializable {
        private String dayuIdIdentifyCode;
        private String dayuSignature;
        private String accessKeyId;
        private String accessKeySecret;

        public String getDayuIdIdentifyCode() {
            return dayuIdIdentifyCode;
        }

        public Phone setDayuIdIdentifyCode(String dayuIdIdentifyCode) {
            this.dayuIdIdentifyCode = dayuIdIdentifyCode;
            return this;
        }

        public String getDayuSignature() {
            return dayuSignature;
        }

        public Phone setDayuSignature(String dayuSignature) {
            this.dayuSignature = dayuSignature;
            return this;
        }

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public Phone setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public Phone setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
            return this;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.pay")
    public static class Pay extends Sdk.BaseThirdSdk implements Serializable {
        private String appId;
        private String appPrivateKey;
        private String notifyUrl;
        private String charset;
        private String alipayPublicKey;

        public String getAppId() {
            return appId;
        }

        public Pay setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public String getAppPrivateKey() {
            return appPrivateKey;
        }

        public Pay setAppPrivateKey(String appPrivateKey) {
            this.appPrivateKey = appPrivateKey;
            return this;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public Pay setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public String getCharset() {
            return charset;
        }

        public Pay setCharset(String charset) {
            this.charset = charset;
            return this;
        }

        public String getAlipayPublicKey() {
            return alipayPublicKey;
        }

        public Pay setAlipayPublicKey(String alipayPublicKey) {
            this.alipayPublicKey = alipayPublicKey;
            return this;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.ic-check")
    public static class IcCheck extends Sdk.BaseThirdSdk<IcCheckRequest> implements Serializable {
        private String appKey;
        private String appSecret;
        private String appCode;

        public String getAppKey() {
            return appKey;
        }

        public IcCheck setAppKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public IcCheck setAppSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public IcCheck setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.bank-check")
    public static class BankCheck extends Sdk.BaseThirdSdk<BankCheckRequest> implements Serializable {
        private String appCode;
        private String appKey;
        private String appSecret;

        public String getAppKey() {
            return appKey;
        }

        public BankCheck setAppKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public BankCheck setAppSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public BankCheck setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.ic-orc")
    public static class IcOrc extends Sdk.BaseThirdSdk<IcOrcRequest> implements Serializable {
        private String appKey;
        private String appSecret;
        private String appCode;

        public String getAppKey() {
            return appKey;
        }

        public IcOrc setAppKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public IcOrc setAppSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public IcOrc setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.id-check")
    public static class IdCheck extends Sdk.BaseThirdSdk<IdCheckRequest> implements Serializable {
        private String appKey;
        private String appSecret;
        private String appCode;

        public String getAppKey() {
            return appKey;
        }

        public IdCheck setAppKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public IdCheck setAppSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public String getAppCode() {
            return appCode;
        }

        public IdCheck setAppCode(String appCode) {
            this.appCode = appCode;
            return this;
        }
    }

    public Phone getPhone() {
        return phone;
    }

    public Ali setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public Pay getPay() {
        return pay;
    }

    public Ali setPay(Pay pay) {
        this.pay = pay;
        return this;
    }

    public IcCheck getIcCheck() {
        return icCheck;
    }

    public Ali setIcCheck(IcCheck icCheck) {
        this.icCheck = icCheck;
        return this;
    }

    public IcOrc getIcOrc() {
        return icOrc;
    }

    public Ali setIcOrc(IcOrc icOrc) {
        this.icOrc = icOrc;
        return this;
    }

    public IdCheck getIdCheck() {
        return idCheck;
    }

    public Ali setIdCheck(IdCheck idCheck) {
        this.idCheck = idCheck;
        return this;
    }

    public BankCheck getBankCheck() {
        return bankCheck;
    }

    public Ali setBankCheck(BankCheck bankCheck) {
        this.bankCheck = bankCheck;
        return this;
    }

    @Component
    @ConfigurationProperties(prefix = "third-service.ali.push")
    public static class Push extends Sdk.BaseThirdSdk implements Serializable {
        private String androidAppKey;
        private String androidAppSecret;
        private String iosAppKey;
        private String iosAppSecret;
        private String accessKeyId;
        private String accessKeySecret;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getAndroidAppKey() {
            return androidAppKey;
        }

        public void setAndroidAppKey(String androidAppKey) {
            this.androidAppKey = androidAppKey;
        }

        public String getAndroidAppSecret() {
            return androidAppSecret;
        }

        public void setAndroidAppSecret(String androidAppSecret) {
            this.androidAppSecret = androidAppSecret;
        }

        public String getIosAppKey() {
            return iosAppKey;
        }

        public void setIosAppKey(String iosAppKey) {
            this.iosAppKey = iosAppKey;
        }

        public String getIosAppSecret() {
            return iosAppSecret;
        }

        public void setIosAppSecret(String iosAppSecret) {
            this.iosAppSecret = iosAppSecret;
        }

    }
}

