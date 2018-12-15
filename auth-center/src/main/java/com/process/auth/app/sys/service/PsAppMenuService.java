package com.process.auth.app.sys.service;

import com.process.auth.app.sys.entity.PsAppMenuEntity;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/10
 */
public interface PsAppMenuService {
    /**
     * 获取菜单
     *
     * @param userId 用戶ID
     * @return 菜单集合
     */
    List<PsAppMenuEntity> menusOf(long userId);
}
