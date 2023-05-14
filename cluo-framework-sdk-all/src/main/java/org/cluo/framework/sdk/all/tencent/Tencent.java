package org.cluo.framework.sdk.all.tencent;

import org.cluo.framework.http.MediaType;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.mini.MiniPhoneNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.cluo.framework.sdk.all.Sdk;
import org.cluo.framework.sdk.all.tencent.api.im.*;
import org.cluo.framework.sdk.all.tencent.api.live.CommonAccessRequest;
import org.cluo.framework.sdk.all.tencent.api.live.api.LiveRecordRequest;
import org.cluo.framework.sdk.all.tencent.api.login.qq.QQCheckRequest;
import org.cluo.framework.sdk.all.tencent.api.login.qq.QQUserInfoRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.app.AppLoginRefreshRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.app.AppLoginRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.app.AppUserInfoRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.mini.MiniLoginRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.web.WebLoginRequest;
import org.cluo.framework.sdk.all.tencent.api.media.api.*;
import org.cluo.framework.sdk.all.tencent.api.mp.JsapiTicketRequest;
import org.cluo.framework.sdk.all.tencent.api.mp.MpCodeRequest;
import org.cluo.framework.sdk.all.tencent.api.mp.MpTokenRequest;
import org.cluo.framework.sdk.all.tencent.api.pay.*;

import java.io.Serializable;

/**
 * In services-org.cluo.framework.sdk.all.tencent
 * Create in 17:32 2018/8/23
 *
 * @author canfuu
 * version v1.0
 * descriotion 描述
 */
@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "third-service.tencent")  // 配置文件中的前缀
public class Tencent{
	@Autowired
	private Media media;
	@Autowired
	private Im im;
	@Autowired
	private QQ qq;
	@Autowired
	private WechatApp wechatApp;
	@Autowired
	private WechatMini wechatMini;
	@Autowired
	private WechatWeb wechatWeb;
	@Autowired
	private WechatMp wechatMp;
	@Autowired
	private WechatPay wechatPay;
	@Autowired
	private Live live;
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.live")  // 配置文件中的前缀
	public static class Live implements Serializable{
		private String appid;
		private String safeKey;
		private String bizid;
		private String appKey;
		private String pushDomain;
		private String playDomain;
		@Autowired
		private CommonAccess commonAccess;
		@Autowired
		private LiveRecord liveRecord;
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.live.common-access")
		public static class CommonAccess extends Sdk.BaseThirdSdk<CommonAccessRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.live.live-record")
		public static class LiveRecord extends Sdk.BaseThirdSdk<LiveRecordRequest> implements Serializable{
		}

		public LiveRecord getLiveRecord() {
			return liveRecord;
		}

		public Live setLiveRecord(LiveRecord liveRecord) {
			this.liveRecord= liveRecord;
			return this;
		}

		public CommonAccess getCommonAccess() {
			return commonAccess;
		}

		public Live setCommonAccess(CommonAccess commonAccess) {
			this.commonAccess = commonAccess;
			return this;
		}

		public String getAppid() {
			return appid;
		}

		public Live setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public String getSafeKey() {
			return safeKey;
		}

		public Live setSafeKey(String safeKey) {
			this.safeKey = safeKey;
			return this;
		}

		public String getBizid() {
			return bizid;
		}

		public Live setBizid(String bizid) {
			this.bizid = bizid;
			return this;
		}

		public String getAppKey() {
			return appKey;
		}

		public Live setAppKey(String appKey) {
			this.appKey = appKey;
			return this;
		}

		public String getPushDomain() {
			return pushDomain;
		}

		public Live setPushDomain(String pushDomain) {
			this.pushDomain = pushDomain;
			return this;
		}

		public String getPlayDomain() {
			return playDomain;
		}

