package com.process.auth.app.sys.api;

import com.process.auth.app.sys.mapper.PsAppUserMapper;
import com.process.auth.app.sys.service.PsAppUserService;
import com.process.auth.core.security.domain.PsAppUser;
import com.process.common.database.domain.PagingResult;
import com.process.common.util.WebUtil;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PsAppUserApi {

    private final PsAppUserMapper appUserMapper;
    private final PsAppUserService appUserService;

    @GetMapping("/users")
    public PagingResult<PsAppUser> pages(PsAppUserQuery query) {
        val total = appUserMapper.total(query);
        if (total > 0) {
            return PagingResult.of(appUserMapper.pages(query), total);
        }
        return PagingResult.empty();
    }

    @PutMapping("/user")
    public ResponseEntity user(@RequestBody PsAppUser appUser) {
        return WebUtil.ok(appUserService.optEntity(appUser));
    }

    @DeleteMapping("/users")
    public ResponseEntity users(@RequestBody Long[] ids) {
        return WebUtil.ok(appUserService.batchDelete(Arrays.asList(ids)));
    }

}
