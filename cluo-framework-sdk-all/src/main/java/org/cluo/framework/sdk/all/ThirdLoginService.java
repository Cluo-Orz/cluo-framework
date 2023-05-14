package org.cluo.framework.sdk.all;

import org.cluo.framework.json.JSONUtil;
import org.cluo.framework.sdk.exception.QQException;
import org.cluo.framework.sdk.support.TencentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.cluo.framework.sdk.exception.WechatException;
import org.cluo.framework.sdk.all.tencent.Tencent;
import org.cluo.framework.sdk.all.tencent.api.login.qq.QQCheckRequest;
import org.cluo.framework.sdk.all.tencent.api.login.qq.QQCheckResponse;
import org.cluo.framework.sdk.all.tencent.api.login.qq.QQUserInfoResponse;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.app.AppCheckRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.app.AppUserInfoResponse;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.mini.MiniCheckRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.mini.MiniLoginResponse;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.mini.MiniUserInfoResponse;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.web.WebCheckRequest;
import org.cluo.framework.sdk.all.tencent.api.login.wechat.web.WebLoginResponse;
import org.cluo.framework.http.MediaType;

/**
 * In services--xin.dayukeji.common.service
 * Create in 00:16 2018/8/16
 *
 * @author canfuu
 * @version v1.0
 * descriotion 描述
 */
@Service
public class ThirdLoginService {

    @Autowired
    private Tencent tencent;
    private static final Logger logger = LoggerFactory.getLogger(ThirdLoginService.class);


    public MiniUserInfoResponse miniCheck(MiniCheckRequest request)  {
        return miniCheck(request,tencent.getWechatMini().getAppid(),tencent.getWechatMini().getSecret());
    }

    public WebLoginResponse webCheck(WebCheckRequest request) throws WechatException {
        return webCheck(request, tencent.getWechatWeb().getAppid(), tencent.getWechatWeb().getSecret());
    }
    public WebLoginResponse webCheck(WebCheckRequest request, String appid, String secret) throws WechatException {
        WebLoginResponse report = tencent.getWechatWeb().getLogin()
                .request()
                .getBody()
                .setAppid(appid)
                .setSecret(secret)
                .setCode(request.getCode())
                .closeBody()
                .setResponse(WebLoginResponse.class, MediaType.JSON).send();
        if (report==null) {
            throw new WechatException("reponse is null, call error.");
        }
        return report;
    }

    public MiniUserInfoResponse miniCheck(MiniCheckRequest request,String appid,String secret)  {
        logger.error("mini:request>>>"+request);
        // 登录状态失效 【想方设法】获取unionid
        Assert.notNull(request, "参数不为空");
        // 通过检查登录状态接口获取unionid
        MiniLoginResponse report  = tencent.getWechatMini().getLogin()
                .request()
                .getBody()
                .setAppid(appid)
                .setJs_code(request.getCode())
                .setSecret(secret)
                .closeBody()
                .setResponse(MiniLoginResponse.class, MediaType.JSON).send();

        if(report==null){
            throw new WechatException("call http error.");
        }
        if(report.getErrcode()!=null){

            throw new WechatException(report.getErrmsg());
        }
        MiniUserInfoResponse userInfoResponse;
        if(request.getAuth()!=null) {
            // 解密前端的userinfo 获取unionid
            TencentUtil.DecryptUtil decryptUtil = new TencentUtil.DecryptUtil();
            String userSecretInfo = null;
            try {
                userSecretInfo = decryptUtil.decrypt(request.getAuth().getEncryptedData(), report.getSession_key(), request.getAuth().getIv());
                logger.error("userSecretInfo>>>"+userSecretInfo);
            } catch (Exception e) {
                throw new WechatException("Secret", e);
            }
            if (userSecretInfo == null) {
                throw new WechatException("decrypt error.");
            }
            userInfoResponse = JSONUtil.toObjectFromString(userSecretInfo, MiniUserInfoResponse.class);
            if(userInfoResponse.getOpenId()==null){
                userInfoResponse.setOpenId(report.getOpenid());
            }
            if(userInfoResponse.getUnionId()==null){
                userInfoResponse.setUnionId(report.getUnionid());
            }
        } else {
            logger.error("no decrypt");
            userInfoResponse = new MiniUserInfoResponse();
            userInfoResponse.setOpenId(report.getOpenid());
            userInfoResponse.setUnionId(report.getUnionid());
        }
        if (userInfoResponse.getOpenId() == null || userInfoResponse.getOpenId().length() == 0) {
            throw new WechatException("UserInfoNotFound");
        }
        return userInfoResponse;
    }

    public AppUserInfoResponse appCheck(AppCheckRequest request) {
        AppUserInfoResponse report = tencent.getWechatApp().getUserInfo().request()
             .getBody()
                .setAccess_token(request.getToken())
                .setLang("zh_CN")
                .setOpenid(request.getOpenid())
            .closeBody()
            .setResponse(AppUserInfoResponse.class,MediaType.JSON).send();
        if (report == null || (report.getErrcode() != null && report.getErrcode() != 0) || report.getUnionid() == null) {
            throw new WechatException("UserInfoNotFound");
        }
        return report;
    }

    /**
     * QQ第三方登录获取用户openId
     * @param request request
     * @param response response
     * @return return
     * @ BaseDayuException
     */
    public QQCheckResponse qqCheck(QQCheckRequest request, QQUserInfoResponse response)  {
        QQCheckResponse report = tencent.getQq().getLogin().request()
                .getBody()
                    .setAccess_token(request.getAccess_token())
                    .setUnionid("1")
                .closeBody()
                .setResponse(QQCheckResponse.class,MediaType.JSON)
                .send();
        if (report == null) {
            throw new QQException("net error.");
        }
        return report;
    }

    /**
     * QQ第三方登录获取用户信息（网站第三方登录，不适用于移动端）
     * @param access_token access_token
     * @param openid openid
     * @return return
     */
    public QQUserInfoResponse qqUserInfo(String access_token, String openid) {
        QQUserInfoResponse report = tencent.getQq().getUserInfo().request().getBody()
                .setAccess_token(access_token)
                .setOauth_consumer_key(tencent.getQq().getAppId())
                .setOpenid(openid)
                .closeBody()
                .setResponse(QQUserInfoResponse.class, MediaType.JSON)
                .send();
        if(Long.valueOf(report.getRet()) != 0){
            throw new QQException("QQ获取信息失败："+report.getMsg());
        }

        return report;
    }
}