		public Live setPlayDomain(String playDomain) {
			this.playDomain = playDomain;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.wechat-app")
	public static class WechatApp implements Serializable{
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-app.user-info")
		public static class UserInfo extends Sdk.BaseThirdSdk<AppUserInfoRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-app.login")
		public static class Login extends Sdk.BaseThirdSdk<AppLoginRequest> implements Serializable{
			private String appid;
			private String secret;

			public String getAppid() {
				return appid;
			}

			public Login setAppid(String appid) {
				this.appid = appid;
				return this;
			}

			public String getSecret() {
				return secret;
			}

			public Login setSecret(String secret) {
				this.secret = secret;
				return this;
			}
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-app.login-refresh")
		public static class LoginRefresh extends Sdk.BaseThirdSdk<AppLoginRefreshRequest> implements Serializable{
			private String appid;

			public String getAppid() {
				return appid;
			}

			public LoginRefresh setAppid(String appid) {
				this.appid = appid;
				return this;
			}
		}
		@Autowired
		private Login login;
		@Autowired
		private LoginRefresh loginRefresh;
		@Autowired
		private UserInfo userInfo;
		private String appid;
		private String secret;

		public Login getLogin() {
			return login;
		}

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public WechatApp setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
			return this;
		}

		public WechatApp setLogin(Login login) {
			this.login = login;
			return this;
		}

		public LoginRefresh getLoginRefresh() {
			return loginRefresh;
		}

		public WechatApp setLoginRefresh(LoginRefresh loginRefresh) {
			this.loginRefresh = loginRefresh;
			return this;
		}

		public String getAppid() {
			return appid;
		}

		public WechatApp setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public String getSecret() {
			return secret;
		}

		public WechatApp setSecret(String secret) {
			this.secret = secret;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay")
	public static class WechatPay implements Serializable{
		private MediaType mediaType;
		private String mchId;
		private String secret;
		private String  notifyUrl;
		private String refundNotify;
		@Autowired
		private Refund refund;
		@Autowired
		private OrderQuery orderQuery;
		@Autowired
		private Transfers transfers;
		@Autowired
		private UnifiedOrder unifiedOrder;
		@Autowired
		private GetTransferInfo getTransferInfo;
		@Autowired
		private TransBank transBank;
		@Autowired
		private RsaPublic rsaPublic;

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.get-transfers-info")
		public static class GetTransferInfo extends Sdk.BaseThirdSdk<GetTransferInfoRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.transfers")
		public static class Transfers extends Sdk.BaseThirdSdk<TransfersRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.trans-bank")
		public static class TransBank extends Sdk.BaseThirdSdk<TransBankRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.rsa-public")
		public static class RsaPublic extends Sdk.BaseThirdSdk<RsaPublicRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.order-query")
		public static class OrderQuery extends Sdk.BaseThirdSdk<OrderQueryRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.unified-order")
		public static class UnifiedOrder extends Sdk.BaseThirdSdk<UnifiedOrderRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-pay.refund")
		public static class Refund extends Sdk.BaseThirdSdk<RefundRequest> implements Serializable{

		}

		public GetTransferInfo getGetTransferInfo() {
			return getTransferInfo;
		}

		public WechatPay setGetTransferInfo(GetTransferInfo getTransferInfo) {
			this.getTransferInfo = getTransferInfo;
			return this;
		}

		public Transfers getTransfers() {
			return transfers;
		}

		public WechatPay setTransfers(Transfers transfers) {
			this.transfers = transfers;
			return this;
		}

		public TransBank getTransBank() {
			return transBank;
		}

		public WechatPay setTransBank(TransBank transBank) {
			this.transBank = transBank;
			return this;
		}

		public RsaPublic getRsaPublic() {
			return rsaPublic;
		}

		public WechatPay setRsaPublic(RsaPublic rsaPublic) {
			this.rsaPublic = rsaPublic;
			return this;
		}

		public String getRefundNotify() {
			return refundNotify;
		}

		public WechatPay setRefundNotify(String refundNotify) {
			this.refundNotify = refundNotify;
			return this;
		}

		public MediaType getMediaType() {
			return mediaType;
		}

		public OrderQuery getOrderQuery() {
			return orderQuery;
		}

		public WechatPay setOrderQuery(OrderQuery orderQuery) {
			this.orderQuery = orderQuery;
			return this;
		}

		public UnifiedOrder getUnifiedOrder() {
			return unifiedOrder;
		}

		public WechatPay setUnifiedOrder(UnifiedOrder unifiedOrder) {
			this.unifiedOrder = unifiedOrder;
			return this;
		}

		public WechatPay setMediaType(MediaType mediaType) {
			this.mediaType = mediaType;
			return this;
		}

		public String getMchId() {
			return mchId;
		}

		public WechatPay setMchId(String mchId) {
			this.mchId = mchId;
			return this;
		}

		public String getSecret() {
			return secret;
		}

		public WechatPay setSecret(String secret) {
			this.secret = secret;
			return this;
		}

		public String getNotifyUrl() {
			return notifyUrl;
		}

		public WechatPay setNotifyUrl(String notifyUrl) {
			this.notifyUrl = notifyUrl;
			return this;
		}

		public Refund getRefund() {
			return refund;
		}

		public WechatPay setRefund(Refund refund) {
			this.refund = refund;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.wechat-mini")
	public static class WechatMini implements Serializable{
		private String appid;
		private String secret;
		@Autowired
		private Login login;
		private MpCode mpCode;
		private MpAccessToken mpAccessToken;
		private MpPhoneNumber mpPhoneNumber;

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mini.mp-code")
		public static class MpCode extends Sdk.BaseThirdSdk<MpCodeRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mini.mp-access-token")
		public static class MpAccessToken extends Sdk.BaseThirdSdk<MpTokenRequest> implements Serializable{
		}

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mini.phone-number")
		public static class MpPhoneNumber extends Sdk.BaseThirdSdk<MiniPhoneNumberRequest> implements Serializable{
		}

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mini.login")
		public static class Login extends Sdk.BaseThirdSdk<MiniLoginRequest> implements Serializable{
			private String appid;
			private String secret;

			public String getAppid() {
				return appid;
			}

			public Login setAppid(String appid) {
				this.appid = appid;
				return this;
			}

			public String getSecret() {
				return secret;
			}

			public Login setSecret(String secret) {
				this.secret = secret;
				return this;
			}
		}

		public MpAccessToken getMpAccessToken() {
			return mpAccessToken;
		}

		public WechatMini setMpAccessToken(MpAccessToken mpAccessToken) {
			this.mpAccessToken = mpAccessToken;
			return this;
		}

		public MpCode getMpCode() {
			return mpCode;
		}

		public WechatMini setMpCode(MpCode mpCode) {
			this.mpCode = mpCode;
			return this;
		}

		public Login getLogin() {
			return login;
		}

		public WechatMini setLogin(Login login) {
			this.login = login;
			return this;
		}

		public String getAppid() {
			return appid;
		}

		public WechatMini setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public String getSecret() {
			return secret;
		}

		public WechatMini setSecret(String secret) {
			this.secret = secret;
			return this;
		}

		public MpPhoneNumber getMpPhoneNumber() {
			return mpPhoneNumber;
		}

		public WechatMini setMpPhoneNumber(MpPhoneNumber mpPhoneNumber) {
			this.mpPhoneNumber = mpPhoneNumber;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.wechat-web")
	public static class WechatWeb implements Serializable{
		private String appid;
		private String secret;
		@Autowired
		private Login login;

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-web.login")
		public static class Login extends Sdk.BaseThirdSdk<WebLoginRequest> implements Serializable{
			private String appid;
			private String secret;

			public String getAppid() {
				return appid;
			}

			public Login setAppid(String appid) {
				this.appid = appid;
				return this;
			}

			public String getSecret() {
				return secret;
			}

			public Login setSecret(String secret) {
				this.secret = secret;
				return this;
			}
		}

		public Login getLogin() {
			return login;
		}

		public WechatWeb setLogin(Login login) {
			this.login = login;
			return this;
		}


		public String getAppid() {
			return appid;
		}

		public WechatWeb setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public String getSecret() {
			return secret;
		}

		public WechatWeb setSecret(String secret) {
			this.secret = secret;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.wechat-mp")
	public static class WechatMp implements Serializable{
		private String appid;
		private String secret;

		@Autowired
		private WechatMp.MpAccessToken mpAccessToken;

		@Autowired
		private WechatMp.MpJsapiTicket mpJsapiTicket;

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mp.mp-access-token")
		public static class MpAccessToken extends Sdk.BaseThirdSdk<MpTokenRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.wechat-mp.mp-jsapi-ticket")
		public static class MpJsapiTicket extends Sdk.BaseThirdSdk<JsapiTicketRequest> implements Serializable{
		}

		public String getAppid() {
			return appid;
		}

		public WechatMp setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public String getSecret() {
			return secret;
		}

		public WechatMp setSecret(String secret) {
			this.secret = secret;
			return this;
		}

		public MpAccessToken getMpAccessToken() {
			return mpAccessToken;
		}

		public WechatMp setMpAccessToken(MpAccessToken mpAccessToken) {
			this.mpAccessToken = mpAccessToken;
			return this;
		}

		public MpJsapiTicket getMpJsapiTicket() {
			return mpJsapiTicket;
		}

		public WechatMp setMpJsapiTicket(MpJsapiTicket mpJsapiTicket) {
			this.mpJsapiTicket = mpJsapiTicket;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.qq")
	public static class QQ implements Serializable{
		@Autowired
		private Login login;
		@Autowired
		private UserInfo userInfo;
		private String appId;
		private String appKey;
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.qq.login")
		public static class Login extends Sdk.BaseThirdSdk<QQCheckRequest> implements Serializable{}

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.qq.user-info")
		public static class UserInfo extends Sdk.BaseThirdSdk<QQUserInfoRequest> implements Serializable{}

		public Login getLogin() {
			return login;
		}

		public QQ setLogin(Login login) {
			this.login = login;
			return this;
		}

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public QQ setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
			return this;
		}

		public String getAppId() {
			return appId;
		}

		public QQ setAppId(String appId) {
			this.appId = appId;
			return this;
		}

		public String getAppKey() {
			return appKey;
		}

		public QQ setAppKey(String appKey) {
			this.appKey = appKey;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.im")
	public static class Im implements Serializable{

		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.im.create-group")
		public static class CreateGroup extends Sdk.BaseThirdSdk<IMGroupCreateRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.im.account-import")
		public static class AccountImport extends Sdk.BaseThirdSdk<IMAccountImportRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.im.im-message")
		public static class ImMessage extends Sdk.BaseThirdSdk<ImMessageRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.im.portrait-set")
		public static class ChangeUserInfo extends Sdk.BaseThirdSdk<IMChangeUserInfoRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.im.im-group")
		public static class ImGroup extends Sdk.BaseThirdSdk<ImGroupRequest> implements Serializable{

		}

		private String sdkAppId;
		private String privateKey;
		private String publicKey;
		private String manager;
		@Autowired
		private CreateGroup createGroup;
		@Autowired
		private AccountImport accountImport;
		@Autowired
		private ImMessage imMessage;
		@Autowired
		private ChangeUserInfo changeUserInfo;
		@Autowired
		private ImGroup imGroup;

		public ChangeUserInfo getChangeUserInfo() {
			return changeUserInfo;
		}

		public Im setChangeUserInfo(ChangeUserInfo changeUserInfo) {
			this.changeUserInfo = changeUserInfo;
			return this;
		}

		public ImMessage getImMessage() {
			return imMessage;
		}

		public Im setImMessage(ImMessage imMessage) {
			this.imMessage = imMessage;
			return this;
		}

		public ImGroup getImGroup() {
			return imGroup;
		}

		public Im setImGroup(ImGroup imGroup) {
			this.imGroup = imGroup;
			return this;
		}

		public AccountImport getAccountImport() {
			return accountImport;
		}

		public Im setAccountImport(AccountImport accountImport) {
			this.accountImport = accountImport;
			return this;
		}

		public CreateGroup getCreateGroup() {
			return createGroup;
		}

		public Im setCreateGroup(CreateGroup createGroup) {
			this.createGroup = createGroup;
			return this;
		}

		public String getSdkAppId() {
			return sdkAppId;
		}

		public Im setSdkAppId(String sdkAppId) {
			this.sdkAppId = sdkAppId;
			return this;
		}

		public String getPrivateKey() {
			return privateKey;
		}

		public Im setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
			return this;
		}

		public String getPublicKey() {
			return publicKey;
		}

		public Im setPublicKey(String publicKey) {
			this.publicKey = publicKey;
			return this;
		}

		public String getManager() {
			return manager;
		}

		public Im setManager(String manager) {
			this.manager = manager;
			return this;
		}
	}
	@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
	@ConfigurationProperties(prefix = "third-service.tencent.media")
	public static class Media implements Serializable{
		private String appId;
		private String secretKey;
		private String secretId;
		@Autowired
		private GetMedia getMedia;
		@Autowired
		private PlayInfo getPlayInfo;
		@Autowired
		private EditMedia editMedia;
		@Autowired
		private GetTask getTask;
		@Autowired
		private CovertVodFile covertVodFile;
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.media.get-media")
		public static class GetMedia extends Sdk.BaseThirdSdk<MediaRequest> implements Serializable{

		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.media.covert-vod-file")
		public static class CovertVodFile extends Sdk.BaseThirdSdk<ConvertVodFileRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.media.play-info")
		public static class PlayInfo extends Sdk.BaseThirdSdk<SearchMediaRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.media.edit-media")
		public static class EditMedia extends Sdk.BaseThirdSdk<EditMediaRequest> implements Serializable{
		}
		@Component      //不加这个注解的话, 使用@Autowired 就不能注入进去了
		@ConfigurationProperties(prefix = "third-service.tencent.media.get-task")
		public static class GetTask extends Sdk.BaseThirdSdk<TaskRequest> implements Serializable{
		}

		public GetTask getGetTask() {
			return getTask;
		}

		public Media setGetTask(GetTask getTask) {
			this.getTask = getTask;
			return this;
		}

		public EditMedia getEditMedia() {
			return editMedia;
		}

		public Media setEditMedia(EditMedia editMedia) {
			this.editMedia = editMedia;
			return this;
		}

		public PlayInfo getGetPlayInfo() {
			return getPlayInfo;
		}

		public Media setGetPlayInfo(PlayInfo getPlayInfo) {
			this.getPlayInfo = getPlayInfo;
			return this;
		}

		public GetMedia getGetMedia() {
			return getMedia;
		}

		public Media setGetMedia(GetMedia getMedia) {
			this.getMedia = getMedia;
			return this;
		}

		public CovertVodFile getCovertVodFile() {
			return covertVodFile;
		}

		public Media setCovertVodFile(CovertVodFile covertVodFile) {
			this.covertVodFile = covertVodFile;
			return this;
		}

		public String getAppId() {
			return appId;
		}

		public Media setAppId(String appId) {
			this.appId = appId;
			return this;
		}

		public String getSecretKey() {
			return secretKey;
		}

		public Media setSecretKey(String secretKey) {
			this.secretKey = secretKey;
			return this;
		}

		public String getSecretId() {
			return secretId;
		}

		public Media setSecretId(String secretId) {
			this.secretId = secretId;
			return this;
		}
	}

	public Media getMedia() {
		return media;
	}

	public Tencent setMedia(Media media) {
		this.media = media;
		return this;
	}

	public Im getIm() {
		return im;
	}

	public Tencent setIm(Im im) {
		this.im = im;
		return this;
	}

	public QQ getQq() {
		return qq;
	}

	public Tencent setQq(QQ qq) {
		this.qq = qq;
		return this;
	}

	public WechatApp getWechatApp() {
		return wechatApp;
	}

	public Tencent setWechatApp(WechatApp wechatApp) {
		this.wechatApp = wechatApp;
		return this;
	}

	public WechatMini getWechatMini() {
		return wechatMini;
	}

	public Tencent setWechatMini(WechatMini wechatMini) {
		this.wechatMini = wechatMini;
		return this;
	}

	public WechatWeb getWechatWeb() {
		return wechatWeb;
	}

	public Tencent setWechatWeb(WechatWeb wechatWeb) {
		this.wechatWeb = wechatWeb;
		return this;
	}

	public WechatMp getWechatMp() {
		return wechatMp;
	}

	public Tencent setWechatMp(WechatMp wechatMp) {
		this.wechatMp = wechatMp;
		return this;
	}

	public Live getLive() {
		return live;
	}

	public Tencent setLive(Live live) {
		this.live = live;
		return this;
	}

	public WechatPay getWechatPay() {
		return wechatPay;
	}

	public Tencent setWechatPay(WechatPay wechatPay) {
		this.wechatPay = wechatPay;
		return this;
	}

}

