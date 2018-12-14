package com.process.zuul.core.config.zuul.domain;

import com.process.common.domain.PsZuulRouter;
import com.process.zuul.core.security.rpc.PsBackendClient;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
public class PsDbRouterProvider implements PsRouterProvider {

    private final RedisTemplate<String, List<PsZuulRouter>> redisTemplate;
    private static final String CACHE_ROUTE_KEY = "CACHE_ROUTES";

    public PsDbRouterProvider(RedisTemplate<String, List<PsZuulRouter>> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<String> getIgnoredPaths() {
        return new ArrayList<>();
    }

    @Override
    public LinkedHashMap<String, ZuulProperties.ZuulRoute> getRoutes() {
        List<PsZuulRouter> dbRoutes = new ArrayList<>();
        Boolean hasKey = redisTemplate.hasKey(CACHE_ROUTE_KEY);
        if (Boolean.TRUE.equals(hasKey)) {
            dbRoutes = redisTemplate.opsForValue().get(CACHE_ROUTE_KEY);
        }
        return retireRoutes(dbRoutes);
    }

    private ZuulProperties.ZuulRoute retireRoute(PsZuulRouter zuulRouter) {
        Set<String> ignoredHeader = resolveIgnoredHeaders(zuulRouter.getSensitiveHeaders());
        return new ZuulProperties.ZuulRoute(zuulRouter.getServiceId(), zuulRouter.getPath(), zuulRouter.getServiceId(), zuulRouter.getUrl(), zuulRouter.isStripPrefix(), zuulRouter.getRetryable(), ignoredHeader);
    }

    private LinkedHashMap<String, ZuulProperties.ZuulRoute> retireRoutes(List<PsZuulRouter> zuulRouters) {
        List<ZuulProperties.ZuulRoute> zuulRouteAdapters = new ArrayList<>();
        if (!CollectionUtils.isEmpty(zuulRouters)) {
            zuulRouters.forEach(route -> zuulRouteAdapters.add(retireRoute(route)));
        }
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        for (ZuulProperties.ZuulRoute zuulRoute : zuulRouteAdapters) {
            routesMap.put(zuulRoute.getPath(), zuulRoute);
        }
        return routesMap;
    }

    private Set<String> resolveIgnoredHeaders(String ignoredHeaders) {
        Set<String> ignoredHeadSet = new LinkedHashSet<>();
        if (StringUtils.hasText(ignoredHeaders)) {
            String[] options = ignoredHeaders.split(",");
            ignoredHeadSet = new LinkedHashSet<>(Arrays.asList(options));
        }
        return ignoredHeadSet;
    }
}
