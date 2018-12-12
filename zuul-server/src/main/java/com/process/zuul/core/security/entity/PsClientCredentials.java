package com.process.zuul.core.security.entity;

import com.process.zuul.core.security.properties.PsZuulOauthProperties;
import lombok.Data;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Danfeng
 * @since 2018/12/5
 */
@Data
public class PsClientCredentials {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String CLIENT_SECRET = "client_secret";

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端ID
     */
    private String clientSecret;

    /**
     * 认证类型
     */
    private String grantType;

    /**
     * 权限领域
     */
    private String scope;

    /**
     * 刷新token
     */
    private String refreshToken;

    public void decorator(PsZuulOauthProperties zuulOauthProperties) {
        this.clientId = zuulOauthProperties.getClientId();
        if (!zuulOauthProperties.isDefaultSecret()) {
            this.clientSecret = zuulOauthProperties.getClientSecret();
        }
    }

    public Map<String, String> tokenParams() {
        Map<String, String> parameters = new HashMap<>(5);
        parameters.put(OAuth2Utils.GRANT_TYPE, this.grantType);
        parameters.put(OAuth2Utils.SCOPE, this.scope);
        parameters.put(OAuth2Utils.CLIENT_ID, this.clientId);
        parameters.put(CLIENT_SECRET, this.clientSecret);
        if (StringUtils.hasText(this.username)) {
            parameters.put(USERNAME, this.username);
        }
        if (StringUtils.hasText(this.password)) {
            parameters.put(PASSWORD, this.password);
        }
        if (StringUtils.hasText(this.refreshToken)) {
            parameters.put(REFRESH_TOKEN, this.refreshToken);
        }
        return parameters;
    }

}
