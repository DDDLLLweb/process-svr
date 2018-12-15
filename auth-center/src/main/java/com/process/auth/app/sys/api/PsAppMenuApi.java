package com.process.auth.app.sys.api;

import com.process.auth.app.sys.service.PsAppMenuService;
import com.process.auth.core.security.domain.PsAppUser;
import com.process.common.util.WebUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Danfeng
 * @since 2018/9/15
 */
@Slf4j
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PsAppMenuApi {


    private final PsAppMenuService menuService;

    @GetMapping("/menus")
    public ResponseEntity menus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PsAppUser psAuthUser = (PsAppUser) authentication.getPrincipal();
        log.debug("principal-me:{}", (PsAppUser) authentication.getPrincipal());
        return WebUtil.okBuilder().body(menuService.menusOf(psAuthUser.getId()));
    }

}
