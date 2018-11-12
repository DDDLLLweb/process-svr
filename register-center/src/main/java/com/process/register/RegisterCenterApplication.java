package com.process.register;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Danfeng
 * @since 2018/11/12
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication {

    public static void main(String[] args) {
        log.info("PROCESS-REGISTER-CENTER START RUN...");
        SpringApplication.run(RegisterCenterApplication.class, args);
        log.info("PROCESS-REGISTER-CENTER STARTED");
    }

}
