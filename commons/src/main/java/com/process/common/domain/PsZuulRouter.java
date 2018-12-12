package com.process.common.domain;

import lombok.Data;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@Data
public class PsZuulRouter {

    private String id;

    private String fullPath;

    private String path;

    private String location;

    private String prefix;

    private Boolean retryable;

    private String sensitiveHeaders;

    private boolean customSensitiveHeaders;

    private boolean prefixStripped = true;

}
