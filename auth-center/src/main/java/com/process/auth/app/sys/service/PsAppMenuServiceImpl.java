package com.process.auth.app.sys.service;

import com.process.auth.app.sys.entity.PsAppMenuEntity;
import com.process.auth.app.sys.mapper.PsAppMenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/23
 */
@Service
@RequiredArgsConstructor
public class PsAppMenuServiceImpl implements PsAppMenuService {

    private final PsAppMenuMapper menuMapper;

    @Override
    public List<PsAppMenuEntity> menusOf(long userId) {
        return menuMapper.menusOf(userId);
    }

    @Override
    public List<PsAppMenuEntity> menusByRoleId(long roleId) {
        return menuMapper.menusByRoleId(roleId);
    }

    @Override
    public List<PsAppMenuEntity> findList() {
        return menuMapper.findList();
    }

}
