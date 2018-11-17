package com.process.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 权限中心
 *
 * @author Danfeng
 * @since 2018/11/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthCenterApplication.class, args);
    }
}
