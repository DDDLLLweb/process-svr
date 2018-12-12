package com.process.zuul.core.config.zuul.domain;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
public abstract class PsAbstractRouterLocaterResolver implements RouteLocator {

    private ZuulProperties zuulProperties;
    private PsRouterProvider routerProvider;
    private PathMatcher pathMatcher = new AntPathMatcher();

    public PsAbstractRouterLocaterResolver(PsRouterProvider routerProvider, ZuulProperties zuulProperties) {
        this.zuulProperties = zuulProperties;
        this.routerProvider = routerProvider;
    }

    public PsAbstractRouterLocaterResolver(PsRouterProvider routerProvider, ZuulProperties zuulProperties, PathMatcher pathMatcher) {
        this.zuulProperties = zuulProperties;
        this.routerProvider = routerProvider;
        this.pathMatcher = pathMatcher;
    }

    @Override
    public Collection<String> getIgnoredPaths() {
        return routerProvider.getIgnoredPaths();
    }

    @Override
    public Route getMatchingRoute(String path) {
        List<Route> filterRoters = routerProvider.getRoutes().stream().filter(route -> this.pathMatcher.match(path, route.getPath())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(filterRoters)) {
            return filterRoters.get(0);
        }
        return null;
    }

}
