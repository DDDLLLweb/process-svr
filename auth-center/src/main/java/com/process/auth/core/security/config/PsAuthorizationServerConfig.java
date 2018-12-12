package com.process.auth.core.security.config;

import com.process.auth.core.security.service.PsRedisClientDetailsService;
import com.process.auth.core.security.service.RedisAuthorizationCodeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 授权服务器配置
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class PsAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PsRedisClientDetailsService redisClientDetailsService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final RedisConnectionFactory redisConnectionFactory;
    private final RedisAuthorizationCodeServices redisAuthorizationCodeServices;

    /**
     * 令牌存储
     */
//    @Bean
//    public TokenStore tokenStore() {
//        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
//        redisTokenStore.setAuthenticationKeyGenerator(new RandomAuthenticationKeyGenerator());
//        return redisTokenStore;
//    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients(); // 允许表单形式的认证
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager).userDetailsService(userDetailsService);
//        endpoints.tokenStore(tokenStore());
        // 授权码模式下，code存储
        endpoints.authorizationCodeServices(redisAuthorizationCodeServices);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(redisClientDetailsService);
        redisClientDetailsService.loadAllClientToCache();
    }

}
