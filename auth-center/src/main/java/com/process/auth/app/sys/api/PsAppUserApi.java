package com.process.auth.app.sys.api;

import com.process.auth.app.sys.mapper.PsAppUserMapper;
import com.process.auth.core.security.domain.PsAppUser;
import com.process.common.database.domain.PagingResult;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PsAppUserApi {

    private final PsAppUserMapper appUserMapper;

    @GetMapping("/users")
    public PagingResult<PsAppUser> pages(PsAppUserQuery query) {
        val total = appUserMapper.total(query);
        if (total > 0) {
            return PagingResult.of(appUserMapper.pages(query), total);
        }
        return PagingResult.empty();
    }

}
