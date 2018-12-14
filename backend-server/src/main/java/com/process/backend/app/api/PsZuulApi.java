package com.process.backend.app.api;

import com.process.backend.app.service.PsZuulService;
import com.process.common.domain.PsZuulRouter;
import com.process.common.util.WebUtil;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PsZuulApi {

    private final PsZuulService zuulService;

    @GetMapping("/routes")
    public ResponseEntity<List<PsZuulRouter>> routes() {
        val routes = zuulService.routes();
        return WebUtil.ok(routes);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return WebUtil.ok("HHHHHDDDDDD");
    }

    @PatchMapping("/routes/refresh")
    public ResponseEntity refresh() {
        zuulService.refresh();
        return WebUtil.toResponseEntity();
    }
}
