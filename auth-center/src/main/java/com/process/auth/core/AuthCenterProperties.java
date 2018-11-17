package com.process.auth.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * @author Danfeng
 * @since 2018/11/17
 */
@Data
@RefreshScope
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthCenterProperties {
    private String sec;
}
