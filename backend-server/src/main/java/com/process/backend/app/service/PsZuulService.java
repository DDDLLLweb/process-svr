package com.process.backend.app.service;

import com.process.common.domain.PsZuulRouter;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
public interface PsZuulService {

    /**
     * 查询所有的Zuul路由
     *
     * @return
     */
    List<PsZuulRouter> routes();

    /**
     * 刷新路由
     */
    void refresh();
}
