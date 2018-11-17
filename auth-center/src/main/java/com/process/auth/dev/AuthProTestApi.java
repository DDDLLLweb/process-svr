package com.process.auth.dev;

import com.process.auth.core.AuthCenterProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Danfeng
 * @since 2018/11/17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class AuthProTestApi {

    private final AuthCenterProperties authCenterProperties;

    @GetMapping("/properties")
    public String getPro() {
        return authCenterProperties.getSec();
    }

}
