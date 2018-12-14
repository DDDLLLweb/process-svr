package com.process.zuul.core.security.api;

import com.process.common.util.SecurityUtil;
import com.process.zuul.core.security.entity.PsClientCredentials;
import com.process.zuul.core.security.properties.PsZuulOauthProperties;
import com.process.zuul.core.security.rpc.PsBackendClient;
import com.process.zuul.core.security.rpc.PsOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sec")
public class PsZuulTokenApi {

    private final PsOAuthClient psOAuthClient;
    private final PsZuulOauthProperties zuulOauthProperties;
    private final PsBackendClient backendClient;


    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok(backendClient.getAllRoutes());
    }

    /**
     * csrf
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/csrf")
    public ResponseEntity csrf(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtil.createXsrfToken(request, response);
        return ResponseEntity.ok().build();
    }

    /**
     * 系统登陆
     * 根据用户名登录
     * 采用oauth2密码模式获取access_token和refresh_token
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody PsClientCredentials credentials) {
        credentials.decorator(zuulOauthProperties);
        return psOAuthClient.accessToken(credentials.tokenParams());
    }

}
