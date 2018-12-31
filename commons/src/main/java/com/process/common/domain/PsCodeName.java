package com.process.common.domain;

import lombok.Data;

/**
 * @author Danfeng
 * @since 2018/12/31
 */
@Data
public class PsCodeName {

    /**
     * key
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;
}
