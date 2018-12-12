package com.process.zuul.core.config.zuul.domain;

import org.springframework.cloud.netflix.zuul.filters.Route;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
public class PsDbRouterProvider implements PsRouterProvider{

    @Override
    public List<String> getIgnoredPaths() {
        return null;
    }

    @Override
    public List<Route> getRoutes() {
        return null;
    }

}
