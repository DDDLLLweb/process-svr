package com.process.zuul.core.security.api;

import com.process.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Danfeng
 * @since 2018/11/22
 */
@RestController
public class PsZuulTokenApi {

    /**
     * csrf
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/api/sec/csrf")
    public ResponseEntity csrf(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtil.createCsrfToken(request, response);
        return ResponseEntity.ok().build();
    }

}
