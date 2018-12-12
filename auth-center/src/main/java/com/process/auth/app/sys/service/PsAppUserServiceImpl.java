package com.process.auth.app.sys.service;

import com.process.auth.app.sys.mapper.PsAppUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PsAppUserServiceImpl implements PsAppUserService {
    private final PsAppUserMapper appUserMapper;

}
