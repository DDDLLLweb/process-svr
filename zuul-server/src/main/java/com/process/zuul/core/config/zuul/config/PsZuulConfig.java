package com.process.zuul.core.config.zuul.config;

import com.process.zuul.core.config.zuul.domain.PsDbRouterProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@Configuration
public class PsZuulConfig {


    @Bean
    @ConditionalOnMissingBean(PsDbRouterProvider.class)
    public PsDbRouterProvider psDbRouterProvider() {
        return new PsDbRouterProvider();
    }

}
