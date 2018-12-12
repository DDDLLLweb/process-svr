package com.process.zuul.core.security.rpc;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@FeignClient("backend-server")
public interface PsBackendClient {

}
