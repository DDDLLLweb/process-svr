package com.process.zuul.core.config.zuul.config;

import com.process.common.domain.PsZuulRouter;
import com.process.zuul.core.config.zuul.domain.PsDbRouterProvider;
import com.process.zuul.core.config.zuul.domain.PsRouterLocator;
import com.process.zuul.core.security.rpc.PsBackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.client.discovery.event.HeartbeatMonitor;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@Configuration
@RequiredArgsConstructor
public class PsZuulConfig {

    private final DispatcherServletPath servletPath;
    private final PsBackendClient backendClient;
    private final ZuulProperties properties;
    private final RedisTemplate<String, List<PsZuulRouter>> redisTemplate;

    @Bean
    @ConditionalOnMissingBean(PsDbRouterProvider.class)
    public PsDbRouterProvider psDbRouterProvider() {
        return new PsDbRouterProvider(redisTemplate);
    }

    @Bean
    public PsRouterLocator psRouterLocator() {
        PsRouterLocator psRouterLocator = new PsRouterLocator(this.servletPath.getPrefix(), properties);
        psRouterLocator.setPsRouterProvider(psDbRouterProvider());
        return psRouterLocator;
    }

    @Primary
    @Bean
    public ApplicationListener<ApplicationEvent> zuulRefreshRoutesListener() {
        return new ZuulRefreshListener();
    }

    private static class ZuulRefreshListener
            implements ApplicationListener<ApplicationEvent> {

        @Autowired
        private ZuulHandlerMapping zuulHandlerMapping;

        private HeartbeatMonitor heartbeatMonitor = new HeartbeatMonitor();

        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            if (event instanceof ContextRefreshedEvent
                    || event instanceof RefreshScopeRefreshedEvent
                    || event instanceof RoutesRefreshedEvent) {
                //设置为脏,下一次匹配到路径时，如果发现为脏，则会去刷新路由信息
                this.zuulHandlerMapping.setDirty(true);
            } else if (event instanceof HeartbeatEvent) {
                if (this.heartbeatMonitor.update(((HeartbeatEvent) event).getValue())) {
                    this.zuulHandlerMapping.setDirty(true);
                }
            }
        }
    }

}
