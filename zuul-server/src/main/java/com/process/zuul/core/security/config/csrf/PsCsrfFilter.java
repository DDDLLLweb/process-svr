package com.process.zuul.core.security.config.csrf;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Danfeng
 * @since 2018/11/23
 */

public class PsCsrfFilter extends OncePerRequestFilter {
    private RequestMatcher requestMatcher;
    private boolean enable;
    private final AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();

    public PsCsrfFilter(RequestMatcher requestMatcher, boolean enableFilter) {
        this.requestMatcher = requestMatcher;
        this.enable = enableFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (enable && !requestMatcher.matches(request)) {
            accessDeniedHandler.handle(request, response, new AccessDeniedException(
                    "Missing or non-matching CSRF-token"));
            return;
        }
        filterChain.doFilter(request, response);
    }

}
