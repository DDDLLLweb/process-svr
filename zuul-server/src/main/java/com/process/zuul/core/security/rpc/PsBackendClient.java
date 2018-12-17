package com.process.zuul.core.security.rpc;

import com.process.common.domain.PsZuulRouter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@FeignClient("backend-server")
public interface PsBackendClient {

    /**
     * 获取路由
     *
     * @return
     */
    @GetMapping(value = "/backend/api/routes")
    List<PsZuulRouter> getAllRoutes();
}
