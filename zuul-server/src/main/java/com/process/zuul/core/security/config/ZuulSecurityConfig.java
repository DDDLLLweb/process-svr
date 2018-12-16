package com.process.zuul.core.security.config;

import com.process.common.util.SecurityUtil;
import com.process.zuul.core.security.config.csrf.PsCsrfFilter;
import com.process.zuul.core.security.properties.PsZuulCorsProperties;
import com.process.zuul.core.security.properties.PsZuulCsrfProperties;
import com.process.zuul.core.security.properties.PsZuulOauthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Danfeng
 * @since 2018/11/21
 */
@EnableOAuth2Sso
@EnableWebSecurity
@EnableConfigurationProperties({PsZuulCorsProperties.class, PsZuulCsrfProperties.class, PsZuulOauthProperties.class})
@RequiredArgsConstructor
public class ZuulSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PsZuulCorsProperties psZuulCorsProperties;
    private final PsZuulCsrfProperties psZuulCsrfProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF FILTER
        http.addFilterBefore(new PsCsrfFilter(SecurityUtil::checkXsrfToken, psZuulCsrfProperties.isEnable()), CsrfFilter.class).csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.cors().disable();
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(psZuulCorsProperties.isAllowCredentials());
        // #允许向该服务器提交请求的URI，*表示全部允许
        config.addAllowedOrigin(psZuulCorsProperties.getAllowedOrigins());
        // #允许访问的头信息,*表示全部
        config.addAllowedHeader(psZuulCorsProperties.getAllowedHeader());
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(psZuulCorsProperties.getMaxAge());
        // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod(psZuulCorsProperties.getAllowedMethods());
        source.registerCorsConfiguration(psZuulCorsProperties.getPath(), config);
        return new CorsFilter(source);
    }

}
