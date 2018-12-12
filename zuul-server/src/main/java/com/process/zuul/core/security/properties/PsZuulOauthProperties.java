package com.process.zuul.core.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
@Data
@ConfigurationProperties(prefix = "ps.security.oauth2")
public class PsZuulOauthProperties {

    private String clientId;

    private String clientSecret;

    private boolean defaultSecret = true;

}
