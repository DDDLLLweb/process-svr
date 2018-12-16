package com.process.auth.app.sys.service;

import com.process.auth.app.sys.mapper.PsAppUserMapper;
import com.process.auth.core.security.domain.PsAppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PsAppUserServiceImpl implements PsAppUserService {
    private final PsAppUserMapper appUserMapper;
    private static final BCryptPasswordEncoder bCryptPassword = new BCryptPasswordEncoder();
    private static final String DEFAULT_PASS = "password";

    @Transactional
    @Override
    public int optEntity(PsAppUser appUser) {
        if (appUser.isNew()) {
            appUser.setPassword(bCryptPassword.encode(DEFAULT_PASS));
            appUser.setEnabled(true);
            return appUserMapper.insertEntity(appUser);
        }
        return appUserMapper.updateEntity(appUser);
    }

    @Transactional
    @Override
    public int batchDelete(List<Long> ids) {
        return appUserMapper.batchDelete(ids);
    }

    @Override
    public int resetPwd(long id) {
        return appUserMapper.resetPwd(id,bCryptPassword.encode(DEFAULT_PASS));
    }

}
