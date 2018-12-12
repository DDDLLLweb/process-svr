package com.process.backend.core.database.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@MapperScan({
        "com.process.backend.*.*.mapper",
        "com.process.backend.*.*.*.mapper",
})
@Configuration
public class PsMapperConfig {

}
