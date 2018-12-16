package com.process.auth.app.sys.service;

import com.process.auth.app.sys.entity.PsAppRoleEntity;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
public interface PsAppRoleService {
    /**
     * 新增/修改
     *
     * @param appRoleEntity
     * @return
     */
    int optEntity(PsAppRoleEntity appRoleEntity);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    int batchDelete(List<Long> ids);

}
