package com.process.auth.core.security.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PsAppUser extends PsAuthUser {

    private String nickname;
    private String headImgUrl;
    private String phone;
    private Integer sex;
    private transient boolean enabled;
    private String type;
}
