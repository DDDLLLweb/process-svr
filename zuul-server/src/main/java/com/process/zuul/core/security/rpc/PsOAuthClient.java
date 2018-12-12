package com.process.zuul.core.security.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Danfeng
 * @since 2018/11/26
 */
@FeignClient("auth-center")
public interface PsOAuthClient {

    /**
     * 获取access_token
     *
     * @return token
     */
    @PostMapping(path = "/auth/oauth/token")
    Map<String, Object> accessToken(@RequestParam Map<String, String> parameters);


}
