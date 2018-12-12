package com.process.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 微服务管理
 *
 * @author Danfeng
 * @since 2018/12/12
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BackendServerApplication {
    public static void main(String[] args) {
        log.info("BACKEND STARTING...");
        SpringApplication.run(BackendServerApplication.class, args);
        log.info("BACKEND STARTED...");
    }
}
