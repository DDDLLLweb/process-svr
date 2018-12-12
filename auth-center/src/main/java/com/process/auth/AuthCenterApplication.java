package com.process.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 权限中心
 *
 * @author Danfeng
 * @since 2018/11/17
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AuthCenterApplication {
    public static void main(String[] args) {
        log.info("AUTH-CENTER starting");
        SpringApplication.run(AuthCenterApplication.class, args);
        log.info("AUTH-CENTER started");
    }
}
